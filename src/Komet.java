
import GLOOP.*;
public class Komet
{
    private GLKugel  komet,schrott,schrott1,schrott3,schrott2,schrott4;
   
    double x,y,a,b,c,a1,b1,c1,punkte;
    int trefferPunkte = 0;
    Ufo angela;
    Laser laserstrahl;
    int zeit;
    public Komet(Ufo pUfo, Laser plaser){
        
        angela=pUfo;
        laserstrahl=plaser;
        //laserstrahl = new Laser(pUfo);
        komet = new GLKugel((Math.random()*-3000+1500),(Math.random()*-3000+1500),-1500,50);
        komet.setzeSkalierung (1,Math.random()+0.5,Math.random()+0.5);
        komet. setzeTextur ("src/img/Krater.jpg");
        double punkte = 0;
        
        zeit=0;
    }

    public void falle(){
        trefferPunkte = 0;
        if(komet.gibZ()<=850){
            komet.verschiebe(0,0,(Math.random()*10));  
            komet.drehe(Math.random(),Math.random(),Math.random());

        }else{
            komet.setzeSkalierung (1,Math.random()+0.5,Math.random()+0.5);
            komet.setzePosition((Math.random()*-3000+1500),(Math.random()*-3000+1500),(Math.random()*-3000-1000));
        }
        if(this.istGetroffen()){
            komet.setzeSichtbarkeit(false);
            komet.setzePosition((Math.random()*-3000+1500),(Math.random()*-3000+1500),-1500);
            angela.explodiere();
         komet.setzeSichtbarkeit(true);
        }
        if(this.istGetroffen2()){
        trefferPunkte=trefferPunkte +1;
        komet.setzeSichtbarkeit(false);
        komet.setzePosition((Math.random()*-3000+1500),(Math.random()*-3000+1500),-1500);
        komet.setzeSichtbarkeit(true);
            laserstrahl.setzePosition(20000,3212154,23131321);
        }
    }
  public double gibPunkte(){
     return punkte; 
    }
    public void zaehle(){

        for(int i=0; i<=400;i++){
            zeit=zeit+1;

            System.out.println(zeit);
            Sys.warte(1000);
        }
    }

    public boolean istGetroffen(){
        double a1=(komet.gibX() -angela.gibX()); 
        double b1=(komet.gibY() -angela.gibY());
        double c1=(komet.gibZ() -angela.gibZ());
        double d=Math.sqrt(a1*a1+b1*b1+c1*c1);
        if(d<=50){
            return true;
        }else{return false;}

    }
    public boolean istGetroffen2(){
        double a=(komet.gibX() -laserstrahl.gibX()); 
        double b=(komet.gibY() -laserstrahl.gibY());
        double c=(komet.gibZ() -laserstrahl.gibZ());
        double d=Math.sqrt(a*a+b*b+c*c);
        if(d<=80){
            return true;
        }else{return false;}

    }
    public void explodiere(){
        komet.setzePosition((Math.random()*-3000+1500),(Math.random()*-3000+1500),-1500);
    }
    public double gibX(){
        return komet.gibX(); 
    }

    public double gibY(){
        return komet.gibY(); 
    }
    public void setzeSichtbarkeit(boolean ps){
    komet.setzeSichtbarkeit(false);
    }
    public double gibZ(){
        return komet.gibZ(); 
    }
    public int gibTrefferpunkte(){
        return trefferPunkte;
    }
    
}
