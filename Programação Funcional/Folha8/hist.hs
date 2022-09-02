import Data.Char
import Data.Map (Map)
import qualified Data.Map as Map

--data Map k v = Empty | Node k v (Map k v) (Map k v)
--data Maybe a = Nothing | Just a
{--
insert :: Ord  k => k -> v -> Map k v -> Map k v
insert x v Empty = Node x v Empty Empty
inserir x v (Node y u l r)
    | x == y = Node x v l r
    | x > y  = Node y u l (inserir x v r)
    | x < y  = Node y u (inserir x v l) r
--}
histograma :: String -> [(Char,Int)]
histograma str = Map.toList (createMap (convert str) Map.empty)

convert :: String -> String -- 'limpar' a string, remover tudo o que nao sao letras
convert [] = []
convert (x:xs)
    | x >= 'A' && x <= 'Z' = toLower x : convert xs
    | x >= 'a' && x <= 'z' = x : convert xs
    | otherwise = convert xs

createMap :: String -> Map Char Int -> Map Char Int
createMap [] map = map
createMap (x:xs) map = case Map.lookup x map of
                Nothing -> createMap xs (Map.insert x 1 map)
                Just v -> createMap xs (Map.insert x (v+1) map)