public class Point {
    double x;
    double y;
    double z;

    Point() {
        x = 0;
        y = 0;
        z = 0;
    }

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point(Point point) {
        x = point.x;
        y = point.y;
        z = point.z;
    }

    Point(String sPoint) {
        sPoint = sPoint.substring(1, sPoint.length() - 1);
        String[] coordinates = sPoint.split("; ");
        x = Double.valueOf(coordinates[0]);
        y = Double.valueOf(coordinates[1]);
        z = Double.valueOf(coordinates[2]);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setLocation(Point point) {
        x = point.x;
        y = point.y;
        z = point.z;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }

    public void move(Point dPoint) {
        x += dPoint.x;
        y += dPoint.y;
        z += dPoint.z;
    }

    public void move(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    public Point add(Point point) {
        Point rP = new Point(this);
        rP.move(point);
        return rP;
    }

    public Point div(double d) {
        Point point = new Point(this);
        point.x /= d;
        point.y /= d;
        point.z /= d;
        return point;
    }

    public Point mul(double d) {
        Point point = new Point(this);
        point.x *= d;
        point.y *= d;
        point.z *= d;
        return point;
    }

    public Point sub(Point point) {
        double x = this.x-point.x;
        double y = this.y-point.y;
        double z = this.z-point.z;
        return new Point(x, y, z);
    }

    public double distanceSquared(Point point) {
        return (x-point.x) * (x-point.x) + (y-point.y) * (y-point.y) + (z-point.z) * (z-point.z);
    }

    public double distanceSquared(double x, double y, double z) {
        return (x-this.x) * (x-this.x) + (y-this.y) * (y-this.y) + (z-this.z) * (z-this.z);
    }

    public double distance(Point point) {
        return Math.sqrt(distanceSquared(point));
    }

    public double distance(double x, double y, double z) {
        return Math.sqrt(distanceSquared(x, y, z));
    }

    public Point nearest(Point[] points) {
        // найближча точка до поточної
        Point nP = points[0];
        for (Point point: points) {
            if (distance(point) < distance(nP))
                nP = point;
        }
        return nP;
    }

    public boolean equal(Point point) {
        if(Math.abs(point.x - x) > 1e-6)
            return false;
        if(Math.abs(point.y - y) > 1e-6)
            return false;
        if(Math.abs(point.z - z) > 1e-6)
            return false;
        return true;
    }
}
