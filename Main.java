import targ.*;
import com.openalpr.jni.*;
import com.openalpr.jni.json.*;

import con.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws Exception { 
            //Inzializo l'oggetto targhe e la lista che conterrà il risultato dell'algoritmo per l'individuazione della targa
            Targhe targheObj = new Targhe();
            ArrayList<String> listaTarghe = new ArrayList<String>();
            String targaSelezionata;
            String p = "/home/one/Desktop/test/imgs/lp.jpg";//"/home/one/Desktop/Test/plate.jpeg"; http://193.45.228.92/mjpg/video.mjpg Video o immagine contenenti la targa
            
            targheObj.getTarghe(p);
            listaTarghe=targheObj.getTargheList();
            System.out.println(listaTarghe);
            targheObj.getNumb();
            targaSelezionata =listaTarghe.get(targheObj.getPosizione());
            Query f = new Query();
            //f.insTarga(targaSelezionata);
            f.cercaTarga(targaSelezionata);
            System.out.println(f.getRisultato());
    }
}    
