def  filtra_letras(txt):
    l = list(txt.strip())
    for i in range(len(l)):
        if l[i].isalpha()==False or l[i] == '':
            l[i] = 0
    L = []
    for i in range(len(l)):
        if l[i] != 0:
            L.append(l[i])
    return ''.join(L)