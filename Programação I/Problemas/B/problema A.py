# -*- coding: utf-8 -*-
"""
Created on Tue Mar 31 14:06:22 2020

@author: mexic
"""

def juliano():
    ano,mes,dia=map(int,input().split())
    if mes < 3:
        ano = ano - 1
        mes = mes + 12
    A = ano//100
    B = A//4
    if ano == 1582:
        if mes >= 10:
            if dia > 15:
                C = 2 - A + B
            else:
                C = 0
        else:
            C = 0
        if mes <= 10:
            if dia <= 4:
                C = 0
    elif ano > 1582:
        C = 2 - A + B
    elif ano < 1582:
        C = 0
    D = int(365.25*(ano + 4716))
    E = int(30.6001*(mes + 1))
    DJ = D + E + dia + C - 1524
    print(DJ)
juliano()