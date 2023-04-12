import GLOOP.*; 
public class Ufospiel{
    private GLEntwicklerkamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel tafel;
    private Ufo ufo;
    private Komet[]kometenhagel;
    private Laser laserstrahl;
    private Schrott [] schrotthagel;
    private Scanner scanner;
    int lz;
    int punkte = 0;

    public Ufospiel(){
        kamera = new GLEntwicklerkamera(800,600);  
        kamera.verschiebe(300,200,500);
        kamera.rotiere(10,0,1,0,300,1000,1100);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        tafel = new GLTafel (200,400,-500,600,580);
        tafel.setzeAutodrehung(true);
        tafel.setzeTextur("src/img/img_1.png");
        tafel.setzeTextfarbe(1,1,1);
        himmel = new GLHimmel("src/img/Sterne.jpg");
        ufo = new Ufo();
        kometenhagel = new Komet [100];
        schrotthagel = new Schrott[30];
        lz=0;
        laserstrahl = new Laser(ufo);
        scanner = new Scanner(ufo,schrotthagel);
        
        for (int i=0; i<kometenhagel.length; i++){
            kometenhagel[i] = new Komet(ufo,laserstrahl);
            
        } 
        for (int i=0; i<schrotthagel.length; i++){
            schrotthagel[i] = new Schrott(ufo,scanner, laserstrahl);
            
        } 
        run();                                         

    }
    public void run(){
        while(!tastatur.esc()){ 
            Sys.warte(10);
            scanner.setzeSichtbarkeit(false);
            if(tastatur.shift()){
                laserstrahl.setzePosition((ufo.gibX()+30),ufo.gibY(),ufo.gibZ());
                
                lz=1;

            }
            if(lz==1){
               if(laserstrahl.gibZ() >-4000) {
                    laserstrahl.schiesen();

                }
            }
            if(tastatur.enter()){
                scanner.setzePosition(ufo.gibX(),ufo.gibY(),ufo.gibZ());
                scanner.setzeSichtbarkeit(true);
            for (int i = 0; i < schrotthagel.length; i++){
                schrotthagel[i].istGetroffen2();
            }

            }


           
            
            if(ufo.gibX()>-600&& tastatur.links()){
                ufo.bewegeLinks();

            }
            if(ufo.gibY()<600&& tastatur.oben()){
                ufo.bewegeOben();

            }
            if(ufo.gibY()>-200&& tastatur.unten()){
                ufo.bewegeUnten();

            }
            if(ufo.gibX()<650 &&tastatur.rechts()) {
                ufo.bewegeRechts();

            }

            for(int i=0; i<schrotthagel.length; i++){
                schrotthagel [i].falle();
                punkte = punkte + schrotthagel[i].trefferPunkte;
            }
            for(int i=0; i<kometenhagel.length; i++){
                kometenhagel[i].falle();
                punkte = punkte + kometenhagel[i].trefferPunkte;
            }

            tafel.setzeText("Punkte:"+punkte, 106);
        }    
    }

}
