# -*- coding: utf-8 -*-
"""
Created on Wed Mar 25 14:53:40 2020

@author: mexic
"""

def triangulosquadrilateros():
    n = int(input())
    if n == 3:
        a,b,c = map(int,input().split())
        if a < b + c and b < a + c and c < a + b:
            print("Triangulo")
        else:
            print("Nao Triangulo")
    else:
        a,b,c,d = map(int,input().split())
        if a == b == c == d:
            print("Talvez Quadrado")
        elif (a == b and c == d) or (a == c and b == d) or (a == d and b == c):
            print("Talvez Rectangulo mas nao Quadrado")
        else:
            print("Quadrilatero nao Rectangulo")
triangulosquadrilateros()