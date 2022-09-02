>module Folha9 where

9.1

>data Nat = Zero | Succ Nat
>Zero + y = y                --adicao.1
>Succ x + y = Succ (x+y)     --adicao.2

Caso base : x = Zero
Quero provar que : Zero + (y + z) = (Zero + y) + z
Zero + (y + z) = {adicao.1} = (y + z) = {adicao.1}
= (Zero + y) + z


Hipotese de inducao : x + (y + z) = (x + y) + z
Tese : Succ x + (y + z) = Succ (x+y) + z

Succ x + (y + z) = {adicao.2} = Succ (x + (y + z))
= {hipotese} = Succ ((x + y) + z) = {adicao.2}
= Succ (x + y) + z


9.2

>[] ++ ys = ys                    --concat.1
>(x:xs) ++ ys = x : (xs ++ ys)    --concat.2

Caso base : xs = []
Quero provar que : ([] ++ ys) ++ zs = [] ++ (ys ++ zs)
([] ++ ys) ++ zs = {concat.1} = ys ++ zs = {concat.1}
= [] ++ (ys ++ zs)


Hipotese de inducao : (xs ++ ys) ++ zs = xs ++ (ys ++ zs)
Tese : ((x:xs) ++ ys) ++ zs = (x:xs) ++ (ys ++ zs)

((x:xs) ++ ys) ++ zs = {concat.2} = x : (xs ++ ys) ++ zs
= {hipotese} = (x : xs) ++ (ys ++ zs)


9.3

>reverse [] = []                         -- rev.1  
>reverse (x:xs) = reverse xs ++ [x]      -- rev.2

Caso base : xs = []
Quero provar que : reverse ([] ++ ys) = reverse ys ++ reverse []
reverse ([] ++ ys) = {rev.2} = reverse ys ++ reverse []


Hipotese de inducao : reverse (xs ++ ys) = reverse ys ++ reverse xs
Tese : reverse ((x:xs) ++ ys) = reverse ys ++ reverse (x:xs)

reverse ((x:xs) ++ ys) = {prop. de listas}
= reverse ((x ++ xs) ++ ys) = {9.2}
= reverser (x ++ (xs ++ ys)) = {prop. de listas}
= reverse (x : (xs ++ ys)) = {rev.2}
= reverse (xs ++ ys) ++ reverse x

reverse ys ++ reverse (x:xs) = {rev.2}
= reverse ys ++ (reverse xs ++ reverse x) = {9.2}
= (reverse ys ++ reverse xs) ++ reverse x = {rev.2}
= reverse (xs ++ ys) ++ reverse x


9.4

> map f [] = []                      -- map.1
> map f (x:xs) = f x : map f xs      -- map.2

> (f o g) x = f (g x)               -- composta.1

Quero mostrar que :     map f (map g xs) = map (f o g) xs

Caso base : xs = []
Quero mostrar que : map f (map g []) = map (f o g) []

map f (map g []) = {map.1} = map f [] = {map.1} = []

map (f o g) [] = {map.1} = []

Caso base provado

Hipotese de inducao : map f (map g xs) = map (f o g) xs

Tese : map f (map g (x:xs)) = map (f o g) (x:xs)

map f (map g (x:xs)) = {map.2} = map f (g x : map g xs)
= {map.2} = f (g x) : map f (map g xs) = {hipotese}
= f (g x) : map (f o g) xs

map (f o g) (x:xs) = {map.2} = (f o g) x : map (f o g) xs
= {composta.1} = f (g x) : map (f o g) xs

Prova concluida


9.5

> take 0 xs = []                            -- take.1
> take n [] | n > o = []                    -- take.2
> take n (x:xs) | n > 0 = x : take (n-1) xs -- take.3

> drop 0 xs = xs                            -- drop.1
> drop n [] | n > 0 = []                    -- drop.2
> drop n (x:xs) | n > 0 = drop (n-1) xs     -- drop.3

Quero mostrar que take n xs ++ drop n xs = xs

Caso base : n = 0

Quero mostrar que : take 0 xs ++ drop 0 xs = xs

take 0 xs ++ drop 0 xs = {take.1} = [] ++ drop 0 xs
= {drop.1} = [] ++ xs = xs

Caso base provado

Hipotese de inducao : take 0 xs ++ drop 0 xs = xs

Tese : take 1 xs ++ drop 1 xs = xs

Caso  xs = [] :

take 1 [] ++ drop 1 [] = {take.2} = [] ++ drop 1 []
= {drop.2} = [] ++ [] = []

Caso xs /= [] :

take 1 (x:xs) ++ drop 1 (x:xs) = {take.3 e drop.3}
= x: take 0 xs ++ drop 0 xs = {++ associativo}
= x : (take 0 xs ++ drop 0 xs) = {hipotese}
= x : (xs) = (x:xs)

Prova concluida


9.6

> map f [] = []                      -- map.1
> map f (x:xs) = f x : map f xs      -- map.2

> length [] = []                     -- length.1
> length (x:xs) = 1 + length xs      -- length.2

Caso base : xs = []
Quero mostrar que length (map f []) = length []

length (map f []) = {map.1} = length []


