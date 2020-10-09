import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class ISSWindow implements Drawable {
    private int width;
    private int height;
    private String string;

    ISSWindow(int width, int height, String string) {
        this.width = width;
        this.height = height;
        this.string = string;
    }

    @Override
    public void draw(Graphics2D gr) {
        Area area1 = new Area (new Rectangle(0,0,width,height));
        Area area2 = new Area(new Rectangle(20,20,width-40,height-40));
        Area area3 = new Area(new Rectangle(30,30,width-60,height-60));
        smoothCornerRect smCrnrRect = new smoothCornerRect(20,20,width-140,height-50,40);
        area1.subtract(smCrnrRect.getSCR());
        smCrnrRect = new smoothCornerRect(25,25,width-150,height-60,40);
        area2.subtract(smCrnrRect.getSCR());
        //area2.subtract(area1);
        Composite oldComposite = gr.getComposite();

        gr.setColor(Color.BLACK);
        gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
        gr.fillRect(0,0,width,height);
        gr.setComposite(oldComposite);

        gr.setColor(new Color(200,200,200));
        gr.fill(area2);
        gr.setColor(new Color(230,230,230));
        gr.fill(area1);
        smCrnrRect = new smoothCornerRect(75,75,width-250, height-160,40);
        Area obodok = new Area(smCrnrRect.getSCR());
        obodok.subtract(new Area(new Ellipse2D.Double(width-225,height-135,100,100)));

        oldComposite = gr.getComposite();

        gr.setColor(Color.RED);
        gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
        gr.draw(obodok);
        Logo logo = new Logo(width-120,height-30,115,180,Color.RED);
        logo.draw(gr);
        gr.setComposite(oldComposite);

        gr.setColor(new Color(240,240,240));
        Area ell = new Area(new Ellipse2D.Double(width-100,height/2-90,90,90));
        Area rect = new Area(new Rectangle(width-85,height/2-45,60,350));
        Area ell2 = new Area(new Ellipse2D.Double(width-85,height/2-75,60,60));
        gr.fill(ell);
        gr.fill(rect);
        ell.subtract(rect);
        ell.subtract(ell2);
        gr.setColor(Color.BLACK);
        gr.draw(ell);
        rect.add(ell2);
        gr.draw(rect);

        gr.setColor(Color.red);
        gr.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, height/36));
        gr.drawString(string, width/4*3, height-5);
    }
}