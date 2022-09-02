# -*- coding: utf-8 -*-
"""
Created on Sat Mar 14 11:44:20 2020

@author: mexic
"""

n=int(input("Quantos? "))
anterior=int(input("x? "))
atual=int(input("x? "))
if atual == anterior:
    print("nao é monotona crescente nem descrescente")
else:
    n=n-2
    
    if atual > anterior:
        sinal = 1
    else:
        sinal = -1
        
    while n > 0 and sinal != 0:
            anterior = atual      
            atual = int(input("x? ")) 
            n = n-1
            if (atual-anterior)*sinal <= 0:  
                sinal = 0
    
    if sinal == 0:
        print("Nao estritamente crescente nem estritamente decrescente")
    elif sinal == -1:
        print("Estritamente decrescente")
    else:
        print("Estritamente crescente")
            