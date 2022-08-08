import java.util.ArrayList;

public class Camera{
    Point camera;
    ArrayList<ArrayList<Ray>> rays;

    Camera() {
        camera = new Point();
        Screen screen = new Screen();

        for (int i = 0; i < 20; ++i) {
            rays.add(new ArrayList<Ray>());
            for (int j = 0; j < 20; ++j)
                rays.get(i).add(new Ray(camera, new Vector(screen.screen.get(i).get(j))));
        }
    }


    Camera(Screen screen) {
        camera = new Point();
        for (int i = 0; i < 20; ++i) {
            rays.add(new ArrayList<Ray>());
            for (int j = 0; j < 20; ++j)
                rays.get(i).add(new Ray(camera, new Vector(screen.screen.get(i).get(j))));
        }
    }

    Camera(Point camera, Screen screen) {
        this.camera = new Point(camera);
        for (int i = 0; i < 20; ++i) {
            rays.add(new ArrayList<Ray>());
            for (int j = 0; j < 20; ++j)
                rays.get(i).add(new Ray(camera, new Vector(screen.screen.get(i).get(j))));
        }
    }

    public Point getCamera() {
        return camera;
    }

    public ArrayList<ArrayList<Ray>> getRays() {
        return rays;
    }
}
