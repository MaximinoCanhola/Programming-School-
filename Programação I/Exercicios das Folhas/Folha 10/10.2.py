def acertos(chave:list,aposta:list):
    assert (chave[0]!=chave[1]!=chave[2]!=chave[3]!=chave[4]!=chave[5]),'valores repetidos'
    assert (aposta[0]!=aposta[1]!=aposta[2]!=aposta[3]!=aposta[4]!=aposta[5]),'valores repetidos'
    assert len(chave) == 6 and len(aposta) == 6, 'valores insuficientes'
    assert min(chave) > 0 and min(aposta) > 0 and max(chave) < 50 and max(aposta) < 50, 'valores fora dos limites'
    acertos = 0
    for i in range(6):
        if aposta[i] in chave:
            acertos += 1
    return acertos