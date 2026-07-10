package Entities.Utils;

public class Vector2D {
    private final double i;
    private final double j;

    public Vector2D(double i, double j){
        this.i=i;
        this.j=j;
    }

    public Vector2D(Point2D start, Point2D end){
        this.i=end.getX()-start.getX();
        this.j=end.getY()-start.getY();
    }

    public static double ProductoEscalar(Vector2D A, Vector2D B){
        return A.i*B.i+A.j*B.j;
    }
    public static Vector2D Resta(Vector2D A, Vector2D B){
        return new Vector2D (A.i-B.i,A.j-B.j);
    }
    public static Vector2D Suma(Vector2D A, Vector2D B){
        return new Vector2D (A.i+B.i,A.j+B.j);
    }
    public static double ModuloVector2D(Vector2D A){
        return Math.hypot(A.i,A.j);
    }
    public static Vector2D MultiplicarVector2DePorescalar(double A, Vector2D B){
        return new Vector2D(A*B.i,A*B.j);
    }
    public static Vector2D DividirVector2DPorescalar (Vector2D A, double B){
        return new Vector2D(A.i/B,A.j/B);
    }

    public static Vector2D Unitario (Vector2D A){
       double modulo=ModuloVector2D(A);
        if (modulo == 0 ) return new Vector2D(0,0);
        return DividirVector2DPorescalar(A,modulo);
    }

    public static Vector2D Perpendicular (Vector2D A){
        if (ModuloVector2D(A) == 0 ) return new Vector2D(0,0);
        return new Vector2D(A.j,-A.i);
    }

    public static double AnguloVector2Des(Vector2D A, Vector2D B){
        double ma = ModuloVector2D(A);
        double mb = ModuloVector2D(B);
        double ratio = ProductoEscalar(A, B) / (ma * mb);
        ratio = Math.max(-1.0, Math.min(1.0, ratio));
        return Math.acos(ratio);
    }
    @Override
    public String toString() {
        return "Utils.Vector2D[" + i + ", " + j + "]";
    }
    
    public double getI() { return i; }
    public double getJ() { return j; }
}
