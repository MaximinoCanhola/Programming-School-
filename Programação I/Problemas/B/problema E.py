# -*- coding: utf-8 -*-
"""
Created on Tue Apr 14 14:24:50 2020

@author: mexic
"""

def ET():
    x = input()
    print(x)
    y = input()
    while y != '#':
        if y == x:
            print(y)
        elif y == 'a':
            if x == 'c':
                print('t')
            else:
                print('c')
        elif y == 'c':
            if x == 'a':
                print('t')
            else:
                print('a')
        else:
            if x == 'a':
                print('c')
            else:
                print('a')
        x = y
        y = input()
ET()