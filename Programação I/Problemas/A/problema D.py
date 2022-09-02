# -*- coding: utf-8 -*-
"""
Created on Thu Mar 26 16:52:11 2020

@author: mexic
"""

def reuniao():
    t = int(input())
    A,B = map(int,input().split())
    C,D = map(int,input().split())
    if B - A > t and D - C > t and C < B:
        x = max(A,C)
        print(x, x+t+1)
    elif B - A == t and D - C == t and A == C:
        print(str(A))
    else:
        print('Impossivel')
reuniao()