# -*- coding: utf-8 -*-
"""
Created on Wed Mar 25 15:21:19 2020

@author: mexic
"""

def somaG():
    n = int(input())
    if n == 1:
        x = int(input())
        print('Resposta G - nenhum valor satisfaz')
    elif n == 2:
        x = int(input())
        y = int(input())
        print('Resposta G - soma: 0')
    else:
        x = int(input())
        y = int(input())
        n = n - 2
        soma = 0
        while n != 0:
            a = int(input())
            if (a != 0 and a != x and a != y) and (a % y == 0 or a > x):
                soma = soma + a
            n = n - 1
        if soma == 0:
            print('Resposta G - nenhum valor satisfaz')
        else:
            print('Resposta G - soma: '+str(soma))
somaG()