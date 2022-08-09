import java.util.ArrayList;

public class Screen {
    //можу бути будь-яких розмірів, але форма - паралелограм, паралельний або перпендикулярний до осей координат.
    Point leftTop;
    Point rightTop;
    Point rightBottom;
    Point leftBottom;
    ArrayList<ArrayList<Point>> screen = new ArrayList<>();
    ArrayList<ArrayList<String>> consoleScreen = new ArrayList<>();
    ArrayList<ArrayList<Point>> realPoint = new ArrayList<>();

    Screen() {
        leftTop = new Point(0, 19, 10);
        rightTop = new Point(20, 19, 10);
        rightBottom = new Point(19, 0, 10);
        leftBottom = new Point(0, 0, 10);
        for (int i = 0; i < 20; ++i) {
            screen.add(new ArrayList<Point>());
            for (int j = 0; j < 20; ++j)
                screen.get(i).add(new Point(i, j, 10));
        }
    }

    Screen(Screen screen) {
        leftTop = new Point(screen.leftTop);
        rightTop = new Point(screen.rightTop);
        rightBottom = new Point(screen.rightBottom);
        leftBottom = new Point(screen.leftBottom);
        this.screen = new ArrayList<ArrayList<Point>>(screen.screen);
        this.consoleScreen = new ArrayList<ArrayList<String>>(screen.consoleScreen);
        this.realPoint = new ArrayList<ArrayList<Point>>(screen.realPoint);
    }
}
