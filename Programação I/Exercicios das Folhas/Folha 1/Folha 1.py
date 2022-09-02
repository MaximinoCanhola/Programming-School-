#============================================================================
#  Uma resolucao dos exercicios da Folha Pratica 1
#   - NB: estao definidos como funcoes para facilitar o teste dos programas
#
#    A.P.Tomas    14.03.2020
#============================================================================


#-------------------------------------------------------------
# Problema 1 - folha 1
# calculo do valor absoluto de inteiro lido da entrada padrao

def ex1():
    x = int(input("x? "))
    if x >= 0:
        print(x)
    else:
        print(-x)

# Em alternativa, pode nao escrever nenhuma mensagem na leitura

def ex1_outra():
        x = int(input())
        if x >= 0:
            print(x)
        else:
            print(-x)

#---------------------------------------------------------------



# Problema 2 - folha 1

# alinea a)  verificar se os tres valores definem um triangulo;
# Input: os tres valores sao dados numa linha 
# separados por um espaco;  Output: no formato imposto

def ex2_a():
    a,b,c = map(int,input().split())
    terno = "("+str(a)+","+str(b)+","+str(c)+")"
    if a > 0 and b > 0 and c > 0 and a < b+c and b < a+c and c < a+b:
        print(terno + " define triangulo")
    else: 
        print(terno + " nao define triangulo")
# o operador + concatena a string guardada em terno com a indicada


# alinea b) classificar quanto aos lados e quanto aos angulos

def ex2_b():
    a,b,c = map(int,input().split())
    terno = "("+str(a)+","+str(b)+","+str(c)+")"
    if a <= 0 or b <= 0 or c <= 0 or a >= b+c or b >= a+c or c >= a+b:
        print(terno + " nao define triangulo")
    else:
        resposta = terno  + " define triangulo"
        # classificar quanto aos lados
        if a == b:
            if b == c:
                resposta = resposta + " equilatero"
            else:
                resposta = resposta + " isosceles"
        elif b == c or a == c:
            resposta = resposta + " isosceles"
        else:
            resposta = resposta + " escaleno"
        # classificar quanto aos angulos
        if a > b:
            if a > c:
                quadradoMaior = a*a
                somaQuadrRestantes = b*b + c*c 
            else:
                quadradoMaior = c*c
                somaQuadrRestantes = b*b + a*a
        elif c > b:
            quadradoMaior = c*c
            somaQuadrRestantes = b*b + a*a
        else:
            quadradoMaior = b*b
            somaQuadrRestantes = c*c + a*a

        if quadradoMaior == somaQuadrRestantes:
            resposta = resposta + " retangulo"
        elif quadradoMaior > somaQuadrRestantes:
            resposta = resposta + " obtusangulo"
        else:
            resposta = resposta + " acutangulo"

        print(resposta)

#--------------------------------------------------------------------------


# Problema 3 - Folha 1

# alinea a)

def ex3_a():
    cx,cy = map(int,input().split())
    r = int(input())
    px,py = map(int,input().split())

    qdist = (px-cx)*(px-cx)+(py-cy)*(py-cy)

    ponto = "("+str(px)+","+str(py)+"): "
    if qdist == r*r: 
        print(ponto + "na fronteira")
    elif qdist < r*r:
        print(ponto + "no interior")
    else:
        print(ponto + "no exterior")



# alinea b)

def ex3_b():
    cx,cy = map(int,input().split())
    r = int(input())
    n = int(input())
    while n > 0:
        px,py = map(int,input().split())
        qdist = (px-cx)*(px-cx)+(py-cy)*(py-cy)
        ponto = "("+str(px)+","+str(py)+"): "
        if qdist == r*r: 
            print(ponto + "na fronteira")
        elif qdist < r*r:
            print(ponto + "no interior")
        else:
            print(ponto + "no exterior")
        n = n-1


#-----------------------------------------------------------------------------------------------


# Problema 4 - Folha 1
# multiplos de 2 ou 3 mas nao de ambos

def ex4():
    n = int(input())
    conta = 0
    while n > 0:
        x = int(input())
        if (x%2 == 0 or x%3 == 0) and x%6 != 0:    # multiplo de 2 ou 3 mas nao de 6
            conta = conta+1
        n = n-1
    print("Numero de multiplos ou de 2 ou de 3 = "+str(conta))


# Outra solucao
# Versao alternativa em que se faz no maximo dois testes por cada inteiro x dado

def ex4_outra():
    n = int(input())
    conta = 0
    while n > 0:
        x = int(input())
        if x%2 == 0:
            if x%3 != 0:    # multiplo de 2 mas nao de 3
                conta = conta+1
        elif x%3 == 0:      # multiplo de 3 mas nao de 2
            conta = conta+1
        n = n-1
    print("Numero de multiplos ou de 2 ou de 3 = "+str(conta))

#-----------------------------------------------------------------------------------

