module Folha7 where

import Data.List (nub)  -- remover repetidos

-- tipo para expressões proposicionais
data Prop = Const Bool        -- constantes
            | Var Char          -- variáveis
            | Neg Prop          -- negação
            | Conj Prop Prop    -- conjunção
            | Disj Prop Prop    -- disjunção
            | Impl Prop Prop    -- implicação
            | Equiv Prop Prop   -- equivalencia
            deriving (Eq,Show)

-- listas de associações
type Assoc ch v = [(ch,v)]


-- encontrar o valor associado a uma chave
-- parcial: erro se a chave não ocorre
find :: Eq ch => ch -> Assoc ch v -> v
find x assocs = head [v | (x',v)<-assocs, x==x']


-- atribuições de valores a variaveis
type Atrib = Assoc Char Bool

-- calcular o valor duma proposição
valor :: Atrib -> Prop -> Bool
valor s (Const b) = b
valor s (Var x)    = find x s
valor s (Neg p)    = not (valor s p)
valor s (Conj p q) = valor s p && valor s q
valor s (Disj p q) = valor s p || valor s q
valor s (Impl p q) = not (valor s p) || valor s q
valor s (Equiv p q) = equiv p q


-- gerar todas sequências de `n' boleanos
bits :: Int -> [[Bool]]
bits 0 = [[]]
bits n = [b:bs | bs<-bits (n-1), b<-[False,True]]


-- todas as atribuições às variáveis duma proposição
atribs :: Prop -> [Atrib]
atribs p = map (zip vs) (bits (length vs))
    where vs = nub (vars p)  -- variáveis sem repetições

-- coleciona todas as variáveis duma proposição
vars :: Prop -> [Char]
vars (Const _)   =  []
vars (Var x)     =  [x]
vars (Neg p)     =  vars p
vars (Conj p q)  =  vars p ++ vars q
vars (Disj p q)  =  vars p ++ vars q
vars (Impl p q)  =  vars p ++ vars q
vars (Equiv p q) =  vars p ++ vars q


-- verificar se é taulogia
tautologia :: Prop -> Bool
tautologia p = and [valor s p | s<-atribs p]


satisfaz :: Prop -> Bool
satisfaz p = or [valor s p | s<-atribs p]


equiv :: Prop -> Prop -> Bool
equiv p q = tautologia (Conj (Impl p q) (Impl q p))


showProp :: Prop -> String
showProp (Const True) = "T"
showProp (Const False) = "F"
showProp (Var x) = [x]
showProp (Neg p) = "(~" ++ showProp p ++ ")"
showProp (Conj p q) = "(" ++ showProp p ++ " && " ++ showProp q ++ ")"
showProp (Disj p q) = "(" ++ showProp p ++ " || " ++ showProp q ++ ")"
showProp (Impl p q) = "(" ++ showProp p ++ " -> " ++ showProp q ++ ")"


tabela :: Prop -> IO ()
tabela p = do
            let v = variaveis (nub (vars p)) ++ showProp p ++ "\n"
            putStr (v)
            let atr = atribs p
            aux atr p

variaveis :: String -> String
variaveis [] = ""
variaveis (s1:ss) = [s1] ++ "  " ++ variaveis ss 

aux :: [Atrib] -> Prop -> IO ()
aux [] p = return ()
aux l p = do 
        let list = l !! 0
        print1 list
        putStr (showBool(valor list p) ++ "\n")
        aux (drop 1 l) p

print1 :: Atrib -> IO ()
print1 [] = return ()
print1 ((x1,x2):xs) = do
                    putStr ((showBool x2)++"  ")
                    print1 xs

showBool :: Bool -> String
showBool True = "T"
showBool False = "F"


data Arv a = Vazia | No a (Arv a) (Arv a)
    deriving (Show)

sumArv :: Num a => Arv a -> a
sumArv Vazia = 0
sumArv (No v esq dir) = v + sumArv esq + sumArv dir


listarDecr :: Arv a -> [a]
listarDecr Vazia = []
listarDecr (No v esq dir) = listarDecr dir ++ [v] ++ listarDecr esq


nivel :: Int -> Arv a -> [a]
nivel _ Vazia = []
nivel 0 (No v esq dir) = [v]
nivel n (No v esq dir) = nivel (n-1) esq ++ nivel (n-1) dir


---------------------------
construir :: [a] -> Arv a
construir [] = Vazia
construir xs = No x (construir xs') (construir xs'')
    where xs'    = take n xs
          x:xs'' = drop n xs
          n      = length xs`div`2

inserir :: Ord  a => a -> Arv a -> Arv a
inserir x Vazia = No x Vazia Vazia
inserir x (No y esq dir)
    | x==y = No y esq dir
    | x<y  = No y (inserir x esq) dir
    | x>y  = No y esq (inserir x dir)

inserirAVL :: Ord a => a -> Arv a -> Arv a
inserirAVL x Vazia = No x Vazia Vazia
inserirAVL x (No y esq dir)
  | x == y --  valor já ocorre
   = No y esq dir
  | x < y -- inserir à esquerda
   = reequilibrar (No y (inserirAVL x esq) dir)
  | x > y -- inserir à direita
   = reequilibrar (No y esq (inserirAVL x dir))

reequilibrar :: Arv a -> Arv a
reequilibrar arv
  | d == 2 = corrigeDir arv -- para a direita
  | d == -2 = corrigeEsq arv -- para a esquerda
  | otherwise = arv
  where
    d = desvio arv

rodarEsq, rodarDir :: Arv a -> Arv a
rodarEsq (No x t1 (No y t2 t3)) = No y (No x t1 t2) t3
rodarEsq t = t -- outros casos

rodarDir (No x (No y t1 t2) t3) = No y t1 (No x t2 t3)
rodarDir t = t -- outros casos

-- * rotações compostas
-- efectua uma ou duas rotações conforme o desvio do nó interior
corrigeEsq, corrigeDir :: Arv a -> Arv a
corrigeEsq (No x t1 t2)
  | desvio t2 == 1 = rodarEsq (No x t1 (rodarDir t2))
  | otherwise = rodarEsq (No x t1 t2)
corrigeEsq t = t -- outros casos

corrigeDir (No x t1 t2)
  | desvio t1 == -1 = rodarDir (No x (rodarEsq t1) t2)
  | otherwise = rodarDir (No x t1 t2)
corrigeDir t = t -- outros casos

-- calcular o *desvio*
-- diferença entre altura da esquerda e da direita
desvio :: Arv a -> Int
desvio Vazia = 0
desvio (No _ esq dir) = altura esq - altura dir

altura :: Arv a -> Int
altura Vazia          = 0
altura (No _ esq dir) = 1 + max (altura esq) (altura dir)
-----------------------


mapArv :: (a -> b) -> Arv a -> Arv b
mapArv f Vazia = Vazia
mapArv f (No v esq dir) = No (f v) (mapArv f esq) (mapArv f dir)


remover :: Ord a => a -> Arv a -> Arv a
remover x Vazia  = Vazia
remover x (No y Vazia dir)
    | x==y = dir
remover x (No y esq Vazia)
    | x==y = esq
remover x (No y esq dir)
    | x<y  = No y (remover x esq) dir
    | x>y  = No y esq (remover x dir)
    | x==y = let z = maisDir esq
             in No z (remover z esq) dir

maisDir :: Arv a -> a
maisDir (No x _ Vazia) = x
maisDir (No _ _ dir)   = maisDir dir


removerAVL :: Ord a => a -> Arv a -> Arv a
removerAVL x Vazia  = Vazia
removerAVL x (No y Vazia dir)
    | x==y = dir
removerAVL x (No y esq Vazia)o
    | x==y = esq
removerAVL x (No y esq dir)
    | x<y  = No y (removerAVL x esq) dir
    | x>y  = No y esq (removerAVL x dir)
    | x==y = let z = maisDir esq
             in reequilibrar (No z (removerAVL z esq) dir)



