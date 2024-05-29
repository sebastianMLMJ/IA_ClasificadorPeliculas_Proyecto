import numpy as np
import pandas as pd

ds = pd.read_csv('critic_reviews_normalized.csv')

def Eliminadatosfaltantes (dataset,columna):
  dataset = dataset[dataset[columna].notna()]
  return dataset



ds=Eliminadatosfaltantes(ds,"review_content")
getcolumns = ds.drop(columns=['rotten_tomatoes_link','critic_name','top_critic','publisher_name','review_score','review_date'])

#80% de los registros
df_80 = getcolumns.sample(frac=0.90, random_state=200)

# obtener los faltantes
df_20 = getcolumns[~getcolumns.index.isin(df_80.index)]

rottenNarray = df_80["review_content"].loc[df_80["review_type"] == 'Rotten'].to_numpy()
rotten =  rottenNarray.astype(str).tolist()
freshNarray = df_80["review_content"].loc[df_80["review_type"] == 'Fresh'].to_numpy()
fresh = freshNarray.astype(str).tolist()

total_sentences = len(rotten) + len(fresh)
p_rotten = len(rotten) / total_sentences
p_fresh = len(fresh) / total_sentences


def crear_tabla_frecuencias(corpus, corpus2):
    frecuencias = {}
    for oracion in corpus:
        tokens = oracion.split(" ")
        for token in tokens:
            if token not in frecuencias.keys():
                frecuencias[token] = 1
            else:
                frecuencias[token] += 1
    for oracion in corpus2: #Agregar las palabas no encontradas en el otro vector para suavizado de laplace
        tokens = oracion.split(" ")
        for token in tokens:
            if token not in frecuencias.keys():
                frecuencias[token] = 0
    return frecuencias
frecuencia_rotten = crear_tabla_frecuencias(rotten, fresh)
frecuencia_fresh = crear_tabla_frecuencias(fresh, rotten)

def sumar_constante(tabla_frec, constante):
    for k in tabla_frec:
        tabla_frec[k] +=1
    return tabla_frec
sumar_constante(frecuencia_rotten,1)
sumar_constante(frecuencia_fresh,1)

def contar_palabras(corpus):
    frecuencia = 0
    for oracion in corpus:
        frecuencia += len(oracion.split(" "))
    return frecuencia
total_rotten = contar_palabras(rotten)
total_fresh = contar_palabras(fresh)

def transformar_frecuencia_probabilidad(frecuencias, total, constante):
    cpt_equivalente = {}
    for  k,v in frecuencias.items():
        probabilidad = v / (total + (len(frecuencias)*constante))
        cpt_equivalente[k] = probabilidad
    return cpt_equivalente

cpt_rotten = transformar_frecuencia_probabilidad(frecuencia_rotten, total_rotten, 1)
cpt_fresh = transformar_frecuencia_probabilidad(frecuencia_fresh, total_fresh, 1)

def generacion_querys_rotten(mensaje):
    palabras = mensaje.split(" ")
    rottenq = "(p_rotten"
    freshq ="(p_fresh"
    counter = len(palabras)
    for palabra in palabras:
        if(cpt_rotten.get(palabra) != None and cpt_fresh.get(palabra) != None ):  
            rottenq += "*"
            freshq +="*"
            rottenq += "cpt_rotten[" + "'" + palabra + "']"
            freshq += "cpt_fresh[" + "'" + palabra + "']"    
        counter -=1
        if(counter == 0):
            rottenq += ")"
            freshq +=")"
    query = rottenq + "/(" + rottenq +"+" + freshq + ")"
    return eval(query)

def generacion_querys_fresh(mensaje):
    palabras = mensaje.split(" ")
    rottenq = "(p_rotten"
    freshq ="(p_fresh"
    counter = len(palabras)
    for palabra in palabras:
        if(cpt_rotten.get(palabra) != None and cpt_fresh.get(palabra) != None):  
            rottenq += "*"
            freshq +="*"
            rottenq += "cpt_rotten[" + "'" + palabra + "']"
            freshq += "cpt_fresh[" + "'" + palabra + "']"
        counter -=1
        if(counter == 0):
            rottenq += ")"
            freshq +=")"

    query = freshq + "/(" + freshq +"+" + rottenq + ")"
    return eval(query)
#tenthrate
#fresh_final_prob = (generacion_querys_fresh('bad movie'))
#rotten_final_prob = (generacion_querys_rotten('bad movie'))
#
#print(fresh_final_prob, rotten_final_prob)
#
#if(fresh_final_prob >= rotten_final_prob):
#    print("is fresh")
#else:
#    print("is rotten")