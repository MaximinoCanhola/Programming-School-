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


