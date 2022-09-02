import Log

-- Exercicio 1

parseMessage :: String -> LogEntry
parseMessage s | valid s = LogMessage (msgtype s) (time s) (string s)
               | otherwise = Unknown s

msgtype :: String -> MessageType
msgtype s | s!!0 == 'I' = Info
          | s!!0 == 'W' = Warning
          | s!!0 == 'E' = Error (read ((words s)!!1) :: Int)

time :: String -> TimeStamp 
time s | s!!0 == 'E' = read ((words s)!!2) :: Int
       | otherwise = read ((words s)!!1) :: Int

string :: String -> String
string s | s!!0 == 'E' = unwords (drop 3 (words s))
         | otherwise = unwords (drop 2 (words s))

valid :: String -> Bool
valid s | (words s)!!0 /= "I" && (words s)!!0 /= "W" && (words s)!!0 /= "E" = False
        | otherwise = True 


-- Exercicio 2

parseLog :: String -> [LogEntry]
parseLog txt = map parseMessage (lines txt)


insert :: LogEntry -> MessageTree -> MessageTree
insert (Unknown s) Empty = Empty 
insert (Unknown s) tree = tree
insert log Empty = Node log Empty Empty
insert (LogMessage type1 time1 str1) (Node (LogMessage type2 time2 str2) esq dir)
       | time1 == time2 = Node (LogMessage type2 time2 str2) esq (insert (LogMessage type1 time1 str1) dir)
       | time1 < time2 = Node (LogMessage type2 time2 str2) (insert (LogMessage type1 time1 str1) esq) dir
       | time1 > time2 = Node (LogMessage type2 time2 str2) esq (insert (LogMessage type1 time1 str1) dir)


-- Exercicio 3

build :: [LogEntry] -> MessageTree    -- construir uma árvore ordenada
build [] = Empty
build (log1:logs) = insert log1 (build logs)

inOrder :: MessageTree -> [LogEntry]  -- listar mensagens por ordem
inOrder Empty = []
inOrder (Node log esq dir) = inOrder esq ++ [log] ++ inOrder dir


datacenter :: IO ()
datacenter = do 
       texto <- readFile ("error.log")
       --putStr (texto)
       let lista = parseLog texto
       let tree = build lista
       let order = inOrder tree
       printMessages order

printMessages :: [LogEntry] -> IO ()
printMessages [] = return ()
printMessages (log1:logs) = do 
                            if (check50 log1) then do
                                   putStrLn (show(log1))
                                   printMessages logs
                                   else printMessages logs


check50 :: LogEntry -> Bool
check50 (LogMessage (Error grav) t s) | grav >= 50 = True
                             | otherwise = False
check50 (LogMessage msg t s) = False
check50 (Unknown s) = False
