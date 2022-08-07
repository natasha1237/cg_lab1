public class Plane {
    /* ax + by + cz + d = 0 */
    double a;
    double b;
    double c;
    double d;

    Plane() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
        this.d = 0;
    }

    Plane(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public Normal getNormal() {
        return new Normal(this);
    }

    public boolean containsPoint(Point point) {
        return Math.abs(a*point.x+b*point.y+c*point.z+d) < 1e-6;
    }

    public boolean containsVector(Vector vector) {
        return containsPoint(vector.getVectorStart()) && containsPoint(vector.getVectorEnd());
    }

    public String typeIntersect(Ray ray) {
        Vector normal = getNormal().getNormal();
        Vector direction = ray.getDirection();
        double castResult = normal.dotProduct(direction);
        if (Math.abs(castResult) < 1e-6) {
            if (containsVector(direction))
                return "line";
            else
                return "none";
        }
        else
            return "point";
    }


}
