validar :: Integer -> Bool
validar x = (mod y 10) == 0
  where
    y = sum' (merge a b)
    a = impar (algarismos x)
    b = duplica (algarismos x)

sum' :: [Integer] -> Integer
sum' [] = 0
sum' (x:xs) | x < 10 = x + sum' xs
            | otherwise = mod x 10 + mod (div x 10) 10 + sum' xs

merge :: [Integer] -> [Integer] -> [Integer]
merge [] (y) = y
merge (x) [] = x
merge (x:xs) (y:ys) = y:x:merge xs ys

impar :: [Integer] -> [Integer]
impar l | mod (length l) 2 == 0 = [ x | (x,i) <- zip l [0..], mod i 2 == 1 ]
        | otherwise = [ x | (x,i) <- zip l [0..], mod i 2 == 0 ]


duplica :: [Integer] -> [Integer]
duplica l | mod (length l) 2 == 0 = [ 2*x | (x,i) <- zip l [0..], mod i 2 == 0 ]
          | otherwise = [ 2*x | (x,i) <- zip l [0..], mod i 2 == 1 ]

algarismos :: Integer -> [Integer]
algarismos x = reverse (algAux x)

algAux :: Integer -> [Integer]
algAux 0 = []
algAux x = [mod x 10] ++ algAux (div x 10)