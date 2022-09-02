# -*- coding: utf-8 -*-
"""
Created on Wed Apr 22 14:50:57 2020

@author: mexic
"""

def horas():
    h1,m1 = map(int,input().split())
    h2,m2 = map(int,input().split())
    minutos = (m2 - m1) + 60*(h2 - h1)
    minutos1 = m2 - m1
    x = 60 - m1
    minutos2 = x + m2
    minutos3 = minutos2 + 60*(h2 - h1 - 1)
    horas = h2 - h1
    horas1 = horas - 1
    passaram = 'Passaram apenas '+str(minutos)+' minutos!'
    passaram1 = 'Passaram apenas '+str(minutos3)+' minutos!'
    DF = 'De facto!'
    if h1 == h2:
        if m2 - m1 == 1:
            print('Passou apenas 1 minuto!')
            print(DF)
        else:
            print(passaram)
            print(DF)
    else:
        if h2 - h1 == 1:
            if m2 - m1 == 0:
                print(passaram)
                print('Queres dizer, 1 hora?!')
            elif m2 - m1 == 1:
                print(passaram)
                print('Queres dizer, 1 hora e 1 minuto?!')
            elif m1 > m2:
                print(passaram1)
                print(DF)
            else:
                print(passaram)
                print('Queres dizer, 1 hora e '+str(minutos1)+' minutos?!')
        else:
            if m2 - m1 == 0:
                print(passaram)
                print('Queres dizer, '+str(horas)+' horas?!')
            elif m2 - m1 == 1:
                print(passaram)
                print('Queres dizer, '+str(horas)+' horas e 1 minuto?!')
            elif m1 > m2:
                if h2 - h1 == 2:
                    print(passaram1)
                    print('Queres dizer, 1 hora e '+str(minutos2)+' minutos?!')
                else:
                    print(passaram1)
                    print('Queres dizer, '+str(horas1)+' horas e '+str(minutos2)+' minutos?!')
            else:
                print(passaram)
                print('Queres dizer, '+str(horas)+' horas e '+str(minutos1)+' minutos?!')
horas()
           
            