
import GLOOP.*;
public class Scanner{

    private GLTorus ring1,ring2,ring3; 

    double a,b,c,d;
    Ufo angela;
    Schrott[]schrott;
    double punkte1;
    public Scanner(Ufo pufo,Schrott[] pschrott){

         angela = pufo;
         schrott = pschrott;
         double punkte1 = 0;
        ring1  = new GLTorus (200000,50000,0,10,5);
        ring1.setzeFarbe(0,1,0);
         ring2  = new GLTorus (200000,50000,0,30,5);
        ring2.setzeFarbe(0,1,0);
         ring3  = new GLTorus (200000,50000,0,50,5);
        ring3.setzeFarbe(0,1,0);
         
        
    }
 

    public void setzePosition(double x,double y,double z){       
                ring1.setzePosition(x,y,z-60);
            
                ring2.setzePosition(x,y,z-80);
            
                ring3.setzePosition(x,y,z-100);
    }

    
    
    public void setzeSichtbarkeit(boolean eingabe){   
    ring1.setzeSichtbarkeit(eingabe);
    ring2.setzeSichtbarkeit(eingabe);
    ring3.setzeSichtbarkeit(eingabe);
    }
    public double gibX(){
     return ring3.gibX(); 
    }
    public double gibY(){
     return ring3.gibY(); 
    }
    public double gibZ(){
     return ring3.gibZ(); 
    }
}
