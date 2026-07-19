package Entities;


import BoardGame.PlayerRelated.CurrentPlayerManager;
import Entities.Utils.Point2D;
import Entities.Utils.Vector2D;
import Main.Main;



public class Camera extends Entity {
    public Camera(double x, double y){
        super(x,y,0,0);
        this.speed=new Vector2D(0,0);
        this.acceleration=new Vector2D(0,0);
        Main.Entities.add(this);
    }


    public void follow(Point2D Target){

        Vector2D r= new Vector2D(this.position,Target);

            this.speed=r;}



    public Point2D RespectoCamara(Entity ser){

        double newx=(int)ser.position.getX()-this.position.getX()+1920/2;
        double newy=(int)ser.position.getY()-this.position.getY()+1080/2;
        return new Point2D(newx,newy);
    }

    public void act(){
        follow(CurrentPlayerManager.activePlayer.Position);
    }

}

