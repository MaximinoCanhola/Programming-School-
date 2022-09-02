dialogo :: Int -> Int -> Int -> Int -> (String, String)
dialogo h1 m1 h2 m2 = (dialogo1 (minutos h1 m1 h2 m2), dialogo2 (horas h1 m1 h2 m2))

minutos :: Int -> Int -> Int -> Int -> Int
minutos h1 m1 h2 m2
  | m2 < m1 = (h2-h1-1)*60 + (60-m1) + m2
  | h1 == h2 = m2-m1
  | otherwise = (h2-h1)*60 + m2-m1

horas :: Int -> Int -> Int -> Int -> (Int,Int)
horas h1 m1 h2 m2
  | h2 == h1 = (0,m2-m1)
  | m2 < m1 = (h2-h1-1,(60-m1+m2)`mod`60)
  | otherwise = (h2-h1,(60-m1+m2)`mod`60)

dialogo1 :: Int -> String
dialogo1 m
  | m == 1 = "Passou apenas 1 minuto!"
  | otherwise = "Passaram apenas " ++ show m ++ " minutos!"

dialogo2 :: (Int,Int) -> String
dialogo2 (0,m) = "De facto!"
dialogo2 (1,0) = "Queres dizer, 1 hora?!"
dialogo2 (1,1) = "Queres dizer, 1 hora e 1 minuto?!"
dialogo2 (1,m) = "Queres dizer, 1 hora e "++show m++" minutos?!"
dialogo2 (h,0) = "Queres dizer, "++show h++" horas?!"
dialogo2 (h,1) = "Queres dizer, "++show h++" horas e 1 minuto?!"
dialogo2 (h,m) = "Queres dizer, "++show h++" horas e "++show m++" minutos?!"

