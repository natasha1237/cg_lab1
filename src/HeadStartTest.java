public class HeadStartTest {
    public static void main(String[] args) {
        int failCounter = 0;
        failCounter = sphereIntersectTest(failCounter);
        failCounter = planeIntersectTest(failCounter);
        System.out.println("Total fails: " + failCounter);
        tracerIntersectTest(failCounter);
    }

    static int sphereIntersectTest(int failCounter) {
        Sphere sphereNoIntersect = new Sphere(new Point(30, 30, -100), 1);
        Sphere sphereIntersect = new Sphere(new Point(2, 2, 2), 1);
        Ray ray = new Ray();
        String result = sphereNoIntersect.intersect(ray);
        if (result.equals("None"))
            System.out.println("First sphere test | Intersect: None | Expected: None | Success");
        else {
            System.out.println("First sphere test | Intersect: " + result + " | Expected: None | Fail");
            failCounter ++;
        }
        result = sphereIntersect.intersect(ray);
        double stv = 2 - Math.sqrt(3)/3;
        Point str = new Point(stv, stv, stv);
        if (!result.equals("None") && new Point(result).equal(str))
            System.out.println("Second sphere test | Intersect: " + result + " | Expected: " + str + " | Success");
        else {
            System.out.println("Second sphere test | Intersect: " + result + " | Expected: " + str + " | Fail");
            failCounter ++;
        }
        return failCounter;
    }

    static int planeIntersectTest(int failCounter) {
        Plane planeNoIntersect = new Plane();
        Plane planeIntersect = new Plane(1, 1, 1, -30);
        Ray ray = new Ray();
        String result = planeNoIntersect.intersect(ray);
        if (result.equals("None"))
            System.out.println("First plane test | Intersect: None | Expected: None | Success");
        else {
            System.out.println("First plane test | Intersect: " + result + " | Expected: None | Fail");
            failCounter ++;
        }
        result = planeIntersect.intersect(ray);
        Point str = new Point(10, 10, 10);
        if (!result.equals("None") && new Point(result).equal(str))
            System.out.println("Second plane test | Intersect: " + result + " | Expected: " + str + " | Success");
        else {
            System.out.println("Second plane test | Intersect: " + result + " | Expected: " + str + " | Fail");
            failCounter ++;
        }
        return failCounter;
    }

    static int tracerIntersectTest(int failCounter) {
        Tracer tracer = new Tracer();
        Sphere sphere1 = new Sphere(new Point(10, 10, 25), 1);
        Sphere sphere2 = new Sphere(new Point(10, 15, 15), 10);
        Plane plane1 =  new Plane(1, 1, 1, -30);
        tracer.addObject(sphere1);
        tracer.addObject(sphere2);
        tracer.addObject(plane1);
        tracer.startTrace();
        tracer.printTraceResult();
        return failCounter;
    }
}
