###
# Matéria: Processamento de Imagens
#
# @author Heleny Maria Diniz Bessa | Matrícula: 553250
# @author Rithie Natan Carvalhaes Prado | Matrícula: 541488
###
###---------- Imports ----------
import cv2
import numpy as np
import mahotas
from matplotlib import pyplot
from PIL import Image
import PIL
from keras.preprocessing.image import load_img
from keras.preprocessing.image import img_to_array
import time


###---------- Custom Imports ----------
import mnist
import svm
import NonNeuralNetwork as nnn
import MahalanobisClassifier as MC


###---------- Main ----------
start_time = time.time()

###
# ----------
# Preparando os classificadores
# ----------
###
# Loading dataset and shape
#train_X, train_y, test_X, test_y = mnist.load_dataset()
#train_X, test_X = mnist.prep_pixels(train_X, test_X)

# 60000 para treinos e 10000 para testes
#print("----------")
#print('X_train: ' + str(train_X.shape))
#print('Y_train: ' + str(train_y.shape))
#print('X_test:  '  + str(test_X.shape))
#print('Y_test:  '  + str(test_y.shape))
#print("----------")

# training svm
#svm.svmodel(train_X=train_X, train_Y=train_y, test_X=test_X)
print()
print("SVM----------------")
svmTime = time.time()
SVM = svm.svmodel()
print("--- SVM %s seconds ---" % (time.time() - svmTime))
print("End SVM----------------")
print()

# training Non Convolutional Neural Network
print()
print("NeuralNet----------------")
nnnTime = time.time()
NNN = nnn.neuralnetmodel()
print("--- NNN %s seconds ---" % (time.time() - nnnTime))
print("End NeuralNet----------------")
print()

# training Mahalanobis Classifier
print()
print("Mahalanobis----------------")
mcTime = time.time()
MC = MC.mahalanobismodel()
print("--- MC %s seconds ---" % (time.time() - mcTime))
print("End Mahalanobis----------------")
print()

###
# ----------
# Leitura da entrada de arquivo de imagem do usuário
# ----------
###
#print("Insira o caminho para a imagem: ")
#input()


###
# ----------
# Leitura da entrada de arquivo de imagem do usuário
# ----------
###
# Leitura da imagem com a função imread()
imagem  = cv2.imread('exemplos/II.jpg')   
print('Largura em pixels: ', end='')   
print(imagem.shape[1]) 

#largura da imagem   
print('Altura em pixels: ', end='')   
print(imagem.shape[0]) 

#altura da imagem   
print('Qtde de canais: ', end='')   
print(imagem.shape[2])   

#Passo 1: Conversão para tons de cinza 
img = cv2.cvtColor(imagem, cv2.COLOR_BGR2GRAY) 

#Passo 2: Blur/Suavização da imagem 
suave = cv2.blur(img, (8, 8))


#Passo 3: Binarização resultando em pixels brancos e pretos 
T = mahotas.thresholding.otsu(suave) 
bin = suave.copy() 
bin[bin > T] = 255
bin[bin < 255] = 0 
bin = cv2.bitwise_not(bin)

#Passo 4:  Detecção de bordas com Canny 
bordas = cv2.Canny(bin, 70, 150) 

#Passo 5: Identificação  e contagem dos contornos da imagem 
#cv2.RETR_EXTERNAL = conta apenas os contornos externos 
#A  variável lixo recebe dados que não são  utilizados 
(numeros, lixo) = cv2.findContours(bordas.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)


###
# ----------
# Itera dentro dos números achados com contorno.
# Aplica os classificadores para cada um dos números
# ----------
###
# Iterate thorugh contours and filter for ROI
image_number = 0
for c in numeros:
    # recorta cada número da imagem
    x,y,w,h = cv2.boundingRect(c)
    #cv2.rectangle(imagem, (x, y), (x + w, y + h), (36,255,12), 2)

    # Conversão de tons de cinza, suavizacão e binarizacão.
    ROI = imagem.copy()[y:y+h, x:x+w]
    ROI = cv2.cvtColor(ROI, cv2.COLOR_BGR2GRAY)
    ROI = cv2.blur(ROI, (8, 8))
    digitUnique = mahotas.thresholding.otsu(ROI) 
    bin = ROI.copy() 
    bin[bin > digitUnique] = 255
    bin[bin < 255] = 0 
    bin = cv2.bitwise_not(bin)

    # resize, para aproximar com a base do mnist
    ROI = cv2.resize(bin, (18, 18)) 
    ROI = np.pad(ROI, ((5, 5), (5, 5)), "constant", constant_values=0)
    
    # Armazena o número recortado em uma pasta temporária
    cv2.imwrite("temp-numbers/number_temp_{}.png".format(image_number), ROI)

    # load the image
    #testImage = load_img("temp-numbers/number_temp_{}.png".format(image_number), grayscale=True, target_size=(28, 28))
    #testImage = load_img("temp-numbers/number_temp_{}.png".format(image_number), grayscale=True)
    testImage = load_img("temp-numbers/number_temp_{}.png".format(image_number), color_mode="grayscale")
	# convert to array
    testImage = img_to_array(testImage)
	# reshape into a single sample with 1 channel
    testImage = np.reshape(testImage, (1, 28*28))
    testImage = testImage/255.0

    print()
    print("---------------------")
    print("Image {}".format(image_number))
    svmpredict = SVM.predict(testImage)
    print("SVM predict: {}".format(svmpredict))

    nnnpredict = NNN.run(testImage)
    print("NNN predict: {} {} {}".format(nnnpredict, np.argmax(nnnpredict), np.max(nnnpredict)))

    mahalanobispredict = MC.predict(testImage)
    print("Mahalanobis predict: {}".format(mahalanobispredict))
    print("---------------------")
    print()

    image_number += 1


###
# ----------
# Mostra a imagem compiladas em apenas uma tela com 
# tons de cinza, suavização da imagem, binariazão e contornos
# ----------
###
#temp = np.vstack([np.hstack([img, suave]), np.hstack([bin, bordas])])
#cv2.imshow("Quantidade de objetos: "+str(len(numeros)), temp)
#cv2.waitKey(0)


###
# ----------
# Mostra a imagem original com todos os números identificados
# ----------
###
for c in numeros:
    x,y,w,h = cv2.boundingRect(c)
    cv2.rectangle(imagem, (x, y), (x + w, y + h), (36,255,12), 2)
    ROI = imagem.copy()[y:y+h, x:x+w]

imgC2 = imagem.copy() 
cv2.imshow("Imagem Original", imagem)
cv2.waitKey(0)


###
# ----------
# Mostra o resultado final da imagem com contornos
# ----------
###
#cv2.drawContours(imgC2, numeros,  -1, (255, 0, 0), 2) 
#escreve(imgC2, str(len(numeros))+" objetos encontrados!") 
#cv2.imshow("Resultado", imgC2)
#cv2.waitKey(0)


###
# ----------
# Encerra o programa
# ----------
###
cv2.destroyAllWindows()

print("--- %s seconds ---" % (time.time() - start_time))