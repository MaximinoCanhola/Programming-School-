# -*- coding: utf-8 -*-
"""
Created on Mon Mar 23 14:36:49 2020

@author: mexic
"""

def media_arit(x:[]):
    cont = 0
    for i in range(len(x)):
        cont += x[i]
    final = cont/len(x)
    print(final)   