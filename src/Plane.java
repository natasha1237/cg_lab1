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

    Plane(Plane plane) {
        a = plane.a;
        b = plane.b;
        c = plane.c;
        d = plane.d;
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
        return new Normal(this, null);
    }

    public boolean containsPoint(Point point) {
        return Math.abs(a*point.x+b*point.y+c*point.z+d) < 1e-6;
    }

    public boolean containsVector(Vector vector) {
        return containsPoint(vector.getVectorStart()) && containsPoint(vector.getVectorEnd());
    }

    public String intersect(Ray ray) {
        Vector normal = getNormal().getNormal();
        Vector direction = ray.getDirection();
        double castResult = normal.dotProduct(direction);
        if (Math.abs(castResult) < 1e-6) {
            if (containsVector(direction))
                return ray.direction.getVectorEnd().toString();
            else
                return "None";
        }
        else {
            Vector pl = new Vector(getNormal().getPoint().sub(direction.getVectorStart()));
            double d = pl.dotProduct(normal) / direction.dotProduct(normal);
            if (d >= 1)
                    return ray.getDirection().doubleProduct(d).getVectorEnd().toString();
            else
                // випадок для перетину, коли площина перед екраном
                return "None";

        }
    }

    public Point pointIntersect(Ray ray) {
        Vector normal = getNormal().getNormal();
        Vector direction = ray.getDirection();
        Vector pl = new Vector(getNormal().getPoint().sub(direction.getVectorStart()));
        double d = pl.dotProduct(normal) / direction.dotProduct(normal);
        return ray.getDirection().doubleProduct(d).getVectorEnd();
    }
}
