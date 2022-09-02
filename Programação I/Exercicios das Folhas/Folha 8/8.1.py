def contar(palavra,texto):
    f = open(texto,'r',encoding='utf-8')
    n = 1
    cont = 0
    while True:
        linha = f.readline(n)
        if linha == '':
            break
        linha1 = list(linha.strip())
        for i in range(len(linha1)):
            if linha1[i] == palavra:
                cont += 1
        n += 1
    f.close()
contar('armas','lusiadas_CantoI.txt')