
import GLOOP.*;
public class Komet
{
    private GLKugel  komet,schrott,schrott1,schrott3,schrott2,schrott4;
   

    int trefferPunkte = 0;
    Ufo angela;
    Laser laserstrahl;
    Scanner scanner;
    int zeit,schwierig;
    public Komet(Ufo pUfo, Laser plaser, Scanner pscanner,int pschwierig){
        
        angela=pUfo;
        laserstrahl=plaser;
        scanner = pscanner;
        schwierig=pschwierig;

        komet = new GLKugel((Math.random()*-3000+1500),(Math.random()*-3000+1500),(Math.random()*-3000-1000),50);
        komet.setzeSkalierung (1,Math.random()+0.5,Math.random()+0.5);
        komet. setzeTextur ("src/img/Krater.jpg");

        
        zeit=0;
    }

    public void falle(){
        trefferPunkte = 0;
        if(komet.gibZ()<=850){
            komet.verschiebe(0,0,(Math.random()*10+schwierig));
            komet.drehe(Math.random(),Math.random(),Math.random());

        }else{
            komet.setzeSkalierung (1,Math.random()+0.5,Math.random()+0.5);
            komet.setzePosition((Math.random()*-3000+1500),(Math.random()*-3000+1500),(Math.random()*-3000-1000));
        }
        if(this.istGetroffen()){
            komet.setzeSichtbarkeit(false);
            laserstrahl.setzeSichtbarkeit(false);
            scanner .setzeSichtbarkeit(false);
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


    public boolean istGetroffen(){
        double a1=(komet.gibX() -angela.gibX()); 
        double b1=(komet.gibY() -angela.gibY());
        double c1=(komet.gibZ() -angela.gibZ());
        double d=Math.sqrt(a1*a1+b1*b1+c1*c1);
        if(d<=65){
            return true;
        }else{return false;}

    }
    public boolean istGetroffen2(){
        double a=(komet.gibX() -laserstrahl.gibX()); 
        double b=(komet.gibY() -laserstrahl.gibY());
        double c=(komet.gibZ() -laserstrahl.gibZ());
        double d=Math.sqrt(a*a+b*b+c*c);
        if(d<=60){
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
