class Rectangle {

    Point ponto1, ponto2;

    Rectangle(int x1, int y1, int x2, int y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        ponto1 = p1;
        ponto2 = p2;
    }

    Rectangle(Point p1, Point p2) {
        ponto1 = p1;
        ponto2 = p2;
    }

    public int area() {
        int a = ponto2.x - ponto1.x;
        int b = ponto2.y - ponto1.y;
        return a * b;
    }

    public int perimeter() {
        return 2 * (ponto2.x - ponto1.x) + 2 * (ponto2.y - ponto1.y);
    }

    public boolean pointInside(Point p) {
        if ((ponto1.x <= p.x) & (p.x <= ponto2.x)) {
            if ((ponto1.y <= p.y) & (p.y <= ponto2.y)) {
                return true;
            }
        }
        return false;
    }

    public boolean rectangleInside(Rectangle r) {
        if ((ponto1.x <= r.ponto1.x) & (r.ponto2.x <= ponto2.x)) {
            if ((ponto1.y <= r.ponto1.y) & (r.ponto2.y <= ponto2.y)) {
                return true;
            }
        }
        return false;
    }
}