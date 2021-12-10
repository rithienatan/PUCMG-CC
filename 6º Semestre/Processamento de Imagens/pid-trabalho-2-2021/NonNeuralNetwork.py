###
# Matéria: Processamento de Imagens
#
# @author Heleny Maria Diniz Bessa | Matrícula: 553250
# @author Rithie Natan Carvalhaes Prado | Matrícula: 541488
###
###---------- Imports ----------
from keras.models import load_model
import numpy as np
from scipy.stats import truncnorm


###---------- Custom Imports ----------
import mnist


###---------- Class ----------
class NeuralNetwork:  
    def __init__(self, 
                 no_of_in_nodes, 
                 no_of_out_nodes, 
                 no_of_hidden_nodes,
                 learning_rate):
        self.no_of_in_nodes = no_of_in_nodes
        self.no_of_out_nodes = no_of_out_nodes
        self.no_of_hidden_nodes = no_of_hidden_nodes
        self.learning_rate = learning_rate 
        self.create_weight_matrices()
        
    def create_weight_matrices(self):
        """ 
        A method to initialize the weight 
        matrices of the neural network
        """
        rad = 1 / np.sqrt(self.no_of_in_nodes)
        X = truncated_normal(mean=0, 
                             sd=1, 
                             low=-rad, 
                             upp=rad)
        self.wih = X.rvs((self.no_of_hidden_nodes, 
                                       self.no_of_in_nodes))
        rad = 1 / np.sqrt(self.no_of_hidden_nodes)
        X = truncated_normal(mean=0, sd=1, low=-rad, upp=rad)
        self.who = X.rvs((self.no_of_out_nodes, 
                                         self.no_of_hidden_nodes))
        
    
    def train(self, input_vector, target_vector):
        """
        input_vector and target_vector can 
        be tuple, list or ndarray
        """
        
        input_vector = np.array(input_vector, ndmin=2).T
        target_vector = np.array(target_vector, ndmin=2).T
        
        output_vector1 = np.dot(self.wih, 
                                input_vector)
        output_hidden = activation_function(output_vector1)
        
        output_vector2 = np.dot(self.who, 
                                output_hidden)
        output_network = activation_function(output_vector2)
        
        output_errors = target_vector - output_network
        # update the weights:
        tmp = output_errors * output_network \
              * (1.0 - output_network)     
        tmp = self.learning_rate  * np.dot(tmp, 
                                           output_hidden.T)
        self.who += tmp


        # calculate hidden errors:
        hidden_errors = np.dot(self.who.T, 
                               output_errors)
        # update the weights:
        tmp = hidden_errors * output_hidden * \
              (1.0 - output_hidden)
        self.wih += self.learning_rate \
                          * np.dot(tmp, input_vector.T)
        
    def run(self, input_vector):
        # input_vector can be tuple, list or ndarray
        input_vector = np.array(input_vector, ndmin=2).T

        output_vector = np.dot(self.wih, 
                               input_vector)
        output_vector = activation_function(output_vector)
        
        output_vector = np.dot(self.who, 
                               output_vector)
        output_vector = activation_function(output_vector)
    
        return output_vector
            
    def confusion_matrix(self, data_array, labels):
        cm = np.zeros((10, 10), int)
        for i in range(len(data_array)):
            res = self.run(data_array[i])
            res_max = res.argmax()
            target = labels[i][0]
            cm[res_max, int(target)] += 1
        return cm    

    def precision(self, label, confusion_matrix):
        col = confusion_matrix[:, label]
        return confusion_matrix[label, label] / col.sum()
    
    def recall(self, label, confusion_matrix):
        row = confusion_matrix[label, :]
        return confusion_matrix[label, label] / row.sum()
        
    
    def evaluate(self, data, labels):
        corrects, wrongs = 0, 0
        for i in range(len(data)):
            res = self.run(data[i])
            res_max = res.argmax()
            if res_max == labels[i]:
                corrects += 1
            else:
                wrongs += 1
        return corrects, wrongs


###---------- Methods ----------
@np.vectorize
def sigmoid(x):
    return 1 / (1 + np.e ** -x)
activation_function = sigmoid

def truncated_normal(mean=0, sd=1, low=0, upp=10):
    return truncnorm((low - mean) / sd, 
                     (upp - mean) / sd, 
                     loc=mean, 
                     scale=sd)

###------
# Executa uma rede neural
###------
def neuralnetmodel():
    raw_train = mnist.read_idx("mnist-data-base/train-images.idx3-ubyte")
    train_data = np.reshape(raw_train, (60000, 28*28))
    train_label = mnist.read_idx("mnist-data-base/train-labels.idx1-ubyte")

    raw_test = mnist.read_idx("mnist-data-base/t10k-images.idx3-ubyte")
    test_data = np.reshape(raw_test, (10000, 28*28))
    test_label = mnist.read_idx("mnist-data-base/t10k-labels.idx1-ubyte")

    idx = (train_label == 4) | (train_label == 5) | (train_label == 6)
    X = train_data[idx]/255.0
    Y = train_label[idx]

    idx = (test_label == 4) | (test_label == 5) | (test_label == 6)
    x_test = test_data[idx]/255.0
    y_test = test_label[idx]


    simpleNeuralNet = NeuralNetwork(no_of_in_nodes = 28*28, 
                                    no_of_out_nodes = 10, 
                                    no_of_hidden_nodes = 100,
                                    learning_rate = 0.1)

    for i in range(len(X)):
        simpleNeuralNet.train(X[i], Y[i])

    for i in range(20):
        res = simpleNeuralNet.run(x_test[i])
        print(y_test[i], np.argmax(res), np.max(res))

    corrects, wrongs = simpleNeuralNet.evaluate(X, Y)
    print("accuracy train: ", corrects / ( corrects + wrongs))
    corrects, wrongs = simpleNeuralNet.evaluate(x_test, y_test)
    print("accuracy: test", corrects / ( corrects + wrongs))

    return simpleNeuralNet