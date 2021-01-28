package Bubble_Trouble;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.GregorianCalendar;

public class Player  implements KeyListener {

    int jetet=2;
    int lartsia=70;
    int diametri=50;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int box_width = ((int) tk.getScreenSize().getWidth());
    private int x=box_width/2-27;
    int height=((int)tk.getScreenSize().getHeight())-220;
    private MovingBall []balls;
    private MovingBall []balls2;
    private Plumi plumi;
    private GregorianCalendar gregorian=new GregorianCalendar();
    private int sekondat;
    private int points;


     public Player(MovingBall [] b,Plumi plumi)
     {
         balls=b;
         balls2=b;
         this.plumi=plumi;
     }
     public int getJetet()
     {
         return jetet;
     }
     public void setJetet(int j)
     {
      jetet=j;
     }
     public void shtoJetet(int j)
     {
         jetet=jetet+j;
     }
     public void setPoints()
     {
         points=0;
     }
     public int getx()
     {
         return x;
     }
     public void setx()
     {
         x = box_width/2-27;
     }
     public int gety() { return height; }
     public int getDiametri(){return diametri;}
    public boolean ok()
    {   boolean result=true;

            for (int i = 0; i < balls.length; i++) {
                if (balls[i] != null) {
                    MovingBall ball = balls[i];
                    if (((ball.xPosition() + ball.radiusOf()) > x) && (x > ball.xPosition()) && ((ball.yPosition() + ball.radiusOf() - ball.getDiferenca()) > height)) {
                        x = box_width/2-27;
                        result = false;
                        if (jetet > 0) {
                            jetet--;
                        }
                        break;
                    } else {
                        if (((ball.xPosition()) > x) && ((x + diametri) > ball.xPosition()) && ((ball.yPosition() + ball.radiusOf()) > height)) {
                            x = box_width/2-27;
                            result = false;
                            if (jetet > 0) {
                                jetet--;
//
                            }
                            break;
                        } else {
                            if ((x < ball.xPosition()) && ((x + diametri) > (ball.xPosition()) - ball.radiusOf()) && ((ball.yPosition() + ball.radiusOf() - ball.getDiferenca()) > height)) {
                                x = box_width/2-27;
                                result = false;
                                if (jetet > 0) {
                                    jetet--;
                                }
                                break;
                            }
                        }
                    }
                }

        }
        return (result && jetet>0);
    }
    public boolean isFocusTraversable() {
        return true;
    }
    public void setPlayerx()
    {
        x=box_width/2-27;
    }
    public int getPoints()
    {
        return points;
    }

    public void keyTyped(KeyEvent keyEvent) {

        }
    public void keyPressed(KeyEvent keyEvent) {

        if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            if (x > 0) {
                x = x - 10;
            }
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_D) {
            if (x < box_width - 50) {
                x = x + 10;
            }
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_W) {
            plumi = new Plumi();

            plumi.setShfaqeplumin(true);
            sekondat = (new GregorianCalendar().get(gregorian.SECOND))%59;

            for (int i = 0; i < balls.length; i++) {
                if (balls[i] != null) {
                    MovingBall ball = balls[i];

                    if ((ball.xPosition()-ball.radiusOf())<((getx() + getDiametri() / 2 - 2)) && (ball.xPosition()+ball.radiusOf())>(x+4))
                    {   points=points+ball.radiusOf();
                        if (ball.radiusOf()==25)
                    {balls[i]=null;}
                    else {ball.setRadius(25);}
                    }
                }

            }
        }
    }


    public void keyReleased(KeyEvent keyEvent) {

    }

    public void paint(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        GradientPaint gradientPaint2=new GradientPaint(0,0,new Color(0x0066FF),20,20,new Color(0xFFFFFF),true);
        g2.setPaint(gradientPaint2);
        g.setColor(new Color(0x0022FF));
        g.fillRect(x,height,diametri,lartsia);
        if ((sekondat)<(new GregorianCalendar().get(gregorian.SECOND)))
        {
            plumi=null;
        }
        if (plumi!=null) {
            if (plumi.getShfaqeplumin()) {
                g.setColor(Color.white);
                g.fillRect(getx() + getDiametri() / 2 - 2, 25, 4, gety()-50);
            }
        }
    }


}
