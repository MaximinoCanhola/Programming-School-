# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 15:32:07 2020

@author: mexic
"""

def media_geom(x:[]):
    cont = 1
    for i in range(len(x)):
        cont = cont * x[i]
    final = cont ** (1/len(x))
    print(final)