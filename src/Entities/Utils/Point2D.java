package Entities.Utils;

public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Point2D( Point2D p, Vector2D v){
        this.x=p.getX()+v.getI();
        this.y=p.getY()+v.getJ();
    }

    public double distancia (Point2D destino,Point2D origen) {
        double dx = destino.x - origen.x;
        double dy = destino.y - origen.y;
        return Math.hypot(dx, dy);
    }
    @Override
    public String toString() {
        return "Point[" + x + ", " + y + "]";
    }

    public double getX() { return x; }
    public double getY() { return y; }

}
