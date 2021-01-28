package Bubble_Trouble;


public class BounceController  implements Runnable
{ private MovingBall[]ball;  // model object
    private AnimationWriter writer; // output-view object

    /** Constructor BounceController initializes the controller
     * @param b - the model object
     * @param w - the output-view object  */
    public BounceController(MovingBall []b, AnimationWriter w)
    { ball = b;
        writer = w;

    }


    public void run()
    { double time_unit = 1;    // time unit for each step of the animation
        int painting_delay =10;  // how long to delay between repaintings
        while ( true )
        { delay(painting_delay);
          /*  ball.move(time_unit);
//            System.out.println(ball.xPosition() + ", " + ball.yPosition());
            writer.repaint();  // redisplay box and ball
            ball2.move(time_unit);
            writer.repaint();*/
            for (int i=0;i<ball.length; i++)
            {
                if (ball[i]!=null)
                {
                    ball[i].move(time_unit);
                    writer.repaint();
                }
            }
            writer.repaint();

        }
    }
    private void delay(int how_long)
    { try { Thread.sleep(how_long); }
    catch (InterruptedException e) { }
    }
}
