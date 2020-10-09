import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

//Логотип получил случайно, когда пытался исправить немного кривые кольца у планеты. Так и не исправил

public class Logo implements Drawable {
    private int x;
    private int y;
    private int size;
    private int rd;
    private Color color;

    Logo(int x, int y, int size, int rd, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.rd = rd;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.translate(x,y);
        gr.rotate(Math.toRadians(rd));
        gr.setColor(color);

        Area[] areas = new Area[8];
        for (int i=7;i>=0;i--){
            areas[i] = new Area(new Ellipse2D.Double(20,20,size/10*i,size/10*i));
            if (i!=7&&i%2==0)
                areas[7].subtract(areas[i]);
            if (i%2==1)
                areas[7].add(areas[i]);
        }
        gr.fill(areas[7]);

        gr.rotate(Math.toRadians(-rd));
        gr.translate(-x,-y);
    }
}