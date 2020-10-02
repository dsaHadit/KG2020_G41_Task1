import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawPanel extends JPanel {
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;

        gr.setColor(Color.BLACK);
        gr.fillRect(0,0,1920,1024);

        int starCount = 150 + (int)(Math.random() * 60);

        Color color = new Color(255,255,255);

        for (int vbn = 0; vbn<starCount; vbn++){
            /*// Red&Blue stars. But white ones are better
            int stype = (int) (Math.random()*2);
            if (stype==1)
            {
                color = new Color(255, 150, 150);
            }
            else
            {
                color = new Color(150,150,255);
            }
            */
            Star star = new Star((int) (Math.random() * 1920),(int) (Math.random() * 1080),36+ (int) (Math.random() * 36),color);
            star.draw(gr);
        }

        int plSize = 300 + (int)(Math.random()*300);
        //int plSize = 400;
        int ringCount = 1 + (int)(Math.random()*3);
        //int ringCount = 4;
        int inclination = -90 + (int) (Math.random()*180);
        //int inclination = 32;
        int gplanetX =300 + (int) (Math.random()*1520);
        int gplanetY =200 + (int) (Math.random()*680);
        int r = 130 + (int) (Math.random()*60);
        int gg = 130 + (int) (Math.random()*60);
        int b = 130 + (int) (Math.random()*60);
        Color pcolor1 = new Color(r, gg, b);
        //Color pcolor1 = new Color(190,185,65);
        r -= (5+ (int) (Math.random() * 40));
        gg -= (5+ (int) (Math.random() * 40));
        b -= (5+ (int) (Math.random() * 40));
        Color pcolor2 = new Color(r, gg, b);
        //Color pcolor2 = new Color(150,145,60);
        r = 130 + (int) (Math.random()*60);
        gg = 130 + (int) (Math.random()*60);
        b = 130 + (int) (Math.random()*60);
        Color rcolor = new Color(r, gg, b);
        //Color rcolor = new Color(145,145,80);
        //Values in comments define something similar to Saturn

        RingedPlanet rplanet = new RingedPlanet(gplanetX,gplanetY,plSize,ringCount,inclination,pcolor1,pcolor2,rcolor);
        rplanet.draw(gr);
        r = 130 + (int) (Math.random()*60);
        gg = 130 + (int) (Math.random()*60);
        b = 130 + (int) (Math.random()*60);
        Color mcolor1 = new Color(r, gg, b);
        r -= (5+ (int) (Math.random() * 40));
        gg -= (5+ (int) (Math.random() * 40));
        b -= (5+ (int) (Math.random() * 40));
        Color mcolor2 = new Color(r, gg, b);
        gplanetX =300 + (int) (Math.random()*1520);
        gplanetY =200 + (int) (Math.random()*680);
        plSize = 200 + (int)(Math.random()*250);
        MoonPlanet mplanet = new MoonPlanet(gplanetX,gplanetY,plSize,mcolor1,mcolor2);
        mplanet.draw(gr);
    }
}
