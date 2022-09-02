# -*- coding: utf-8 -*-
"""
Created on Tue Mar 17 14:34:34 2020

@author: mexic
"""

k = int(input("k? "))
soma = 0
x=int(input("x? "))
while x != 0:
    if x > 0 and x%k==0:
        soma = soma + x
    x=int(input("x? "))
print(soma)