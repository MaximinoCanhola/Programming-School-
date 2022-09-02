def inversa(txt):
    TXT = list(txt.strip())
    TXT1 = []
    for i in range(len(TXT)):
        TXT1.append(TXT[len(TXT)-i-1])
    return ''.join(TXT1)