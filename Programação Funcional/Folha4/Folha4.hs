module Folha4 where

algarismos :: Int -> [Int]
algarismos x = reverse (algAux x)

algAux :: Int -> [Int]
algAux 0 = []
algAux x = [mod x 10] ++ algAux (div x 10)

toBits :: Int -> [Int]
toBits x = reverse (bitAux x)

bitAux :: Int -> [Int]
bitAux 0 = []
bitAux x = [mod x 2] ++ bitAux (div x 2)

fromBits :: [Int] -> Int
fromBits [] = 0
fromBits (0 : xs) = fromBits xs
fromBits (x : xs) = 2 ^ (length xs) + fromBits xs

mdc :: Integer -> Integer -> Integer
mdc a 0 = a
mdc a b = mdc b (mod a b)

insert :: Ord a => a -> [a] -> [a]
insert n [] = [n]
insert n (x : xs)
  | n < x = n : x : xs
  | otherwise = x : insert n xs

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x : xs) = insert x (isort xs)

minimum' :: Ord a => [a] -> a
minimum' [x] = x
minimum' (x : xs) = min x (minimum' xs)

delete' :: Ord a => a -> [a] -> [a]
delete' n [] = []
delete' n (x : xs)
  | n == x = xs
  | otherwise = x : delete' n xs

ssort :: Ord a => [a] -> [a]
ssort [] = []
ssort l = m : ssort (delete' m l)
  where
    m = minimum' l

merge :: Ord a => [a] -> [a] -> [a]
merge l [] = l
merge [] l = l
merge (x : xs) (y : ys)
  | x < y = x : merge xs (y : ys)
  | y < x = y : merge (x : xs) ys
  | otherwise = x : y : merge xs ys

msort :: Ord a => [a] -> [a]
msort [] = []
msort [x] = [x]
msort l = merge (msort a) (msort b)
  where
    (a, b) = metades l

metades :: [a] -> ([a], [a])
metades l = (left, right)
  where
    left = take n l
    right = drop n l
    n = div (length l) 2

addPoly :: [Int] -> [Int] -> [Int]
addPoly p1 p2 = [x + y | (x, y) <- zip p1 p2]

multPoly :: [Int] -> [Int] -> [Int]
multPoly p1 p2 = [sum [x * y | (x, i1) <- zip p1 [0 ..], (y, i2) <- zip p2 [0 ..], z == i1 + i2] | z <- [0 .. m + n]]
  where
    m = (length p1) - 1
    n = (length p2) - 1
