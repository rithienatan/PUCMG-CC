###
# Matéria: Processamento de Imagens
#
# @author Heleny Maria Diniz Bessa | Matrícula: 553250
# @author Rithie Natan Carvalhaes Prado | Matrícula: 541488
###
###---------- Imports ----------
from keras.models import Sequential
from sklearn import metrics
import numpy as np
from sklearn.neighbors import DistanceMetric
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report
import sklearn


###---------- Custom Imports ----------
import mnist


###---------- Methods ----------
###------
# Pré define o modelo, treina e salva
###------
def mahalanobismodel():
    raw_train = mnist.read_idx("mnist-data-base/train-images.idx3-ubyte")
    train_data = np.reshape(raw_train, (60000, 28*28))
    train_label = mnist.read_idx("mnist-data-base/train-labels.idx1-ubyte")

    raw_test = mnist.read_idx("mnist-data-base/t10k-images.idx3-ubyte")
    test_data = np.reshape(raw_test, (10000, 28*28))
    test_label = mnist.read_idx("mnist-data-base/t10k-labels.idx1-ubyte")

    idx = (train_label == 7) | (train_label == 8) | (train_label == 9)
    X = train_data[idx]/255.0
    Y = train_label[idx]

    idx = (test_label == 7) | (test_label == 8) | (test_label == 9)
    x_test = test_data[idx]/255.0
    y_test = test_label[idx]

    # initialize the values of k for our k-Nearest Neighbor classifier along with the
    # list of accuracies for each value of k
    kVals = range(1, 30, 2)
    accuracies = []

    # loop over various values of `k` for the k-Nearest Neighbor classifier
    for k in range(1, 30, 2):
        # train the k-Nearest Neighbor classifier with the current value of `k`
        #model = KNeighborsClassifier(n_neighbors=k, metric='mahalanobis', metric_params={'V': np.cov(X, rowvar = False), 'VI': np.cov(Y, rowvar = False)})
        model = KNeighborsClassifier(n_neighbors=k)
        model.fit(X, Y)

        # evaluate the model and update the accuracies list
        score = model.score(x_test, y_test)
        print("k=%d, accuracy=%.2f%%" % (k, score * 100))
        accuracies.append(score)

    # find the value of k that has the largest accuracy
    i = int(np.argmax(accuracies))
    print("k=%d achieved highest accuracy of %.2f%% on validation data" % (kVals[i],
        accuracies[i] * 100))

    # re-train our classifier using the best k value and predict the labels of the
    # test data
    #model = KNeighborsClassifier(n_neighbors=kVals[i], metric='mahalanobis', metric_params={'V': np.cov(X, rowvar = False), 'VI': np.cov(Y, rowvar = False)})
    model = KNeighborsClassifier(n_neighbors=kVals[i])
    model.fit(X, Y)
    predictions = model.predict(x_test)

    # show a final classification report demonstrating the accuracy of the classifier
    # for each of the digits
    print("EVALUATION ON TESTING DATA")
    print(classification_report(y_test, predictions))

    return model



###------
# metricas da mahalanobis
###------
def mahalanobismetrics(y_test, y_pred):
    print("Accuracy:", metrics.accuracy_score(y_test, y_pred))
    print("Precision:", metrics.precision_score(y_test, y_pred))
    print("Recall:", metrics.recall_score(y_test, y_pred))