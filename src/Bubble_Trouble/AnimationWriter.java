package Bubble_Trouble;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/** AnimationWriter displays a box with a ball in it.  */
public class AnimationWriter extends JPanel implements ActionListener {
    private Box box;    // the output-view of the box
    private MovingBall[] balls;
    private JFrame my_frame;
    int r = 70;
    private Player p;
    private Pengesa pengesa;
    private Plumi plumi;
   private int leveli=0;
   private Kuizi kuizi;
   private ButoniPerKuiz butoniPerKuiz;



    public AnimationWriter(Box b, MovingBall[] balls, Pengesa pengesa) {

        plumi=new Plumi();
        p=new Player(balls,plumi);
        kuizi=new Kuizi(p);
        box = b;
        this.pengesa=pengesa;
        this.balls = balls;
        ExitButton e=new ExitButton("Exit");
        JButton restartbutoni=new JButton("Restart");
        restartbutoni.setFocusable(false);
                restartbutoni.setBounds(b.getBox_width()/2+200,b.getBox_high()+10,80,40);
        setLayout(null);
        e.setBounds(b.getBox_width()/2-250,b.getBox_high()+10,80,40);
        add(e);
        add(restartbutoni);
        restartbutoni.addActionListener(this);
        butoniPerKuiz=new ButoniPerKuiz("Kuizi",kuizi);
        butoniPerKuiz.setBounds(b.getBox_width()/2+100,b.getBox_high()+10,80,40);
        butoniPerKuiz.setFocusable(false);
        add(butoniPerKuiz);
        my_frame = new JFrame();
        Container container=my_frame.getContentPane();
        container.add(this);
        my_frame.setTitle("Bounce");
        my_frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        my_frame.setVisible(true);
        my_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        my_frame.addKeyListener(p);
        my_frame.setFocusable(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        leveli=0;
        p.setJetet(2);
        p.setPoints();
        p.setx();
        kuizi=new Kuizi(p);
        butoniPerKuiz.setKuizi(kuizi);
    }

    public void paintComponent(Graphics g) {
        box.paint(g);
        Graphics2D g2=(Graphics2D)g;
        BasicStroke s=new BasicStroke(3);
        Font font = new Font("Serif",Font.BOLD,35);
        g2.setFont(font);
        if (leveli==0)
        {
             leveli++;
             balls[0] = new MovingBall(950, 100, 75,Color.blue, box,pengesa);
             balls[1] = new MovingBall(450,250, 50,Color.green, box,pengesa);
             balls[2] = new MovingBall(350,400, 75,Color.red, box,pengesa);
             balls[3] = new MovingBall(1000,400, 50,Color.yellow, box,pengesa);
             balls[4]=null;
             balls[5]=null;
             balls[6]=null;
             box.setColor(new Color(0x33CCFF),new Color(0x00FF99));

        }
        boolean ok=false;
        if (balls!=null) {
            for (int i = 0; i < balls.length; i++) {
                if (balls[i] != null) {
                    balls[i].paint(g);
                    ok = true;
                }
            }
        }
        if(!ok && leveli==1 && p.getJetet()>0) {
            if(leveli==1)
            leveli++;  //52E69C
            p.setPlayerx();
            box.setColor(new Color(0x07FAB9),new Color(0x1BCB67));
            balls[0] = new MovingBall(950, 100, 75, Color.blue, box, pengesa);
            balls[1] = new MovingBall(450, 250, 50, Color.green, box, pengesa);
            balls[2] = new MovingBall(350, 400, 75, Color.red, box, pengesa);
            balls[3] = new MovingBall(1000, 400, 50, Color.yellow, box, pengesa);
            balls[4] = new MovingBall(125, 400, 25, new Color(0xF73E19), box, pengesa);
            /*balls[5] = new MovingBall(790, 200, 25, new Color(0xFF3399), box, pengesa);
            balls[6] = new MovingBall(230, 300, 125, new Color(0x16C087), box, pengesa);*/
        }
        ok=false;
        if (balls!=null) {
            for (int i = 0; i < balls.length; i++) {
                if (balls[i] != null) {
                    balls[i].paint(g);
                    ok = true;
                }
            }
        }
        if(!ok && leveli==2 && p.getJetet()>0) {
            leveli++;
            p.setPlayerx();
            box.setColor(new Color(0x9C12A6),new Color(0xD483DA));
            balls[0] = new MovingBall(1000, 100, 75, Color.blue, box, pengesa);
            balls[1] = new MovingBall(150, 250, 50, Color.green, box, pengesa);
            balls[2] = new MovingBall(350, 400, 75, Color.red, box, pengesa);
            balls[3] = new MovingBall(1000, 400, 50, Color.yellow, box, pengesa);
            balls[4] = new MovingBall(125, 400, 25, new Color(0xF73E19), box, pengesa);
            balls[5] = new MovingBall(300, 300, 25, new Color(0xFF3399), box, pengesa);
            balls[6] = new MovingBall(230, 300, 125, new Color(0x16C087), box, pengesa);
        }

        if (ok && p.getJetet()>0) {
            pengesa.paint(g);
        }
        else {
            font = new Font("Serif",Font.BOLD,100);
            g2.setFont(font);
             GradientPaint gradientPaint2=new GradientPaint(0,0,new Color(0xFF3399),20,20,new Color(0xFFFFFF),true);
               g2.setPaint(gradientPaint2);
               String string= "Win !!!";
               if (p.getJetet()==0)
               {
                   string="Lost !!!";
                   for (int i=0;i<7;i++)
                   {
                       balls[i]=null;
                   }
               }
            g2.drawString(string,box.getBox_width()/2-150,box.getBox_high()/2-50);

        }
        font = new Font("Serif",Font.BOLD,35);
        g2.setFont(font);
        boolean rez=p.ok();
        if (rez)
        p.paint(g);
        GradientPaint gradientPaint=new GradientPaint(100,box.getBox_high()+20+20,new Color(0x33CCFF),200,box.getBox_high()+60,new Color(0x99CCFF),true);
        g2.setPaint(gradientPaint);
        g2.setColor(Color.white);
        g2.drawString(" Points : "+p.getPoints(),box.getBox_width()-300,box.getBox_high()+40);
        g2.drawString(" Level : "+leveli,box.getBox_width()/2-100,box.getBox_high()+40);
        g.setColor(new Color(0x0022FF));
        for (int i=0;i<p.jetet;i++)
        {
            g.fillRect(150+i*35,box.getBox_high()+20,30,30);
        }

    }

}