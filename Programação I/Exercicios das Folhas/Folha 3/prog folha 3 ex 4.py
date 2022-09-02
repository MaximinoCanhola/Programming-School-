# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 15:40:16 2020

@author: mexic
"""

def prod_interno(x:[],y:[]):
    cont = 0
    for i in range(len(x)):
        cont += x[i]*y[i]
    print(cont)