# Problema 5 - Folha 1
# maior e menor valor lido numa sequencia que termina por 0

def ex5():
    maior = int(input())
    menor = maior
    novo = int(input())

    while novo != 0:    
        if novo > maior:
            maior = novo
        elif novo < menor:
            menor = novo
        novo = int(input())

    if maior == menor:
        print("Maior = Menor = " + str(maior))
    else:
        print("Maior = " + str(maior) + " e Menor = " + str(menor))

#-----------------------------------------------------------------------------------

# Problema 6 - Folha 1
# Verificar se sequencia de n inteiros seria estritamente crescente ou estritamente
# decrescente, sendo n >= 2

def ex6():
    n = int(input())

    anterior = int(input())
    atual = int(input())

    if atual == anterior:
        print("Nao estritamente crescente nem estritamente decrescente")
    else:
        n = n-2

        if atual > anterior:
            sinal = 1
        else:
            sinal = -1
    
        while n > 0 and sinal != 0:
            anterior = atual      # atualiza o anterior para poder ler o proximo
            atual = int(input())  # leu um novo
            n = n-1
            if (atual-anterior)*sinal <= 0:   # quer dizer que nao manteve a monotonia
                sinal = 0
    
        if sinal == 0:
            print("Nao estritamente crescente nem estritamente decrescente")
        elif sinal == -1:
            print("Estritamente decrescente")
        else:
            print("Estritamente crescente")

# Notar que a funcao nao lera os n inteiros se concluir antes de terminar que a sequencia nao 
# estritamente crescente nem estritamente decrescente. Na implementacao usamos uma propriedade 
# matematica para tornar o programa mais compacto:
#  a > b  se  a-b > 0;   a < b  se  a-b < 0;  o produto de dois numeros com o mesmo sinal sera positivo
# O ciclo termina quando n chegar a zero ou se o sinal mudar ...


#-----------------------------------------------------------------------------------------------------


# Problema 7 - Folha 1
#  soma dos positivos e multiplos de k numa sequencia que termina por 0

def ex7():
    k = int(input())       # vamos assumir que o valor dado nao sera 0
    soma = 0               # zero: o elemento neutro da adicao
    x = int(input())
    while x != 0:
        if x > 0 and x%k == 0:
            soma = soma + x
        x = int(input())
    print(soma)


#-----------------------------------------------------------------------------------------------------


# Problema 8 - Folha 1
#   Classificar as raizes de uma equacao de grau dois

def ex8():
    a,b,c = map(int, input().split())
    if a == 0:
        print("Nao define equacao quadratica")
    else: 
        descriminante = b*b - 4*a*c
        if descriminante < 0:
            print("Sem raizes reais")
        elif descriminante == 0:
            print("Com uma raiz real dupla")
        else:
            print("Com raizes reais distintas")


#-----------------------------------------------------------------------------------------------------


# Problema 9 - Folha 1
#   Resolver equacoes/inequacoes de grau 1      ax + b  OPERADOR  0   com  x inteiro

def ex9():
    a,b,s = map(int, input().split())

    if a != 0:
        # normalizar para ter a > 0
        if a < 0:
            a = -a
            b = -b
            s = -s
        # ax + b  OPERADOR 0,  com a > 0
        if s == 0:
            # ax + b = 0
            if b%a != 0:
                print("impossivel")
            else:
                print("x = " + str(-b//a))
        elif s == 1:
            # ax + b >= 0, com a > 0
            if b%a == 0:
                print("x >= " + str(-b//a))
            else:
                print("x >= " + str(-b//a + 1))
        else:
            # ax + b <= 0, com a > 0
            if b%a == 0:
                print("x <= " + str(-b//a))
            else:
                print("x <= " + str(-b//a))
    elif s == 0:
        #  0x + b = 0
        if b != 0:
            print("impossivel")
        else:
            print("universal")
    elif s == 1:
        #  0x + b >= 0
        if b < 0:
            print("impossivel")
        else:
            print("universal")
    else:
        # 0x + b <= 0
        if b > 0:
            print("impossivel")
        else:
            print("universal")



#---------------------------------------------------------------------------
#  podemos agrupar alguns casos para escrever um programa mais pequeno
#---------------------------------------------------------------------------

def ex9_outra():
    a,b,s = map(int, input().split())

    if a != 0:
        # normalizar para ter a > 0
        if a < 0:
            a = -a
            b = -b
            s = -s
        # ax + b  OPERADOR 0,  com a > 0
        if s == 0:
            if b%a != 0:
                print("impossivel")
            else:
                print("x = " + str(-b//a))
        else:
            if s == 1:
                operador = ">="
            else:
                operador = "<="
            if b%a != 0 and s == 1:
                v = -b//a + 1
            else:
                v = -b//a
            print("x "+operador+" "+str(v))
    elif b*s < 0 or (s==0 and b != 0):       # caso  0x + b  OPERADOR  0
        print("impossivel")
    else:
        print("universal")
