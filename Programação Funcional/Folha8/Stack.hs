module Stack (Stack,
              empty,
              isEmpty,
              pop,
              push,
              top
             ) where

data Stack a = Stk [a]

empty :: Stack a
empty = Stk []

push :: a -> Stack a -> Stack a
push x (Stk xs) = Stk (x:xs)

pop :: Stack a -> Stack a
pop (Stk (x:xs)) =  Stk xs
pop _  = error "Stack.pop: empty stack"

top :: Stack a -> a
top (Stk (x:xs)) = x
top _  = error "Stack.top: empty stack"

isEmpty :: Stack a -> Bool
isEmpty (Stk []) = True
isEmpty _        = False