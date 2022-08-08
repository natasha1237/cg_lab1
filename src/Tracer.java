import java.util.ArrayList;

public class Tracer {
    Camera camera;
    Screen screen;
    DirectedLightSource lightSource;
    ArrayList<Sphere> spheres;
    ArrayList<Plane> planes;

    Tracer() {
        camera = new Camera();
        screen = new Screen();
        lightSource = new DirectedLightSource();
    }

    Tracer(Camera camera, Screen screen, DirectedLightSource lightSource) {
        this.camera = new Camera(screen);
        this.screen = new Screen(screen);
        this.lightSource = new DirectedLightSource(lightSource);
    }

    public void addObject(Sphere sphere) {
        spheres.add(new Sphere(sphere));
    }

    public void addObject(Plane plane) {
        planes.add(new Plane(plane));
    }

    private Normal intersectTrace(Ray ray) {
        Point intersect = null;
        Normal iNormal = null;
        Point screenPoint = ray.getDirection().getVectorEnd();

        if(!spheres.isEmpty()) {
            for (Sphere sphere: spheres) {
                String intersectString = sphere.intersect(ray);
                if (!intersectString.equals("None")) {
                    Point intersectPoint = new Point(intersectString);
                    if (intersect == null)
                        intersect = intersectPoint;
                    else
                        if (screenPoint.distance(intersectPoint) < screenPoint.distance(intersect))
                            intersect = intersectPoint;
                    iNormal = new Normal(sphere, intersect);
                }
            }
        }

        if(!planes.isEmpty()) {
            for (Plane plane: planes) {
                String intersectString = plane.intersect(ray);
                if (!intersectString.equals("None")) {
                    Point intersectPoint = new Point(intersectString);
                    if (intersect == null)
                        intersect = intersectPoint;
                    else
                    if (screenPoint.distance(intersectPoint) < screenPoint.distance(intersect))
                        intersect = intersectPoint;
                    iNormal = new Normal(plane, intersect);
                }
            }

        }
        return iNormal;
    }

    public String defineSymbol(Normal iNormal) {
        // визначає символ для друкування на екрані
        double definer = lightSource.getLight().dotProduct(iNormal.getNormal());
        if (definer < 0)
            return " ";
        if (definer < 0.2)
            return ".";
        if (definer < 0.5)
            return "*";
        if (definer < 0.8)
            return "O";
        else
            return "#";
    }

    public void startTrace() {
        Normal currentIntersect = null;
        for (int i = 0; i < 20; ++i) {
            screen.realPoint.add(new ArrayList<Point>());
            screen.consoleScreen.add(new ArrayList<String>());
            for (int j = 0; j < 20; ++j) {
                currentIntersect = intersectTrace(camera.getRays().get(i).get(j));
                if (currentIntersect != null) {
                    screen.realPoint.get(i).add(currentIntersect.getPoint());
                    screen.consoleScreen.get(i).add(defineSymbol(currentIntersect));
                }
                else {
                    screen.realPoint.get(i).add(null);
                    screen.consoleScreen.get(i).add(" ");
                }
            }
        }
    }

    public void printTraceResult() {
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 20; ++j)
                System.out.println(screen.consoleScreen.get(i).get(j));
            System.out.println('\n');
        }
    }

}
