import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class smoothCornerRect {

    private int x;
    private int y;
    private int width;
    private  int height;
    private  int r;

    smoothCornerRect (int x, int y, int width, int height, int rOfCorner){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.r = rOfCorner;
    }

    public Area getSCR(){
        Area unitedArea = new Area(new Rectangle(x,y,width,height));

        Area tempRect = new Area(new Rectangle(x,y,r,r));
        Area tempEllps = new Area(new Ellipse2D.Double(x,y,r*2,r*2));

        unitedArea.subtract(tempRect);
        unitedArea.add(tempEllps);

        tempRect = new Area(new Rectangle(width+x-r,y,r,r));
        tempEllps = new Area(new Ellipse2D.Double(width+x-r*2,y,r*2,r*2));

        unitedArea.subtract(tempRect);
        unitedArea.add(tempEllps);

        tempRect = new Area(new Rectangle(width+x-r,height+y-r,r,r));
        tempEllps = new Area(new Ellipse2D.Double(width+x-r*2,height+y-r*2,r*2,r*2));

        unitedArea.subtract(tempRect);
        unitedArea.add(tempEllps);

        tempRect = new Area(new Rectangle(x,height+y-r,r,r));
        tempEllps = new Area(new Ellipse2D.Double(x,height+y-r*2,r*2,r*2));

        unitedArea.subtract(tempRect);
        unitedArea.add(tempEllps);

        return unitedArea;
    }
}
