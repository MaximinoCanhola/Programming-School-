def media(lista:list):
    if lista == []:
        raise ValueError('lista vazia')
    try:
        soma = 0
        for i in range(len(lista)):
            soma += lista[i]
        SOMA = soma / len(lista)
        return SOMA
    except TypeError:
        return 'não é uma lista'