module Folha3 where


divprop :: Integer -> [Integer]
divprop n = [x | x <- [1..(n-1)] , mod n x == 0]

perfeitos :: Integer -> [Integer]
perfeitos n = [ x| x <- [1..n] , sum(divprop x) == x]

pitagoricos :: Integer -> [(Integer, Integer, Integer)]
pitagoricos n = [ (a,b,c) | a <- [1..n], b <- [1..n], c <- [1..n], a^2 + b^2 == c^2]

primo :: Integer -> Bool
primo n = divprop n == [1]

binom :: Integer -> Integer -> Integer
binom n k = div num den
  where
    num = product [1 .. n]
    den = product [1 .. k] * product [1 .. (n - k)]

pascal :: Integer -> [[Integer]]
pascal p = [ [binom n k | k <- [0..n]] | n <- [0..p]]

concate' :: [[a]] -> [a]
concate' lists = [ l | list<- lists, l <- list ]

replicate' :: Int -> a -> [a]
replicate' n a = [a | n <- [1..n]]

(!!) :: [a] -> Int -> a
(!!) list n = head [ x | (i,x) <- zip [0..l] list, i == n ]
    where l = length list -1

myand :: [Bool] -> Bool
myand [] = True
myand (x:xs) = x && myand xs

myor :: [Bool] -> Bool
myor [] = False
myor (x:xs) = x || myor xs

forte :: String -> Bool
forte palavra = and [length palavra >= 8,maiuscula, minuscula, algaritmo]
    where maiuscula = or [c >= 'A' && c <= 'Z' | c <- palavra]
          minuscula = or [c >= 'a' && c <= 'z' | c <- palavra]
          algaritmo = or [c >= '0' && c <= '9' | c <- palavra]

mindiv :: Int -> Int
mindiv n = head ( drop 1 [ i |  i <- [1..round (sqrt (fromIntegral n))], mod n i == 0] ++ [n])

testprim :: Int -> Bool
testprim n = n > 1 && mindiv n == n

nub :: Eq a => [a] -> [a]
nub [] = []
nub (x:xs) = [x] ++ nub [c | c <- xs, c /= x]

intersperse :: a -> [a] -> [a]
intersperse c [] = []
intersperse c [x] = [x]
intersperse c (x:xs) = [x] ++ [c] ++ intersperse c xs