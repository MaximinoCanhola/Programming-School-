# -*- coding: utf-8 -*-
"""
Created on Tue Mar 17 15:00:50 2020

@author: mexic
"""

def posicao(a,b,c,d):
    if a == b == c== d:
        return "coincidentes"
    elif a == c and d > b:
        return "acima"
    elif a == c and d < b:
        return "abaixo"
    elif b == d and a > c:
        return "esquerda"
    elif b == d and a < c:
        return "direita"
    elif a > c and d > b:
        return "esquerda acima"
    elif a > c and d < b:
        return "esquerda abaixo"
    elif a < c and d > b:
        return "direita acima"
    return "direita abaixo"