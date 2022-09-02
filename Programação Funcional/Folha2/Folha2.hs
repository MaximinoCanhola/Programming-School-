module Folha2 where

classifica :: Int -> String
classifica n
  | n <= 9 = "reprovado"
  | n >= 10 && n <= 12 = "suficiente"
  | n >= 13 && n <= 15 = "bom"
  | n >= 16 && n <= 18 = "muito bom"
  | otherwise = "muito bom com distinção"

classifica_imc :: Float -> Float -> String
classifica_imc peso altura
  | imc < 18.5 = "baixo peso"
  | imc >= 18.5 && imc <= 25 = "peso normal"
  | imc >= 25 && imc <= 30 = "excesso de peso"
  | otherwise = "obesidade"
  where
    imc = peso / altura ^ 2

max1, min1 :: Ord a => a -> a -> a
max1 x y = if x >= y then x else y
min1 x y = if x <= y then x else y

max3, min3 :: Int -> Int -> Int -> Int
max3 x y z = max1 x (max1 y z)
min3 x y z = min1 x (min1 y z)

xor :: Bool -> Bool -> Bool
xor True True = False
xor True False = True
xor False True = True
xor False False = False

safetail' :: [a] -> [a]
safetail' lista = if length lista == 0 then [] else drop 1 lista

safetail'' :: [a] -> [a]
safetail'' lista
  | length lista == 0 = []
  | otherwise = drop 1 lista

safetail''' :: [a] -> [a]
safetail''' [] = []
safetail''' (x:xs) = xs 

curta' :: [a] -> Bool
curta' lista
  | length lista == 0 = True
  | length lista == 1 = True
  | length lista == 2 = True
  | otherwise = False

curta'' :: [a] -> Bool
curta'' [] = True
curta'' [x] = True
curta'' [x,y] = True
curta'' (x1:(x2:xs)) = False

mediana :: Int -> Int -> Int -> Int
mediana a b c
  | a <= b && b <= c = b
  | a <= c && c <= b = c
  | b <= a && a <= c = a
  | b <= c && c <= a = c
  | c <= a && a <= b = a
  | c <= b && b <= a = b

mediana' :: Int -> Int -> Int -> Int
mediana' a b c = a + b + c - max a (max b c) - min a (min b c) 