import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class RingedPlanet implements Drawable{
    private int x,y,plSize,ringCount,inclination,texture;
    private Color pcolor1,pcolor2,rcolor;

    RingedPlanet(int x, int y, int plSize, int ringCount, int inclination, int texture, Color pcolor1, Color pcolor2, Color rcolor) {
        this.x=x;
        this.y=y;
        this.plSize=plSize;
        this.ringCount=ringCount;
        this.inclination = inclination;
        this.pcolor1 = pcolor1;
        this.pcolor2 = pcolor2;
        this.rcolor = rcolor;
        this.texture = texture;
    }
    @Override
    public void draw (Graphics2D gr) {

        GradientPaint gp1 = new GradientPaint(0, 0, pcolor1, 0, texture, pcolor2, true);

        gr.translate(x, y);
        int rd = inclination;
        gr.rotate(Math.toRadians(rd));

        int ringSizeH = plSize/4+ringCount*(plSize/8);
        int ringSizeW = ringSizeH*4;

        Area[] areas = new Area[ringCount*2];

        int xn = -ringSizeW/2;
        int xy = -ringSizeH/2;
        int itrx = xn / 20;
        int itry = xy / 20;

        for (int i=0;i<areas.length;i++){
            if (i==0) {
                Area area = new Area(new Ellipse2D.Double(xn, xy, ringSizeW, ringSizeH));
                areas[i]=area;
            }
            else if (i==1) {
                xn = xn - (itrx * 3);
                xy = xy - (itry * 3);
                ringSizeW = ringSizeW - ((ringSizeW / 20) * 3);
                ringSizeH = ringSizeH - ((ringSizeH / 20) * 3);
                Area area = new Area(new Ellipse2D.Double(xn,xy,ringSizeW,ringSizeH));
                areas[i]=area;
            }
            else {
                xn = xn - itrx;
                xy = xy - itry;
                ringSizeW = ringSizeW - (ringSizeW / 20)-plSize/24;
                ringSizeH = ringSizeH - (ringSizeH / 20)-plSize/40;
                Area area = new Area(new Ellipse2D.Double(xn,xy,ringSizeW,ringSizeH));
                areas[i]=area;
            }
        }
        Area unitedArea = areas[0];
        for (int i=1;i<areas.length;i++){
            if (i%2==1) {
                unitedArea.subtract(areas[i]);
            }
            else {
                unitedArea.add(areas[i]);
            }
        }

        gr.setPaint(gp1);
        gr.fillOval(-plSize/2, -plSize/2, plSize, plSize);

        Composite oldComposite = gr.getComposite();

        gr.setColor(rcolor);
        gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.9f));
        gr.fill(unitedArea);
        gr.setComposite(oldComposite);

        gr.setPaint(gp1);

        gr.fillArc(-plSize/2, -plSize/2, plSize, plSize, 0, 180);

        gr.rotate(Math.toRadians(-rd));
        gr.translate(-x, -y);

        gr.setColor(Color.CYAN);
    }
}