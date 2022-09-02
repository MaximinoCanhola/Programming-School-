module Folha5 where

import Data.List
import Data.Char

divisores :: Int -> [Int]
divisores n = filter (\d -> mod n d == 0) [2 .. n]


primo :: Integer -> Bool
primo n
  | n <= 1 = False
  | otherwise = all (\p -> mod n p /= 0) [2 .. m]
  where
    m = floor (sqrt (fromIntegral n))


(++) :: [a] -> [a] -> [a]
xs ++ ys = foldr f z lista
  where
    f = (:)
    z = ys
    lista = xs


concat' :: [[a]] -> [a]
concat' lists = foldr f z lists
  where
    f = (\a b -> a Prelude.++ b)
    z = []


reverse' :: [a] -> [a]
reverse' xs = foldr f z xs
  where
    f = (\a b -> b Prelude.++ [a])
    z = []


reverse'' :: [a] -> [a]
reverse'' xs = foldl f z xs
  where
    f = (\a b -> [b] Prelude.++ a)
    z = []


elem' :: Eq a => a -> [a] -> Bool
elem' x l = any (x ==) l


fromBits :: [Int] -> Int
fromBits l = foldl f z l
  where
    f = (\a b -> 2 * a + b)
    z = 0


zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' f [] ys = []
zipWith' f xs [] = []
zipWith' f (x : xs) (y : ys) = f x y : zipWith' f xs ys


palavras :: String -> [String]
palavras s
  | s == "" = []
  | aux s == "" = []
  | otherwise = a : palavras (aux x)
  where
    a = takeWhile (/= ' ') (aux s)
    x = dropWhile (/= ' ') (aux s)

aux :: String -> String
aux s = dropWhile (== ' ') s


scanleft :: (b -> a -> b) -> b -> [a] -> [b]
scanleft f z [] = [z]
scanleft f z (x:xs) = z : scanleft f (f z x) xs


isort :: Ord a => [a] -> [a]
isort list = foldr f z list
  where
    f = (\x l -> insert x l)
    z = []


aproxPi1 :: Int -> Double
aproxPi1 n =  sum l
  where
    l = zipWith f xs ys
    f = (/)
    xs = list4
    ys = [ 2*i+1 | i<-[0.. fromIntegral (n-1)]]

aproxPi2 :: Int -> Double
aproxPi2 n = sum l
  where
    l = 3:zipWith f xs ys
    f = (/)
    xs = list4
    ys = [ product [2 * (i + 1), 2 * (i + 1) + 1, 2 * (i + 1) + 2] | i<-[0.. fromIntegral (n-2)]]

list4 :: [Double]
list4 = (4:(-4):list4)


binom :: Integer -> Integer -> Integer
binom n k = div num den
  where
    num = product [1 .. n]
    den = product [1 .. k] * product [1 .. (n - k)]

binom2 :: Integer -> Integer -> Integer
binom2 _ 0 = 1
binom2 n k | n == k = 1
           | otherwise = binom2 (n-1) (k-1) + binom2 n (k-1)

pascalinf :: [[Integer]]
pascalinf = [ [binom n k | k <- [0..n]] | n <- [0..]]

pascalinf2 :: [[Integer]]
pascalinf2 = [ [binom2 n k | k <- [0..n]] | n <- [0..]]


goldbach :: Integer -> (Integer, Integer)
goldbach n = head [(a,b) | a <- l, b <- l, a + b == n]
  where
    l = takeWhile (<=n) primos

primos :: [Integer]
primos = crivo [2..]

crivo :: [Integer] -> [Integer]
crivo (p:xs) = p : crivo [x | x<-xs, x`mod`p/=0]

hamming :: [Integer]
hamming = concat [ hamming2 n | n<-[0..]]

hamming2 :: Integer -> [Integer]
hamming2 n = [ 2^i*3^j*5^k | i<-[0..n], j<-[0..n], k<-[0..n], i+j+k == n ]


vigenere :: String -> String -> String
vigenere chave mensagem = texto
  where
    texto = [chr (aux2 a b) | (a,b)<- zip (mensagem) (cycle chave) ]

aux2 :: Char -> Char -> Int
aux2 a b | n > ord 'Z' = n - (ord 'Z') + (ord 'A') - 1
       | otherwise = n
  where
    n = (ord a) + (ord b) - (ord 'A')