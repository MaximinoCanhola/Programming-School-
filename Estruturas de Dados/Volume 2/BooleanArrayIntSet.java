class BooleanArrayIntSet implements IntSet {
    // Deverá colocar aqui os atributos e métodos
    private int size; // Numero de elementos do conjunto
    private boolean[] elem; // Array que contem os elementos em si

    BooleanArrayIntSet(int maxSize) {
        elem = new boolean[maxSize + 1];
        size = 0;
    }

    public boolean add(int x) {
        if (elem[x])
            return false;
        elem[x] = true;
        size++;
        return true;
    }

    public boolean remove(int x) {
        if (!elem[x])
            return false;
        elem[x] = false;
        size--;
        return true;
    }

    public boolean contains(int x) {
        if (elem[x])
            return true;
        return false;
    }

    public void clear() {
        for (int i = 1; i < elem.length; i++)
            if (elem[i])
                elem[i] = false;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean equals(IntSet s) {
        if (size != s.size())
            return false;
        for (int i = 1; i < elem.length; i++)
            if (elem[i])
                if (!s.contains(i))
                    return false;
        return true;
    }

    public IntSet intersection(IntSet s) {
        IntSet s1 = new BooleanArrayIntSet(elem.length);
        for (int i = 1; i < elem.length; i++)
            if (elem[i])
                if (s.contains(i))
                    s1.add(i);
        return s1;
    }
}