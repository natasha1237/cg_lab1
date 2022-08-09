public class Vector {
    Point vectorStart;
    Point vectorEnd;

    Vector() {
        vectorStart = new Point();
        vectorEnd = new Point();
    }

    Vector(Vector vector) {
        vectorStart = new Point(vector.vectorStart);
        vectorEnd = new Point(vector.vectorEnd);
    }

    Vector(Point end) {
        vectorStart = new Point();
        vectorEnd = new Point(end);
    }

    Vector(Point start, Point end) {
        vectorStart = new Point(start);
        vectorEnd = new Point(end);
    }

    public Point getVectorStart() {
        return new Point(vectorStart);
    }

    public Point getVectorEnd() {
        return new Point(vectorEnd);
    }

    public Point getVectorized() {
        return new Point(vectorEnd.x-vectorStart.x, vectorEnd.y-vectorStart.y, vectorEnd.z-vectorStart.z);
    }

    public void setVectorStart(Point vectorStart) {
        this.vectorStart = new Point(vectorStart);
    }

    public void setVectorEnd(Point vectorEnd) {
        this.vectorEnd = new Point(vectorEnd);
    }

    public double dotProduct(Vector vector) {
        Point tV = getVectorized();
        Point vV = vector.getVectorized();
        return tV.x * vV.x + tV.y * vV.y + tV.z * vV.z;
    }

    public Vector crossProduct(Vector vector) {
        Point tV = getVectorized();
        Point vV = vector.getVectorized();
        double i = tV.y * vV.z - tV.z * vV.y;
        double j = tV.z * vV.x - tV.x * vV.z;
        double k = tV.x * vV.y - tV.y * vV.x;
        Point rV = new Point(i, j, k);
        return new Vector(rV);
    }

    public Vector doubleProduct(double d) {
        Point newEnd = this.vectorEnd.mul(d);
        return new Vector(this.vectorStart, newEnd);
    }

    public double length() {
        return vectorStart.distance(vectorEnd);
    }

    public Vector add(Vector vector) {
        Point tV = getVectorized();
        Point vV = vector.getVectorized();
        Point rV = new Point(tV.x+vV.x, tV.y+vV.y, tV.z+vV.z);
        return new Vector(rV);
    }

    public Vector sub(Vector vector) {
        Point tV = getVectorized();
        Point vV = vector.getVectorized();
        Point rV = new Point(tV.x-vV.x, tV.y-vV.y, tV.z-vV.z);
        return new Vector(rV);
    }

    public Vector div(double d) {
        Point vE = getVectorized().div(d);
        Point vS = new Point(vectorStart);
        return new Vector(vS, vE.add(vS));
    }

    public void move(Point dPoint) {
        vectorStart.move(dPoint);
        vectorEnd.move(dPoint);
    }
}
