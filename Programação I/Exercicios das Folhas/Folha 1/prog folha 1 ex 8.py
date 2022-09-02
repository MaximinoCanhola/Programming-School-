# -*- coding: utf-8 -*-
"""
Created on Tue Mar 17 14:42:43 2020

@author: mexic
"""

a,b,c=map(int,input().split())
if a == 0:
    print("nao define funcao quadratica")
elif (b*b -4*a*c) < 0:
    print("nao tem raizes reais")
elif (b*b -4*a*c) == 0:
    print("tem raiz dupla")
else:
    print("tem raizes distintas")