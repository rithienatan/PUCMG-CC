import pandas as pd
import enum
import numpy as np
import matplotlib.pyplot as plt
from sklearn import metrics
from sklearn.tree import DecisionTreeClassifier


class Estado(enum.Enum):
    Rondônia = 11
    Acre = 12
    Amazonas = 13
    Roraima = 14
    Pará = 15
    Amapá = 16
    Tocantins = 17
    Maranhão = 21
    Piauí = 22
    Ceará = 23
    Rio_Grande_do_Norte = 24 
    Paraíba = 25
    Pernambuco = 26
    Alagoas = 27
    Sergipe = 28
    Bahia = 29
    Minas_Gerais = 31
    Espírito_Santo = 32
    Rio_de_Janeiro = 33
    São_Paulo = 35
    Paraná = 41
    Santa_Catarina = 42
    Rio_Grande_do_Sul = 43
    Mato_Grosso_do_Sul = 50
    Mato_Grosso = 51
    Goiás = 52
    Distrito_Federal = 53



dataframe = pd.read_csv ('diabetes-grupo7.csv', delimiter=';')

dataframe.groupby(['V0001','Q030']).size().groupby(level=0).apply(
    lambda x: 100 * x / x.sum()
).to_frame().unstack().plot(kind='bar',stacked=False,legend=True)
plt.title('Diabetes')
plt.xlabel('Estado')
plt.legend(labels=['Recebeu diagnóstico', 'Não recebeu diagnóstico'])
plt.show()


dataframe.fillna(method='ffill')

cols_at_end = ['Q030']
dataframe = dataframe[[c for c in dataframe if c not in cols_at_end] 
        + [c for c in cols_at_end if c in dataframe]]
dataframe = dataframe.replace('\.',0.0, regex=True)
dataframe = dataframe.replace(np.nan, 0.0, regex=True)


#Removendo colunas com menos de 60% de valores preenchidos
dataframe.dropna(thresh=0.6*len(dataframe),axis=1,inplace=True)

dataframe_data = dataframe.values[:,0:37] # feat/variables 
dataframe_target = dataframe.values[:,38]  # class
dataframe_target=dataframe_target.astype('int')

model = DecisionTreeClassifier()
model.fit(dataframe_data, dataframe_target)



# make predictions
expected = dataframe_target
predicted = model.predict(dataframe_data)
  

# summarize the fit of the model
print(metrics.classification_report(expected, predicted))
print(metrics.confusion_matrix(expected, predicted))