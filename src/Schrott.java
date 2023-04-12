
import GLOOP.*;
public class Schrott
{
    private GLKugel  komet;
   
    double x,y,a,b,c,a1,b1,c1;
    Ufo angela;
    Scanner scanner;
    int trefferPunkte = 0;
    Laser laser;
    int zeit;
    public Schrott(Ufo pUfo,Scanner pscanner,Laser plaser){
        
        angela=pUfo;
        scanner=pscanner;
        laser = plaser;
        komet = new GLKugel((Math.random()*-3000+1500),(Math.random()*-3000+1500),-1500,50);
        komet.setzeSkalierung (1,Math.random()+0.5,Math.random()+0.5);
        komet. setzeTextur ("src/img/schrott.jpg");
        
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
            this.explodiere();
            angela.explodiere();

        }
        if(this.istGetroffen2()){
            this.explodiere();
            System.out.println("WASDWASD");
            trefferPunkte = 1;
        }
        if(this.istGetroffen3()){
            this.explodiere();
            trefferPunkte=-1;
        }
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
        double a=(komet.gibX() -scanner.gibX());
        double b=(komet.gibY() -scanner.gibY());
        double c=(komet.gibZ() -scanner.gibZ());
        double d=Math.sqrt(a*a+b*b+c*c);
        if(d<=50){
            return true;
        }
        else{return false;}
        }
    public boolean istGetroffen3(){
        double a=(komet.gibX() -laser.gibX());
        double b=(komet.gibY() -laser.gibY());
        double c=(komet.gibZ() -laser.gibZ());
        double d=Math.sqrt(a*a+b*b+c*c);
        if(d<=50){return true;
        }
        else{return false;}
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
