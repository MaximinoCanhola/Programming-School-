def remadj(xs:list):
    for i in range(len(xs)-1):
        if xs[i] == xs[i+1]:
            xs[i] = ''
    print(xs)
    L = []
    for j in range(len(xs)):
        if xs[j] != '':
            L.append(xs[j])
    return L