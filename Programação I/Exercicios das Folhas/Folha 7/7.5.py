def intervalo(xs:list,a:int,b:int):
    contador = 0
    for i in range(len(xs)):
        if xs[i] >= a and xs[i] <= b:
            contador += xs[i]
    return contador