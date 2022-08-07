public class Screen {
    Point leftTop;
    Point rightTop;
    Point rightBottom;
    Point leftBottom;

    Screen() {
        leftTop = new Point(0, 20, 0);
        rightTop = new Point(20, 20, 0);
        rightBottom = new Point(20, 0, 0);
        leftBottom = new Point(0, 0, 0);
    }

    Screen(Screen screen) {
        leftTop = new Point(screen.leftTop);
        rightTop = new Point(screen.rightTop);
        rightBottom = new Point(screen.rightBottom);
        leftBottom = new Point(screen.leftBottom);
    }

    Screen(Point lT, Point rT, Point rB, Point lB) {
        leftTop = new Point(lT);
        rightTop = new Point(rT);
        rightBottom = new Point(rB);
        leftBottom = new Point(lB);
    }
}
