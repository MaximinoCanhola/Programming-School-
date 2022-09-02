import Data.List

decompor :: Int -> [Int]
decompor n
  | n < 5 = []
  | otherwise = [y] ++ decompor (n - y)
  where
    y = head ([x | x <- moedas, n - x >= 0])

moedas :: [Int]
moedas = [200, 100, 50, 20, 10, 5]

decomporTrans :: Int -> [Int] -> ([Int], [Int])
decomporTrans n l = (a, b)
  where
    a = decompor2 n l
    b = del l a

decompor2 :: Int -> [Int] -> [Int]
decompor2 n l
  | length l == 0 = []
  | n < (l !! ((length l) - 1)) = []
  | otherwise = [y] ++ decompor2 (n - y) (delete y l)
  where
    y = head ([x | x <- l, n - x >= 0])

del :: [Int] -> [Int] -> [Int]
del l [] = l
del (l1 : ls) (a1 : as)
  | elem l1 (a1 : as) = [] ++ del ls as
  | otherwise = [l1] ++ del ls (a1 : as)

transação :: (Int, [Int]) -> [Int] -> ([Int], [Int])
transação (quantia, moedas) list
  | (sum moedas) - quantia < 0 = (moedas, list)
  | otherwise = (list1, list2)
  where
    (list1, b) = decomporTrans ((sum moedas) - quantia) list
    list2 = reverse (sort (b ++ moedas))