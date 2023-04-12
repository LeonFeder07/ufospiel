
import GLOOP.*;
public class Laser
{
    private GLQuader laserstrahl;
    Ufo angela;
    

    double a,b,c,d;
    public Laser(Ufo pufo){
        
        angela=pufo;
        laserstrahl = new GLQuader(angela.gibX(),angela.gibY(),angela.gibZ(),20,20,60);   
        laserstrahl.setzeSichtbarkeit(false);
        laserstrahl.setzeFarbe(1,0,0);
    }

    public void schiesen(){
        
        laserstrahl.setzeSichtbarkeit(true);
        laserstrahl.verschiebe(0,0,-3);

    }
    public void setzePosition(double a,double b,double c){
    laserstrahl.setzePosition(a,b,c);
    }
    
    public double gibX(){
        return laserstrahl.gibX(); 
    }public double gibY(){
        return laserstrahl.gibY(); 
    }
    public double gibZ(){
        return laserstrahl.gibZ(); 
    }
}