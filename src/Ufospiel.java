import GLOOP.*; 
public class Ufospiel{
    private GLEntwicklerkamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel tafel,tafel2,willkommmenstafel,willkommmenstafel1,willkommmenstafel2,willkommmenstafel3;
    private Ufo ufo;
    private Komet[]kometenhagel;
    private Laser laserstrahl;
    private Schrott [] schrotthagel;
    private Scanner scanner;
    int lz;
    int punkte = 0;
    int schwierig=0;


    public Ufospiel(){
        kamera = new GLEntwicklerkamera(800,600);  

        //kamera.rotiere(10,0,1,0,300,1000,1100);
        licht  = new GLLicht();
        tastatur = new GLTastatur();
        tafel = new GLTafel (-650,550,-700,600,580);
        tafel.setzeAutodrehung(true);
        tafel.setzeTextur("src/img/img_1.png");
        tafel.setzeTextfarbe(1,1,1);
        tafel2 = new GLTafel (0,550,-700,600,580);
        tafel2.setzeAutodrehung(true);
        tafel2.setzeTextur("src/img/img_1.png");
        tafel2.setzeTextfarbe(1,1,1);
        willkommmenstafel = new GLTafel (0,200,-1000,80,600);
        willkommmenstafel.setzeTextur("src/img/img_1.png");
        willkommmenstafel.setzeTextfarbe(1,1,1);
        willkommmenstafel.setzeAutodrehung(true);

        willkommmenstafel1 = new GLTafel (0,100,-1000,80,600);
        willkommmenstafel1.setzeTextur("src/img/img_1.png");
        willkommmenstafel1.setzeTextfarbe(1,1,1);
        willkommmenstafel1.setzeAutodrehung(true);

        willkommmenstafel2 = new GLTafel (0,0,-1000,80,600);
        willkommmenstafel2.setzeTextur("src/img/img_1.png");
        willkommmenstafel2.setzeTextfarbe(1,1,1);
        willkommmenstafel2.setzeAutodrehung(true);

        willkommmenstafel3 = new GLTafel (0,-100,-1000,80,600);
        willkommmenstafel3.setzeTextur("src/img/img_1.png");
        willkommmenstafel3.setzeTextfarbe(1,1,1);
        willkommmenstafel3.setzeAutodrehung(true);
        himmel = new GLHimmel("src/img/Sterne.jpg");
        ufo = new Ufo();
        kamera.setzePosition(ufo.gibX(),(ufo.gibY()+100),ufo.gibZ()+600);
        kometenhagel = new Komet [100];
        schrotthagel = new Schrott[30];
        lz=0;
        laserstrahl = new Laser();
        scanner = new Scanner(ufo,schrotthagel);
        


        run();                                         

    }
    public void run(){
        while(!tastatur.tab()) {
            ufo.setzeSichtbarkeit(false);

            if(schwierig==0) {
                tafel2.setzeText("Wähle Schwierigkeit", 106);
            }
            willkommmenstafel.setzeText("Willkommen zu meinem Spiel!!!", 86);
            willkommmenstafel1.setzeText("Schrott einsaugen mit Scanner + 1 Punkt (Enter)", 76);
            willkommmenstafel2.setzeText("Komet zerstören mit Laser + 1 Punkt (Shift)", 76);
            willkommmenstafel3.setzeText("Schrott zerstören mit Laser - 1 Punkt (Shift)", 76);
        if(tastatur.unten()){
            schwierig=8;
        }
        if(tastatur.enter()){
                schwierig=1;
            }
            if(tastatur.oben()){
                schwierig=5;
            }
            if(schwierig==5) {
                tafel2.setzeText("Schwierigkeitsgrad Mittel", 106);
            }
            if(schwierig==1) {
                tafel2.setzeText("Schwierigkeitsgrad Leicht", 106);
            }
            if(schwierig==8) {
                tafel2.setzeText("Schwierigkeitsgrad Schwer", 106);
            }
        }

        for (int i=0; i<kometenhagel.length; i++){
            kometenhagel[i] = new Komet(ufo,laserstrahl, scanner,schwierig);

        }
        for (int i=0; i<schrotthagel.length; i++){
            schrotthagel[i] = new Schrott(ufo,scanner, laserstrahl,schwierig);

        }
        Sys.warte(500);
        willkommmenstafel.setzeSichtbarkeit(false);
        willkommmenstafel1.setzeSichtbarkeit(false);
        willkommmenstafel2.setzeSichtbarkeit(false);
        willkommmenstafel3.setzeSichtbarkeit(false);
        tafel2.setzeSichtbarkeit(false);
        ufo.setzeSichtbarkeit(true);

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


           
            
            if(ufo.gibX()>-700&& tastatur.links()){
                ufo.bewegeLinks();
                kamera.verschiebe(-1,0,0);
                tafel.verschiebe(-1,0,0);
            }
            if(ufo.gibY()<650&& tastatur.oben()){
                ufo.bewegeOben();
                kamera.verschiebe(0,1,0);
                tafel.verschiebe(0,1,0);
            }
            if(ufo.gibY()>-250&& tastatur.unten()){
                ufo.bewegeUnten();
                kamera.verschiebe(0,-1,0);
                tafel.verschiebe(0,-1,0);
            }
            if(ufo.gibX()<700 &&tastatur.rechts()) {
                ufo.bewegeRechts();
                kamera.verschiebe(1,0,0);
                tafel.verschiebe(1,0,0);
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
