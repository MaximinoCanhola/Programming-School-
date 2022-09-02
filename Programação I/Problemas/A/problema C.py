# -*- coding: utf-8 -*-
"""
Created on Tue Mar 24 14:52:05 2020

@author: mexic
"""

def boasorte():
    list = ['GOOD LUCK','BUENA SUERTE','BONNE CHANCE','BUONA FORTUNA','VIEL GLUECK']
    n = int(input())
    I = int(input())
    for i in range (n):
        print(list[I-1])
boasorte()