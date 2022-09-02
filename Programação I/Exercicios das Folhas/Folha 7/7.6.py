def magico(A):
    linhas = 0
    colunas = 0
    diagonais = 0
    for i in range(len(A[0])):
        for j in range(len(A[0])):
            linhas += A[i][j]
    for k in range(len(A[0])):
        for l in range(len(A[0])):
            colunas += A[l][k]
    for m in range(len(A[0])):
        diagonais += A[m][m]
    for n in range(len(A[0])):
        diagonais += A[n][len(A[0])-n-1]
    totallinhas = linhas/len(A[0])
    totalcolunas = colunas/len(A[0])
    totaldiagonais = diagonais / 2
    if totallinhas == totalcolunas == totaldiagonais:
        return True
    return False