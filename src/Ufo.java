import GLOOP.*;
public class Ufo{
   private GLLicht licht;
    private GLEntwicklerkamera kamera;
    private GLTorus rumpf; 
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;
    private GLQuader untertasse;
    public  GLTastatur tastatur;
    Komet scholz;
    public Ufo(){
        //kamera = new GLEntwicklerkamera(800,600);  
        //kamera.verschiebe(0,200,500);
         //licht  = new GLLicht();
        cockpit = new GLKugel(0,0,100,40);
        cockpit.setzeFarbe(0,1,0);
        rumpf   = new GLTorus (0,0,100,40,10);
        rumpf.drehe(90,0,0);
        rumpf.setzeFarbe(1,0,0);
        fluegel1 = new GLKegel(-50,0,100,15,60);
        fluegel2 = new GLKegel (50,0,100,15,60);
         fluegel1.drehe(0,90,0);
        fluegel2.drehe(0,-90,0);
        
        fluegel1.setzeFarbe(1,1,0);
        fluegel2.setzeFarbe(1,1,0);
    }
 
    public void bewegeLinks(){
                cockpit.verschiebe(-2,0,0);
                rumpf.verschiebe(-2,0,0);
                fluegel1.verschiebe(-2,0,0);
                fluegel2.verschiebe(-2,0,0);
                
   }

    public void bewegeRechts(){       
                cockpit.verschiebe(2,0,0);
                rumpf.verschiebe(2,0,0);
                fluegel1.verschiebe(2,0,0);
                fluegel2.verschiebe(2,0,0);
    } 
    public void bewegeOben(){       
                cockpit.verschiebe(0,2,0);
                rumpf.verschiebe(0,2,0);
                fluegel1.verschiebe(0,2,0);
                fluegel2.verschiebe(0,2,0);
    } 
    public void bewegeUnten(){       
                cockpit.verschiebe(0,-2,0);
                rumpf.verschiebe(0,-2,0);
                fluegel1.verschiebe(0,-2,0);
                fluegel2.verschiebe(0,-2,0);
    } 

    public void explodiere(){
        double z = Math.random()*5;
        
        for(int i=0; i< 2000; i++) {
           rumpf.verschiebe((-z*Math.random()),z,z); 
           rumpf.drehe(-z,z,z); 
           cockpit.verschiebe(z,(z*Math.random()),z); 
           cockpit.drehe(z,z,z); 
           fluegel1.verschiebe(-z,z,(z*Math.random()));
           fluegel1.drehe(z,z,z); 
           fluegel2.verschiebe(-z,(z*Math.random()),z); 
           fluegel2.drehe(z,z,z); 
           Sys.warte();
        }
    }
    public double gibX(){
     return cockpit.gibX(); 
    }
    public double gibY(){
     return cockpit.gibY(); 
    }
    public double gibZ(){
     return cockpit.gibZ(); 
    }
}
