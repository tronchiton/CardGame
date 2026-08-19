package Entities;


import Main.Main;
import Entities.Utils.Point2D;
import Entities.Utils.Vector2D;
import java.util.Random;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static BoardGame.Fight.Dice.random;


public class Entity {
    Vector2D speed;
    Vector2D acceleration;
    Point2D position;
    public int sizex;
    public int sizey;
    Double angulara;
    Double anguralspeed;
    public Double angle;

    private double currentScale = 1.0;         // Escala actual
    private double targetScale = 1.0;          // Escala objetivo (1.0 en reposo, crece un poco con el mouse encima)
    private double scaleSpeed = 0.0;           // Velocidad de cambio de tamaño
    private double scaleAcceleration = 0.0;    // Aceleración del tamaño
    private static final double SCALE_K = 90.0;      // Fuerza de retorno del muelle de tamaño
    private static final double SCALE_DAMP = 14.0;   // Amortiguación de tamaño (suave, sin rebote)
    private static final double SCALE_IMPULSE = 0.4; // Pequeño temblor extra sobre el tamaño
    private static final double HOVER_SCALE = 1.08;  // Cuanto crece la carta al pasar el mouse por encima

    private static final double SPRING_K = 22.0;     // Fuerza de retorno del muelle de rotación
    private static final double DAMPING = 6.0;       // Amortiguación de rotación
    private static final double IMPULSE_FORCE = 8.0; // Intensidad del temblor de rotación (suave)

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
    public void setPosition(Point2D Point){
        this.position=Point;
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

        this.scaleSpeed+=scaleAcceleration*dt;
        this.currentScale+=scaleSpeed*dt;

    }

    /**
     * Temblor suave de la carta. Llamar cada frame con active=true mientras el mouse
     * esté encima (o false el resto del tiempo, para que vuelva a su posición/tamaño de reposo).
     */
    public void whoble(boolean active){
        // --- TEMBLOR DE ROTACIÓN ---
        double springForce = -SPRING_K * this.angle;
        double dampingForce = -DAMPING * this.anguralspeed;
        double randomImpulse = active ? (random.nextDouble() * 2.0 - 1.0) * IMPULSE_FORCE : 0.0;
        this.angulara = springForce + dampingForce + randomImpulse;

        // --- TEMBLOR DE TAMAÑO (DENTRO DEL WOBBLE) ---
        // El muelle lleva la escala a HOVER_SCALE si el mouse está encima, o a 1.0 (reposo) si no.
        this.targetScale = active ? HOVER_SCALE : 1.0;
        double scaleSpringForce = -SCALE_K * (this.currentScale - this.targetScale);
        double scaleDampingForce = -SCALE_DAMP * this.scaleSpeed;
        // Pequeño impacto aleatorio que hace vibrar el tamaño independientemente, solo con el mouse encima
        double scaleRandomImpulse = active ? (random.nextDouble() * 2.0 - 1.0) * SCALE_IMPULSE : 0.0;
        this.scaleAcceleration = scaleSpringForce + scaleDampingForce + scaleRandomImpulse;
    }

    public double getCurrentScale(){
        return this.currentScale;
    }



    public void render(Graphics2D g2D) {
        AffineTransform oldTransform = g2D.getTransform();

        g2D.setColor(Color.BLUE);
        Point2D newpos = Main.Camara.RespectoCamara(this);

        g2D.rotate(angle, newpos.getX(), newpos.getY());

        g2D.fillRect(
                (int) (newpos.getX() - sizex / 2.0),
                (int) (newpos.getY() - sizey / 2.0),
                sizex, sizey
        );

        g2D.setTransform(oldTransform);
    }

    public void act(){}

}