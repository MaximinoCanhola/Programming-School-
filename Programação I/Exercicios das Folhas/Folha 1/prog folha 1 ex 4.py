# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 14:56:57 2020

@author: mexic
"""

def qq():
    x = int(input())
    y = int(input())
    x-= 1
    cont = 0
    while x != 0:
        if y % 2 == 0 and y % 3 == 0:
            y = int(input())
        elif y % 2 == 0 or y % 3 == 0:
            cont += 1
            y = int(input())
        else:
            y = int(input())
        x -= 1
    print('Numero de multiplos ou de 2 ou de 3 = '+str(cont))
qq()