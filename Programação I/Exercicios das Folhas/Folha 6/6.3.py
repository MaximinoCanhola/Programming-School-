def divisores(n):
    l = []
    for i in range(1,n):
        if n % i == 0:
            l.append(i)
    return l

def perfeito(n):
    lista = divisores(n)
    soma = 0
    for i in range(len(lista)):
        soma += lista[i]
    if soma != n:
        return False
    return True