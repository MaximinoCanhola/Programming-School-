module Folha8 where

import Stack

parent :: String -> Bool
parent str = parentAux str empty

parentAux :: String -> Stack Char -> Bool
parentAux [] stk = isEmpty stk
parentAux (x:xs) stk
    | x == '(' = parentAux xs (push '(' stk)
    | x == ')' = not (isEmpty stk) && 
                 top stk == '(' &&
                 parentAux xs (pop stk)
    | x == '[' = parentAux xs (push '[' stk)
    | x == ']' = not (isEmpty stk) && 
                 top stk == '[' &&
                 parentAux xs (pop stk)
    | x == '{' = parentAux xs (push '{' stk)
    | x == '}' = not (isEmpty stk) && 
                 top stk == '{' &&
                 parentAux xs (pop stk)
    | otherwise = parentAux xs stk


calcular :: String -> Integer
calcular str =  calcularAux (words str) empty

calcularAux :: [String] -> Stack Integer -> Integer
calcularAux [] stk = top stk
calcularAux (x:xs) stk
    | x == "+" = calcularAux xs (push ( a + b) c)
    | x == "-" = calcularAux xs (push ( -a + b) c)
    | x == "*" = calcularAux xs (push ( a * b) c)
    | x == "/" = calcularAux xs (push ( div b a) c)
    | otherwise = calcularAux xs (push (read x :: Integer) stk)
    where
        a = top stk
        b = top (pop stk)
        c = pop (pop stk)


data Set a = Empty | Node a (Set a) (Set a)
    deriving (Show)

inserir :: Ord  a => a -> Set a -> Set a
inserir x Empty = Node x Empty Empty
inserir x (Node y esq dir)
    | x==y = Node y esq dir
    | x<y  = Node y (inserir x esq) dir
    | x>y  = Node y esq (inserir x dir)

union :: Ord a => Set a -> Set a -> Set a
union Empty b = b
union (Node x left right) b = union right (union left (inserir x b))


member :: Ord a => a -> Set a -> Bool
member x Empty = False
member x (Node y left right)
    | x == y = True
    | x > y = member x right
    | x < y = member x left

intersection :: Ord a => Set a -> Set a -> Set a
intersection Empty b = Empty
intersection (Node x left right) b
    | member x b = Node x (intersection left b) (intersection right b)
    | otherwise = union (intersection left b) (intersection right b)


filter' :: Ord a => (a -> Bool) -> Set a -> Set a 
filter' p Empty = Empty
filter' p (Node x left right)
    | p x = Node x (filter' p left) (filter' p right)
    | otherwise = union (filter' p left) (filter' p right)

