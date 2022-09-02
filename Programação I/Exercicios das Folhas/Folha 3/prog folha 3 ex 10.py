# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 17:13:25 2020

@author: mexic
"""

def rotacao(v:[]):
    if v == [] or len(v) == 1:
        return v
    aux = v[len(v)-1]
    for i in range(len(v)-2):  # n = 3   [1,2,3] -> [3,2,2]
        v[-1-i] = v[-2-i]
    v[0] = aux
    return v