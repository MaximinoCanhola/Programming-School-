# -*- coding: utf-8 -*-
"""
Created on Sat Apr 25 16:04:14 2020

@author: mexic
"""

def capicua(x:[]):
    y = len(x)
    if y == 0 or y == 1:
        return True
    else:
        n = int(y/2)
        for i in range(n):
            if x[i] == x[y-1-i]:
                return True
            return False