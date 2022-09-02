# -*- coding: utf-8 -*-
"""
Created on Tue Apr 21 14:47:11 2020

@author: mexic
"""

def troco():
    moeda = [200,100,50,20,10,5]
    caixa = [0,0,0,0,0,0]
    x = map(int,input().split())
    for i in range(6):
        caixa[i] = x[i]
    E,C = map(int,input())
    while E != 0 or C != 0:
        