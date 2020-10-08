import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class MoonPlanet implements Drawable{
    private int x,y,plSize;
    private Color pcolor1,pcolor2;

    MoonPlanet(int x, int y, int plSize, Color pcolor1, Color pcolor2) {
        this.x=x;
        this.y=y;
        this.plSize=plSize;
        this.pcolor1 = pcolor1;
        this.pcolor2 = pcolor2;
    }
    @Override
    public void draw (Graphics2D gr) {


        gr.translate(x, y);

        Area planet = new Area(new Ellipse2D.Double(0,0,plSize,plSize));
        Area[] areas = new Area[plSize/8];
        int rr,xx,yy;
        for (int i=0; i<areas.length; i++){
            rr = 1 + (int)(Math.random()*3);
            xx = (int)((Math.random()*plSize));
            yy = (int)((Math.random()*plSize));
            areas[i] = new Area(new Ellipse2D.Double(xx,yy,plSize/12*rr,plSize/12*rr));
        }

        gr.setColor(pcolor1);

        gr.fill(planet);

        for (int i=0; i<areas.length; i++){
            planet.subtract(areas[i]);
        }

        gr.setColor(pcolor2);

        gr.fill(planet);

        gr.translate(-x, -y);

        gr.setColor(Color.CYAN);
    }
}