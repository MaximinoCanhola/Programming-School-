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

f = open('lusiadas.txt','r',encoding='utf-8')
maior = 0
palavra = ''
n = 0
while n <= 1165:
    linha = f.readline(n)
    n += 1
    lista = palavras(linha)
    print(lista)
print(palavra,maior)
f.close()