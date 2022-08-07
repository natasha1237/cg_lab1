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
}
