# -*- coding: utf-8 -*-
"""
Created on Tue Mar 17 13:39:45 2020

@author: mexic
"""

maior = int(input("x? "))
menor = maior
novo = int(input("x? "))
while novo != 0:    
    if novo > maior:
        maior = novo
    elif novo < menor:
        menor = novo
    novo = int(input("x? "))
if maior == menor:
    print("Maior = Menor = " + str(maior))
else:
    print("Maior = " + str(maior) + " e Menor = " + str(menor))
        