public class Ray {
    Point source;
    Vector direction;

    Ray() {
        source = new Point();
        Point directionEnd = new Point(1, 1, 1);
        direction = new Vector(source, directionEnd);
    }

    Ray(Ray ray) {
        this.source = new Point(ray.source);
        this.direction = new Vector(ray.direction);
    }

    Ray(Point source, Vector direction) {
        this.source = new Point(source);
        this.direction = new Vector(source, direction.getVectorized());
    }

    public Point getSource() {
        return source;
    }

    public Vector getDirection() {
        return direction;
    }



}
