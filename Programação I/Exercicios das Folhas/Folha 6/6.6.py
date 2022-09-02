def palavras(txt:str):
    compr = len(txt)
    resultado = ''
    i = 0
    while i < compr:
        if txt[i].isalpha()==False and txt[i]!='':
            txt = txt.replace(txt[i],'')
            resultado = txt.split()
            compr = len(txt)
        i += 1
        return resultado