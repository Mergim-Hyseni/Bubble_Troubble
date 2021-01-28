package Bubble_Trouble;

import java.awt.*;

public class Box {
    private int box_high;  // the size of the box
    private int box_width;
    private Color c1=new Color(0x33CCFF);
    private Color c2=new Color(0x00FF99);


    public Box()
    { Toolkit tk = Toolkit.getDefaultToolkit();
        box_width = ((int) tk.getScreenSize().getWidth());
        box_high= ((int) tk.getScreenSize().getHeight())-150;

    }


    /** inHorizontalContact replies whether a position has contacted a
     *  horizontal wall.
     * @param x_position - the position examined
     * @return true, if  x_position  equals or exceeds the positions of the
     *   horizontal walls; return false, otherwise  */
    public boolean inHorizontalContact(int x_position,int radius)
    { return ((x_position -radius-3)<= 0 ) || ((x_position+radius+3 >= box_width)); }

    /** inVerticalContact replies whether a position has contacted a
     *  vertical wall.
     * @param y_position - the position examined
     * @return true, if  y_position  equals or exceeds the positions of the
     *   vertical walls; return false, otherwise  */
    public boolean inVerticalContact(int y_position,int radius)
    { return (y_position-radius-5 <= 0 ) || (y_position+radius+5 >= box_high); }

    /** sizeOf returns the size of the box */
    public int getBox_high()
    { return box_high; }

    public int getBox_width() {
        return box_width;
    }

    public void setColor(Color color1,Color color2)
    {   c1=color1;
        c2=color2;
    }

    public void paint(Graphics g)
    {
        int box_heigh=getBox_high();
        int box_width=getBox_width();
        Graphics2D g2=(Graphics2D)g;
        GradientPaint gradientPaint=new GradientPaint(0,0,c1,1200,800,c2,true);
        g2.setPaint(gradientPaint);
        g2.fillRect(0, 0, box_width,box_heigh);
         gradientPaint=new GradientPaint(0,0,new Color(0xB5B4B4),300,300,new Color(0x615E5E),true);
        g2.setPaint(gradientPaint);
        g2.fillRect(0, box_heigh, box_width,150);



    }
}