package Bubble_Trouble;

import java.awt.*;

public class Pengesa {

     private int x,y,d,l;


    public Pengesa(int x0,int y0,int gjersia,int lartsia)
    {
        x=x0;
        y=y0;
        d=gjersia;
        l=lartsia;
    }
    public boolean kontrollox(int x_position,int y_position,int rrezja)
    {
        boolean result=false;
          if (((x_position+rrezja)>x && x_position<x && (y_position-3*rrezja)<(y+l))||(x<x_position) && (x+d)>(x_position-rrezja) && (y_position-3*rrezja)<(y+l))
          {
              result=true;
          }
          return result;
    }
    public boolean kontrolloy(int x_position,int y_position,int rrezja)
    {
        boolean  result=false;
        if (y_position>(y+l) && (y_position-rrezja)<(y+l) && (x_position>x) && (x_position)<(x+d))
        {
            result=true;
        }
        return result;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(x,y,d,l);
        Graphics2D g2=(Graphics2D)g;
        BasicStroke s=new BasicStroke(5);
        g2.setStroke(s);
        g2.setColor(new Color(0x404040));
        g2.drawRect(x,y,d,l);
    }
}
