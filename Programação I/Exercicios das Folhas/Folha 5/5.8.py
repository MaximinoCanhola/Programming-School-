def palindromo(txt):
    Txt = list(txt.strip())
    if len(Txt) % 2 == 0:
        for i in range(int((len(Txt)/2)-1)):
            if Txt[i] != Txt[len(Txt)-i-1]:
                return False
        return True
    else:
        for i in range(int(((len(Txt)-1)/2)-1)):
            if Txt[i] != Txt[len(Txt)-i-1]:
                return False
        return True