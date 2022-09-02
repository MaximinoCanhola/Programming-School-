def dup_vogais(txt:str):
    L = ['A','E','I','O','U','a','e','i','o','u']
    l = []
    texto = list(txt.strip())
    for i in range(len(texto)):
        l.append(texto[i])
        if texto[i] in L:
            l.append(texto[i])
    txt1 = ''.join(l)
    return txt1