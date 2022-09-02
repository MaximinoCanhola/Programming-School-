module Folha6 where

import Data.Char


elefantes :: Int -> IO ()
elefantes n = elefantes2 2 n

elefantes2 :: Int -> Int -> IO ()
elefantes2 a n | a == n = return ()
               | otherwise = do putStr s1
                                putStr s2
                                elefantes2 (a+1) n
    where
        s1 = "Se " ++ show(a) ++ " elefantes incomodam muita gente, \n"
        s2 = show(a+1) ++ " elefantes incomodam muito mais!\n"


contar :: IO ()
contar = do
        content <- readFile "contar.txt"
        let a = length (lines content)
        putStr (show a ++ "\n")
        let b = sum [ length (words x) | x <- lines content ]
        putStr (show b ++ "\n")
        let c = length content
        putStr (show c ++ "\n")


inverter :: IO ()
inverter = do
            content <- readFile "inverter.txt"
            let linhas = lines content
            invert linhas

invert :: [[Char]] -> IO ()
invert [] = return ()
invert (x:xs) = do
                putStr (reverse x ++ "\n")
                invert xs


rodar :: IO ()
rodar = do
        content <- readFile "inverter.txt"
        let linhas = lines content
        aux linhas

aux :: [[Char]] -> IO ()
aux [] = return ()
aux (x:xs) = do
                putStr (map rotate x ++ "\n")
                aux xs

rotate :: Char -> Char
rotate c | 'a' <= c && c <= 'z' = chr ((ord 'a') + mod x 26)
         | 'A' <= c && c <= 'Z' = chr ((ord 'A') + mod y 26)
         | otherwise = c
    where
        x = (ord c) - (ord 'a') + 13
        y = (ord c) - (ord 'A') + 13


adivinha :: String -> IO ()
adivinha word = do
                let txt = ['-' | x<- [1..length word]]
                putStr (txt ++ "\n")
                adivinha2 word txt 1

adivinha2 :: String -> [Char] -> Int -> IO ()
adivinha2 word txt n = do
                        putStr ("? ")
                        char <- getLine
                        let txt2 = aux2 (zip txt word) (char !! 0)
                        putStr (txt2 ++ "\n")
                        if (txt2 == txt) then do
                                putStr ("Nao ocorre \n")
                                adivinha2 word txt2 (n+1) else 
                                (if (txt2 == word) 
                                        then putStr ("Adivinhou em "++show(n)++" tentativas \n") else
                                        adivinha2 word txt2 (n+1))

aux2 :: [(Char,Char)] -> Char -> [Char]
aux2 [] c = []
aux2 ((a,b):l) c | b == c = [b] ++ aux2 l c
                | otherwise = [a] ++ aux2 l c


nim :: IO ()
nim = do 
        let l = [5,4,3,2,1]
        print1 1 l
        nim2 l

nim2 :: [Int] -> IO ()
nim2 l = do
        linha <- getLine
        let num = words linha
        let num1 = read (num !! 0) :: Int
        let num2 = read (num !! 1) :: Int
        let l2 = change num1 num2 (zip [1..] l)
        if (isEmpty l2) then putStr ("Ganhou!!\n") else 
                do
                print1 1 l2
                nim2 l2

change :: Int -> Int -> [(Int,Int)] -> [Int]
change a b [] = []
change a b ((c,d):l) | a == c = [d-b] ++ change a b l
                     | otherwise = [d] ++ change a b l

print1 :: Int -> [Int] -> IO ()
print1 _ [] = return ()
print1 n (x:xs) = do
                let l = take x (['*','*'..])
                putStr (show(n) ++ ": " ++ l ++ "\n")
                print1 (n+1) xs

isEmpty :: [Int] -> Bool
isEmpty [] = True
isEmpty (x:xs) | x /= 0 = False
               | otherwise = isEmpty xs
