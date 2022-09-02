# -*- coding: utf-8 -*-
"""
Created on Tue Apr 14 13:53:25 2020

@author: mexic
"""

def pedrapapeltesoura():
    jog1 = input()
    jog2 = input()
    total1 = 0
    total2 = 0
    for i in range (10):
        if (jog1[i] == 'P' and jog2[i] == 'R') or (jog1[i] == 'T' and jog2[i] == 'P') or (jog1[i] == 'R' and jog2[i] == 'T'):
            total1 = total1 + 1
        if (jog2[i] == 'P' and jog1[i] == 'R') or (jog2[i] == 'T' and jog1[i] == 'P') or (jog2[i] == 'R' and jog1[i] == 'T'):
            total2 = total2 + 1
    print(total1)
    print(total2)
pedrapapeltesoura()