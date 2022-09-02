# -*- coding: utf-8 -*-
"""
Created on Mon Mar 23 16:11:23 2020

@author: mexic
"""

def triangulosretangulos():
    a,b,c = map(int,input().split())
    if c*c == b*b + a*a:
        print( "Resposta A - Hipotenusa: "+str(c)+"cm Catetos: "+str(b)+"cm, "+str(a)+"cm")
    else:
        print( "Resposta A - Triangulo nao rectangulo!" )
triangulosretangulos()
