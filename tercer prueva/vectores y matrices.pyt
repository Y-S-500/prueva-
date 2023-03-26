import random
import math

def main():
    vector = [random.randint(1, 500) for i in range(50)]
    matriz = [[random.randint(1, 500) for j in range(5)] for i in range(5)]
    
    while True:
        print("Bienvenido al programa de vectores y matrices")
        print("Seleccione una opción:")
        print("1. Mostrar Vector y Matriz")
        print("2. Ordenar vector")
        print("3. Suma total Vector")
        print("4. Suma total Matriz")
        print("5. Imprimir los números primos del vector")
        print("6. Imprimir números impares de la matriz")
        print("7. Ordenar matriz")
        print("8. Salir")

        opcion = input("Ingrese una opción: ")
        
        if opcion == '1':
            print("Vector:")
            print(vector)
            print("Matriz:")
            for row in matriz:
                print(row)
        elif opcion == '2':
            ordenar_vector(vector)
            print("Vector ordenado:")
            print(vector)
        elif opcion == '3':
            print("Suma total del vector:", sumar_vector(vector))
        elif opcion == '4':
            print("Suma total de la matriz:", sumar_matriz(matriz))
        elif opcion == '5':
            primos = obtener_primos(vector)
            print("Números primos en el vector:")
            for i in range(len(vector)):
                if primos[i]:
                    print(vector[i], "en posición", i)
        elif opcion == '6':
            impares = obtener_impares(matriz)
            print("Números impares en la matriz:")
            for i in range(len(matriz)):
                for j in range(len(matriz[i])):
                    if impares[i][j]:
                        print(matriz[i][j], "en posición", (i,j))
        elif opcion == '7':
            ordenar_matriz(matriz)
            print("Matriz ordenada:")
            for row in matriz:
                print(row)
        elif opcion == '8':
            print("¡Hasta luego!")
            break
        else:
            print("Opción inválida. Intente nuevamente.")
        input("Presione Enter para continuar...")

def ordenar_vector(vector):
    for i in range(len(vector)):
        for j in range(i+1, len(vector)):
            if vector[i] < vector[j]:
                vector[i], vector[j] = vector[j], vector[i]

def sumar_vector(vector):
    suma = 0
    for i in range(len(vector)):
        suma += vector[i]
    return suma

def sumar_matriz(matriz):
    suma = 0
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            suma += matriz[i][j]
    return suma

def obtener_primos(vector):
    primos = [True] * len(vector)
    for i in range(len(vector)):
        if vector[i] < 2:
            primos[i] = False
        else:
            for j in range(2, int(math.sqrt(vector[i]))+1):
                if vector[i] % j == 0:
                    primos[i] = False
                    break
    return primos

def obtener_impares(matriz):
    impares = [[False] * len(matriz[i]) for i in range(len(matriz))]
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            if