Hipotese de inducao : length (map f xs) = length xs

Tese : length (map f (x:xs)) = length (x:xs)

length (map f (x:xs)) = {map.2} = length (f x : map f xs)
= {length.2} = 1 + length (map f xs) = {hipotese}
= 1 + length xs

length (x:xs) = {length.2} = 1 + length xs

Prova concluida


9.7

> length [] = 0                      -- length.1
> length (x:xs) = 1 + length xs      -- length.2

> map f [] = []                      -- map.1
> map f (x:xs) = f x : map f xs      -- map.2

> sum [] = 0                        -- sum.1
> sum (x:xs) = x + sum xs           -- sum.2

Quero provar que    sum (map (1+) xs) = length xs + sum xs

Caso base : xs = []
Quero provar que sum (map (1+) []) = length xs + sum xs

sum (map (1+) []) = {map.1} = sum [] = {sum.1} = []

length [] + sum [] = {length.1 e sum.1} = [] + [] = []


Hipotese de inducao : sum (map (1+) xs) = length xs + sum xs

Tese : sum (map (1+) (x:xs)) = length (x:xs) + sum (x:xs)

sum (map (1+) (x:xs)) = {map.2}
= sum ((x + 1) : map (1+) xs) = {sum.2}
= (x + 1) + sum (map (1+) xs) = {hipotese}
= (x + 1) + (length xs + sum xs)

length (x:xs) + sum (x:xs) = {length.2}
= 1 + length xs + sum (x:xs) = {sum.2}
= 1 + length xs + x + sum xs = {+ associativo} 
= (x+1) + (length xs + sum xs)


9.8

> map f [] = []                      -- map.1
> map f (x:xs) = f x : map f xs      -- map.2

>[] ++ ys = ys                    --concat.1
>(x:xs) ++ ys = x : (xs ++ ys)    --concat.2

Quero provar que    map f (xs++ys) = map f xs ++ map f ys

Caso base : xs = []
Quero provar que : map f ([]++ys) = map f [] ++ map f ys

map f ([]++ys) = {map.2} = f [] ++ map f ys


Hipotese de inducao : map f (xs++ys) = map f xs ++ map f ys

Tese : map f ((x:xs)++ys) = map f (x:xs) ++ map f ys

map f ((x:xs)++ys) = {concat.2} 
= map f (x:(xs++ys)) = {map.2} = f x : map f (xs++ys)
= {hipotese} = f x : (map f xs ++ map f ys)

map f (x:xs) ++ map f ys = {map.2 e ++ assoc}
= f x : (map f xs ++ map f ys)

Prova concluida


9.9

> reverse [] = []                       --reverse.1
> reverse (x:xs) = reverse xs ++ [x]    -- reverse.2

> map f [] = []                      -- map.1
> map f (x:xs) = f x : map f xs      -- map.2

Quero provar que    map f (reverse xs) = reverse (map f xs)

Caso base : xs = []
Quero provar que : map f (reverse []) = reverse (map f [])

map f (reverse []) = {reverse.1} = map f [] = {map.1}
= [] = {reverse.1} = reverse [] = {map.1}
= reverse (map f [])


Hipotese : map f (reverse xs) = reverse (map f xs)

Tese : map f (reverse (x:xs)) = reverse (map f (x:xs))

map f (reverse (x:xs)) = {reverse.2}
= map f (reverse xs ++ [x]) = {9.8}
= map f (reverse xs) ++ map f [x] = {hipotese}
= reverse (map f xs) ++ map f [x] = {map.2}
= reverse (map f xs) ++ f x ++ map f [] = {map.1}
= reverse (map f xs) ++ f x

reverse (map f (x:xs)) = {map.2}
= reverse (f x : map f xs) = {reverse.2}
= reverse (map f xs) ++ f x

Prova concluida


9.10

> length [] = 0                     -- length.1
> length (x:xs) = 1 + length xs      -- length.2

> inserir x [] = []                             --inserir.1
> inserir x (y:ys) | x <= y = x:y:ys            --inserir.2
> inserir x (y:ys) | x > y = y : inserir x ys   --inserir.3

Quero provar que    length (inserir x xs) = 1 + length xs

Caso base : xs = []
Quero provar que : length (inserir x []) = 1 + length []

length (inserir x []) = {inserir.1} = length [x]
= {length.2} = 1 + length [] = {length.1} = 1

1 + length [] = {length.1} = 1


Hipotese de inducao : length (inserir x xs) = 1 + length xs

Tese : length (inserir x (y:xs)) = 1 + length (y:xs)

Caso x <= y :
length (inserir x (y:xs)) = {inserir.2}
= length (x:y:xs) = {length.2}
= 1 + length (y:xs) = {length.2}
= 1 + 1 + length xs

1 + length (y:xs) = {length.2}
= 1 + 1 + length xs

Caso Provado

Caso x > y :
length (inserir x (y:xs)) = {inserir.3}
= length (y:inserir x xs) = {length.2}
= 1 + length (inserir x xs) = {hipotese}
= 1 + 1 + length xs

1 + length (y:xs) = {length.2}
= 1 + 1 + length xs

Caso Provado

Prova Concluida
