package Bubble_Trouble;


import java.awt.*;
/** BounceTheBall constructs and starts the objects in the animation.  */
public class BounceTheBall
{ public static void main(String[] args)
{ // construct the model objects:


    int balls_radius =50 ;
    Box box=new Box();
    Pengesa pengesa=new Pengesa(box.getBox_width()/2-37,0,75,520);

    MovingBall ball1 = new MovingBall(950, 100, 75,Color.blue, box,pengesa);
    MovingBall ball2 = new MovingBall(450,250, 50,Color.green, box,pengesa);
    MovingBall ball3 = new MovingBall(350,400, 75,Color.red, box,pengesa);
    MovingBall ball4 = new MovingBall(1000,400, 50,Color.yellow, box,pengesa);
  /*  MovingBall ball5 = new MovingBall(125,400, 25,new Color(0xF73E19), box,pengesa);
    MovingBall ball6 = new MovingBall(790,200, 50,new Color(0xFF3399), box,pengesa);
    MovingBall ball7 = new MovingBall(250,100, 30,new Color(0x3333FF), box,pengesa);
    MovingBall ball8 = new MovingBall(950,100, 30,new Color(0x66CC00), box,pengesa);*/
    MovingBall [] balls={ball1,ball2,ball3,ball4,null,null,null};

/*    BallWriter ball_writer1 = new BallWriter(ball1, Color.blue);
    BallWriter ball_writer2 = new BallWriter(ball2, Color.green);
    BallWriter ball_writer3 = new BallWriter(ball3, Color.yellow);*/

//    BallWriter []ball_writer={ball_writer1,ball_writer2,ball_writer3,ball_writer4,ball_writer5,ball_writer6};


    AnimationWriter writer = new AnimationWriter(box,balls,pengesa);
    // construct the controller and start it:
    new Thread(new BounceController(balls, writer)).start();


}
}