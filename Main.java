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

            String p = "/home/one/Desktop/test2/imgs/lp.jpg";//"/home/one/Desktop/Test/plate.jpeg"; http://193.45.228.92/mjpg/video.mjpg Video o immagine contenenti la targa
            targheObj.getTarghe(p);
            listaTarghe=targheObj.getTargheList();
            targheObj.getNumb();
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println(listaTarghe);

 /*
        Query f = new Query();
        f.delTarga("1234");
        f.upTarga("FFFFFFFFFFFFFFFFf", "pippo");
        f.insTarga("1234");
        f.cercaTarga("1234");
*/
    }
}    
