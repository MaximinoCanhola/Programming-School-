def repetidos(l:list):
    D = {}
    for i in range(len(l)):
        if l[i] not in D:
            D.update({l[i]:0})
    for i in range(len(l)):
        if l[i] in D:
            D[l[i]] += 1
    L = list(D.values())
    for i in range(len(L)):
        if L[i] != 1:
            return True
    return False