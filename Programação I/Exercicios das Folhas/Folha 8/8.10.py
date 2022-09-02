def pontua(chave:str,tentativa:str):
    chave1 = list(chave.strip())
    tentativa1 = list(tentativa.strip())
    certo = 0
    aleatorio = 0
    for i in range(len(tentativa1)):
        if tentativa1[i] in chave1:
            aleatorio += 1
            chave1[i] = []
    chave1 = list(chave.strip())
    for i in range(len(tentativa1)):
        if tentativa[i] == chave1[i]:
            certo += 1
            chave1[i] = []
    print('(%d,%d)' % (certo,aleatorio))