public class Sphere {
    Point center;
    double radius;

    Sphere() {
        center = new Point();
        radius = 1;
    }

    Sphere(Sphere sphere) {
        this.center = new Point(sphere.center);
        this.radius = sphere.radius;
    }

    Sphere(Point center, double radius) {
        this.center = new Point(center);
        this.radius = radius;
    }

    public boolean inSphere(Point point) {
        return center.distance(point) <= radius;
    }

    public String intersect(Ray ray) {
        if (inSphere(ray.getDirection().getVectorEnd()))
            // оскільки вектор променю задається з камери до точки на екрані, перевіряємо чи ця точка на екрані в сфері
            return ray.direction.getVectorEnd().toString();

        Vector d = ray.getDirection();
        Vector k = new Vector(center, ray.source);
        double a = d.dotProduct(d);
        double b = 2 * k.dotProduct(d);
        double c = k.dotProduct(k);

        double D = b*b - 4*a*c;

        if (D >= 0) {
            double t1 = (- b - Math.sqrt(D)) / (2*a);
            double t2 = (- b + Math.sqrt(D)) / (2*a);
            if (t1 >= 1 && t2 >= 1) {
                Point p1 = d.vectorEnd.mul(t1);
                Point p2 = d.vectorEnd.mul(t2);
                if (p1.distance(d.getVectorEnd()) > p2.distance(d.getVectorEnd()))
                    return p2.toString();
                else
                    return p1.toString();
            }
            if (t1 >= 1)
                return d.vectorEnd.mul(t1).toString();
            if (t2 >= 1)
                return d.vectorEnd.mul(t2).toString();
        }
        return "None";
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
