###
# Matéria: Processamento de Imagens
#
# @author Heleny Maria Diniz Bessa | Matrícula: 553250
# @author Rithie Natan Carvalhaes Prado | Matrícula: 541488
###
###---------- Imports ----------
import numpy as np
from sklearn import svm, metrics


###---------- Custom Imports ----------
import mnist


###---------- Global Variables ----------


###---------- Methods ----------
###------
# Pré define o modelo, treina e salva
# train_X, train_Y, test_X
###------
def svmodel():
    raw_train = mnist.read_idx("mnist-data-base/train-images.idx3-ubyte")
    train_data = np.reshape(raw_train, (60000, 28*28))
    train_label = mnist.read_idx("mnist-data-base/train-labels.idx1-ubyte")

    raw_test = mnist.read_idx("mnist-data-base/t10k-images.idx3-ubyte")
    test_data = np.reshape(raw_test, (10000, 28*28))
    test_label = mnist.read_idx("mnist-data-base/t10k-labels.idx1-ubyte")

    idx = (train_label == 0) | (train_label == 1) | (train_label == 2) | (train_label == 3)
    X = train_data[idx]/255.0
    Y = train_label[idx]
    clf = svm.SVC(kernel='linear')
    clf.fit(X, Y)


    idx = (test_label == 0) | (test_label == 1) | (test_label == 2) | (test_label == 3)
    x_test = test_data[idx]/255.0
    y_test = test_label[idx]
    y_pred = clf.predict(x_test)

    # metricas python
    print("Accuracy:", metrics.accuracy_score(y_test, y_pred))
    
    return clf