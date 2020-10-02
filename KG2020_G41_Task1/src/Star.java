import java.awt.*;

public class Star implements Drawable {
    private int x;
    private int y;
    private int size;
    private Color color;

    Star(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(color);
        Point p1 = new Point(x, y-size/2);//
        Point p2 = new Point(x-size/18 , y-size/18);
        Point p3 = new Point(x-size/2, y);//
        Point p4 = new Point(x-size/18 , y+size/18);
        Point p5 = new Point(x, y+size/2);//
        Point p6 = new Point(x+size/18, y+size/18 );
        Point p7 = new Point(x+size/2, y);//
        Point p8 = new Point(x+size/18, y-size/18 );
        int[] xCords = {p1.x, p2.x, p3.x, p4.x, p5.x, p6.x, p7.x, p8.x};
        int[] yCords = {p1.y, p2.y, p3.y, p4.y, p5.y, p6.y, p7.y, p8.y};
        gr.fillPolygon(xCords,yCords,8);
    }
}
