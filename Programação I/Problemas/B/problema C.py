# -*- coding: utf-8 -*-
"""
Created on Tue Apr 21 14:33:20 2020

@author: mexic
"""

def placas():
    L = input()
    cont = 0
    for i in range(len(L)):
        if L[i] == 'P' or L[i] == 'p':
            cont += 1
    print(cont)
placas()