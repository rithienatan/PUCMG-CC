###
# Matéria: Processamento de Imagens
#
# @author Heleny Maria Diniz Bessa | Matrícula: 553250
# @author Rithie Natan Carvalhaes Prado | Matrícula: 541488
###

###---------- Imports ----------
import struct
import numpy as np
from keras.datasets import mnist
from tensorflow.keras.utils import to_categorical
from matplotlib import pyplot


###---------- functions ----------
###------
# Read mnist files
###------
def read_idx(filename):
    with open(filename, 'rb') as f:
        zero, data_type, dims = struct.unpack('>HBB', f.read(4))
        shape = tuple(struct.unpack('>I', f.read(4))[0] for d in range(dims))
        return np.fromstring(f.read(), dtype=np.uint8).reshape(shape)


###------ 
# load train and test dataset
###------ 
def load_dataset():
    (trainX, trainY), (testX, testY) = mnist.load_data()

	# reshape dataset to have a single channel
    trainX = trainX.reshape((trainX.shape[0], 28, 28, 1))
    testX = testX.reshape((testX.shape[0], 28, 28, 1))
	
    #one hot encode target values
    trainY = to_categorical(trainY)
    testY = to_categorical(testY)
	
    return trainX, trainY, testX, testY


###------ 
# scale pixels
###------
def prep_pixels(train, test):
	# convert from integers to floats
	train_norm = train.astype('float32')
	test_norm = test.astype('float32')
	# normalize to range 0-1
	train_norm = train_norm / 255.0
	test_norm = test_norm / 255.0
	# return normalized images
	return train_norm, test_norm

###
# ----------
# Plot imagens
# ----------
###
'''
train_X = read_idx("mnist-data-base/train-images.idx3-ubyte")

for i in range(1):  
    print(train_X[i])
    pyplot.subplot(330 + 1 + i)
    pyplot.imshow(train_X[i], cmap=pyplot.get_cmap('gray'))

pyplot.show()
'''