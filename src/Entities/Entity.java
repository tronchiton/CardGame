package Entities;


import Main.Main;
import Entities.Utils.Point2D;
import Entities.Utils.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;


public class Entity {
    Vector2D speed;
    Vector2D acceleration;
    Point2D position;
    public int sizex;
    public int sizey;
    Double angulara;
    Double anguralspeed;
    public Double angle;


    public Entity(double x, double y, int sizex, int sizey) {
        this.position = new Point2D(x, y);
        this.speed = new Vector2D(0.0, 0.0);
        this.acceleration = new Vector2D(0.0, 0.0);
        this.sizex = sizex;
        this.sizey = sizey;
        this.angle = 0.0;
        this.anguralspeed = 0.0;
        this.angulara = 0.0;
    }


    public void setX(double x){
        this.position=new Point2D(x,this.position.getY());
    }
    public void setY(double y){
        this.position=new Point2D(this.position.getX(),y);
    }
    public void setsizeX(int x){
        this.sizex=x;
    }
    public void setsizeY(int y){
        this.sizey=y;
    }

    public double getX() {
        return this.position.getX();
    }

    public double getY() {
        return this.position.getY();
    }

    public void setPosition(double x, double y){
        this.position=new Point2D(x,y);
    }

    public void setSpeedX(double x){
        this.speed=new Vector2D(x,this.speed.getJ());
    }
    public void setSpeedY(double y){
        this.speed=new Vector2D(this.speed.getI(),y);
    }
    public void setSpeed(double x, double y){
        this.speed=new Vector2D(x,y);
    }
    public void setaccelerationX(double x){
        this.acceleration=new Vector2D(x,this.acceleration.getJ());
    }
    public void setaccelerationY(double y){
        this.acceleration=new Vector2D(this.acceleration.getI(),y);
    }
    public void setacceleration(double x, double y){
        this.acceleration=new Vector2D(x,y);
    }
    public void setAngularAcceleration(double angulara) {
        this.angulara = angulara;
    }
    public double getAngularSpeed() {
        return this.anguralspeed;
    }

    public void setAngularSpeed(double speed) {
        this.anguralspeed = speed;
    }

    public void mover(double dt){
        this.speed=Vector2D.Suma(this.speed,Vector2D.MultiplicarVector2DePorescalar(dt,this.acceleration));
        this.position= new Point2D(this.position,Vector2D.MultiplicarVector2DePorescalar(dt,this.speed));
        this.anguralspeed+=angulara*dt;
        this.angle+=anguralspeed*dt;


    }
    public void render(Graphics2D g2D) {
        AffineTransform oldTransform = g2D.getTransform();

        g2D.setColor(Color.BLUE);
        Point2D newpos = Main.Camara.RespectoCamara(this);

        double centroX = newpos.getX() + (sizex / 2.0);
        double centroY = newpos.getY() + (sizey / 2.0);

        g2D.rotate(angle, centroX, centroY);

        g2D.fillRect((int) newpos.getX(), (int) newpos.getY(), sizex, sizey);

        g2D.setTransform(oldTransform);
    }
}

