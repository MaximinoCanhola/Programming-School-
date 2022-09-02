class BigNumber {
    private int[] number;

    BigNumber(String n) {
        number = new int[n.length()];
        for (int i = n.length() - 1; i >= 0; i--) {
            number[n.length() - i - 1] = Character.getNumericValue(n.charAt(i));
        }
    }

    public boolean equals(BigNumber n) {
        if (n.number.length != number.length)
            return false;
        for (int i = 0; i < number.length; i++)
            if (n.number[i] != number[i])
                return false;
        return true;
    }

    public String toString() {
        String a = "";
        for (int i = number.length - 1; i >= 0; i--) {
            a += number[i];
        }
        return a;
    }

    public BigNumber add(BigNumber n) {
        String x = "";
        int resto = 0;
        for (int i = 0; i < number.length; i++) {
            if (i >= number.length) {
                x += n.number[i];
            } else if (i >= n.number.length) {
                x += number[i];
            } else {
                int y = number[i] + n.number[i] + resto;
                x += y % 10;
                resto = (y / 10) % 10;
            }
        }
        BigNumber numero = new BigNumber(x);
        return numero;
    }

    public BigNumber multiply(BigNumber n) {
        return n;
    }

}