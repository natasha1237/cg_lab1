public class Normal {
    Vector normal;
    Point point;

    Normal(Plane plane, Point point){
        double dotX = - plane.getD() / plane.getA();
        Point pointX = new Point(dotX, 0, 0);
        double dotY = - plane.getD() / plane.getB();
        Point pointY = new Point(0, dotY, 0);
        double dotZ =  - plane.getD() / plane.getC();
        Point pointZ = new Point(0, 0, dotZ);

        Vector firstV = new Vector(pointX, pointY);
        Vector secondV = new Vector(pointX, pointZ);

        normal = firstV.crossProduct(secondV);
        normal = normal.div(normal.length());
        if (point == null)
            this.point = new Point(pointX);
        else
            this.point = point;
    }

    Normal(Sphere sphere, Point point) {
        this.normal = new Vector(sphere.getCenter(), point);
        this.normal = this.normal.div(this.normal.length());
        this.point = point;
    }

    public Vector getNormal() {
        return normal;
    }

    public Point getPoint() {
        return point;
    }

    public Vector getPointNormal() {
        Vector pointNormal = new Vector(this.normal);
        pointNormal.move(this.point);
        return pointNormal;
    }
}
