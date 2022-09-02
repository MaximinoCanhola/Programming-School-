# -*- coding: utf-8 -*-
"""
Created on Sun Apr 26 14:35:20 2020

@author: mexic
"""

def lerseqfiltra():
    x = int(input())
    L = []
    while x != 0:
        if x > 0:
            L.append(x)
        x = int(input())
    for i in range(len(L)):
        print(L[i])
lerseqfiltra()