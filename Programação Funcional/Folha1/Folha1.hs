module Folha1 where

incr, triplo :: Integer -> Integer
incr x = x + 1
triplo x = 3 * x

boasVindas :: String -> String
boasVindas nome = "Olá, " ++ nome ++ "!"

{-
Folha 1
ex 1.1

a)
incr (triplo 3)
incr (3*3)
incr 9
9+1
10

c)
boasVindas "linguagem" ++ " Haskell"
"Olá, linguagem!"++" Haskell"
"Olá, linguagem! Haskell"

d)
boasVindas ("linguagem" ++ " Haskell")
boasVindas linguagem Haskell"
"Olá, linguagem Haskell!"

e)
boasVindas (boasVindas "Haskell")
boasVindas (Olá, Haskell!)
Olá, Olá, Haskell!!
-}

testaTriangulo :: Float -> Float -> Float -> Bool
testaTriangulo a b c = ((a < b + c) && (b < a + c) && (c < a + b))

testaTriangulo' :: Float -> Float -> Float -> Bool
testaTriangulo' a b c
  | a >= b + c = False
  | b >= a + c = False
  | c >= a + b = False
  | otherwise = True

areaTriangulo :: Float -> Float -> Float -> Float
areaTriangulo a b c = sqrt (s * (s - a) * (s - b) * (s - c))
  where
    s = (a + b + c) / 2

binom :: Integer -> Integer -> Integer
binom n k = div num den
  where
    num = product [1 .. n]
    den = product [1 .. k] * product [1 .. (n - k)]

binom' :: Integer -> Integer -> Integer
binom' n k
  | k < n - k = div num1 den1
  | k >= n - k = div num2 den2
  where
    num1 = product [(n - k + 1) .. n]
    den1 = product [1 .. k]
    num2 = product [(k + 1) .. n]
    den2 = product [1 .. (n - k)]

metades :: [a] -> ([a], [a])
metades l = (left, right)
  where
    left = take n l
    right = drop n l
    n = div (length l) 2

last' :: [a] -> a
last' l = head (reverse l)

last'' :: [a] -> a
last'' l = head (drop (length l - 1) l)

init' :: [a] -> [a]
init' l = reverse (tail (reverse l))

init'' :: [a] -> [a]
init'' l = take (length l - 1) l