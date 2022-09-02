# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 15:43:29 2020

@author: mexic
"""

def posicao(x:int,v:[]):
    pos = []
    for i in range(len(v)):
        if v[i] == x:
            pos.append(i)
        elif v == []:
            print('-1')
    if pos == []:
        print('-1')
    else:
        print(pos[0])