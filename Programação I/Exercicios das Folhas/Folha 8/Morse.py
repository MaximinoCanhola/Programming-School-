def morse(txt:str):
    Morse = {'A':'.- ','B':'-... ','C':'-.-. ','D':'-.. ','E':'. ','F':'..-. ','G':'--. ','H':'.... ','I':'.. ','J':'.--- ','K':'-.- ','L':'.-.. ','M':'-- ','N':'-. ','O':'--- ','P':'.--. ','Q':'--.- ','R':'.-. ','S':'... ','T':'- ','U':'..- ','V':'...- ','W':'.-- ','X':'-..- ','Y':'-.-- ','Z':'--.. '}
    txt1 = list(txt.strip())
    L = []
    for i in range(len(txt1)):
        if txt1[i] in Morse:
            L.append(txt1[i])
    Morse1 = []
    for i in range(len(L)):
        Morse1.append(Morse[L[i]])
    print(''.join(Morse1))