public class SinglyLinkedList<T> {
    private Node<T> first; // Primeiro no da lista
    private int size; // Tamanho da lista

    // Construtor (cria lista vazia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo com for e uso de de size para mostrar alternativa ao while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    public T get(int pos) {
        Node<T> bola = first;
        if (pos < 0 | pos >= size())
            return null;
        for (int i = 0; i < pos; i++)
            bola = bola.getNext();
        return bola.getValue();
    }

    public T remove(int pos) {
        if (pos < 0 | pos >= size() | isEmpty())
            return null;
        Node<T> bola = first;
        T valor = get(pos);
        if (pos == 0) {
            first = first.getNext();
        } else {
            for (int i = 0;i<pos-1;i++)
                bola = bola.getNext();
            bola.setNext(bola.getNext().getNext());
        }
        size--;
        return valor;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> cur = first;
        for (int i = 0;i < size();i++) {
            newList.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return newList;
    }

    public void duplicate() {
        Node<T> cur = first;
        for (int i = 0; i < size();i++) {
            Node<T> dup = new Node<>(cur.getValue(),cur.getNext());
            cur.setNext(dup);
            cur = cur.getNext().getNext();
        } 
        size = 2*size();
    }

    public int count(T value) {
        int contador = 0;
        Node<T> cur = first;
        for (int i = 0;i < size();i++) {
            if (value.equals(cur.getValue()))
                contador++;
            cur = cur.getNext();
        }
        return contador;
    }

    public void removeAll(T value) {
        if (size() == 0)
            return;
        
        if (size() == 1) {
            if (first.getValue().equals(value)) {
                first = null;
                size--;
            }
            return;
        }

        while (first.getNext() != null &  first.getValue().equals(value)) {
            first = first.getNext();
            size--;
            if (first.getNext() == null) {
                if (first.getValue().equals(value)) {
                    first = null;
                    size--;
                }
                return;
            }
        }
        Node<T> cur = first;
        Node<T> cur2 = first;
        while (cur2.getNext() != null) {
            if (cur2.getNext().getValue().equals(value)) {
                while (cur2.getNext().getValue().equals(value)) {
                    cur2 = cur2.getNext();
                    size--;
                    if (cur2.getNext() == null) {
                        cur.setNext(null);
                        return;
                    }
                }
                cur.setNext(cur2.getNext());
                cur2 = cur2.getNext();
                cur = cur2;
            } else {
                cur = cur.getNext();
                cur2 = cur2.getNext();
                if (cur2.getNext() == null)
                    return;
            }
        }
    }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> rev = new SinglyLinkedList<>();
        Node<T> cur = first;
        for (int i = 0; i < size();i++) {
            rev.addFirst(cur.getValue());
            cur = cur.getNext();
        }
        return rev;
    }

    public int[] occurrences(T elem) {
        SinglyLinkedList<Integer> aux = new SinglyLinkedList<>();
        Node<T> cur = first;
        for (int i = 0;i<size();i++) {
            if (cur.getValue().equals(elem)) {
                aux.addLast(i);
            } else {
                aux.addLast(-1);
            }
            cur = cur.getNext();
        }
        //System.out.println(aux);
        aux.removeAll(-1);
        //System.out.println(aux);
        if (aux.size() == 0)
            return null;
        int[] x = new int[aux.size()];
        Node<Integer> cur2 = aux.first;
        for (int i = 0;i<aux.size();i++) {
            x[i] = (int)cur2.getValue();
            cur2 = cur2.getNext();
        }
        return x;
    }

    public void remove(SinglyLinkedList<T> toRemove) {
        Node<T> cur = toRemove.first;
        for (int i = 0; i < toRemove.size();i++) {
            removeAll(cur.getValue());
            if (size() == 0)
                break;
            cur = cur.getNext();
        }
    }

    public SinglyLinkedList<T> cut(int a, int b) {
        SinglyLinkedList<T> lista = new SinglyLinkedList<>();
        Node<T> cur = first;
        for (int i = 0;i<a;i++)
            cur = cur.getNext();
        for (int i = a; i <=b;i++) {
            lista.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return lista;
    }

    public void shift(int k) {
        if (k%size == 0)
            return;
        Node<T> antigofirst = first;
        Node<T> ultimo = first;
        for (int i = 0;i<size-k-1;i++)
            ultimo = ultimo.getNext();
        Node<T> novofirst = ultimo.getNext();
        first = novofirst;
        Node<T> ultimo2 = ultimo;
        for (int i = size-k;i<size;i++)
            ultimo2 = ultimo2.getNext();
        ultimo2.setNext(antigofirst);
        ultimo.setNext(null);
    }
}

    


