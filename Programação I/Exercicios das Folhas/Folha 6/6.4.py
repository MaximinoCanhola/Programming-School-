def ocorrencias(txt:str,c:str):
    L = []
    for i in range(len(txt)):
        if txt[i] == c:
            L.append(i)
    return L