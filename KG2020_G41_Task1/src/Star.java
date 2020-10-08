import java.awt.*;

public class Star implements Drawable {
    private int x;
    private int y;
    private int size;
    private int rd;
    private int rayCount;
    private int rayLength;
    private Color color;

    Star(int x, int y, int size, int rd, int rayCount, int rayLength, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.rd = rd;
        this.rayCount = rayCount;
        this.rayLength = rayLength;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(color);

        gr.translate(x,y);
        gr.rotate(Math.toRadians(rd));

        int[] xCords = new int[rayCount*2];
        int[] yCords = new int[rayCount*2];
        double itrRad = 0;

        for (int i=0; i<rayCount*2; i++)
        {
            if (i%2==0) {
                xCords[i] = (int)(Math.cos(itrRad)*size/2);
                yCords[i] = (int)(Math.sin(itrRad)*size/2);
            }
            else {
                xCords[i] = (int)(Math.cos(itrRad)*size/2/(1+rayLength));
                yCords[i] = (int)(Math.sin(itrRad)*size/2/(1+rayLength));
            }
            itrRad += Math.PI/(rayCount);
        }

        gr.fillPolygon(xCords,yCords,rayCount*2);

        gr.rotate(Math.toRadians(-rd));
        gr.translate(-x,-y);

    }
}
