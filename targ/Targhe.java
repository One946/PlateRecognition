package targ;
import com.openalpr.jni.*;
import com.openalpr.jni.json.*;

import javafx.beans.property.SetProperty;

import java.util.ArrayList;
import java.util.Scanner;

public class Targhe{
    private ArrayList<String> targheList = new ArrayList<String>();
    private int posizione;
    private String targaCustom;

    public void setTargaCustom(String param){
        this.targaCustom= param;
    }

    public String getTargaCustom(){
        return this.targaCustom;
    }

    public void setPosizione(int val){
        this.posizione=val-1;
    }

    public int getPosizione(){
        return this.posizione;
    }

    public ArrayList<String> getTargheList(){
        return targheList;
    }

    public void getNumb(){
        int x= -1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("inserisci il numero corrispondente alla targa corretta 1 per la prima 9 per l'ultima");
        System.out.println("se nessuna delle targhe è corretta inserisci 11 per inserirla manualmente");
        x = keyboard.nextInt();
        if(x==-1){
            System.out.println("La scelta selezionata non è valida");
        } else if(x>1 && x<10){
            this.setPosizione(x);
        }
        else if(x==11){
            System.out.println("Inserisci di seguito la tua targa manualmente");
            Scanner kb= new Scanner(System.in);
            String y = kb.nextLine();
            System.out.println(y);
            this.setTargaCustom(y);
        }
    }

    public void getTarghe(String path) throws Exception{
        Alpr alpr = new Alpr("eu", "/etc/openalpr/openalpr.conf", "/home/one/Desktop/openalpr-2.3.0/runtime_data");
        alpr.setTopN(10); // mi faccio restituire i primi 10 risultati
        try { 
            AlprResults results = alpr.recognize(path);
            for (AlprPlateResult result : results.getPlates()){   
                for (AlprPlate plate : result.getTopNPlates()) {
                    targheList.add(plate.getCharacters());
                }
            }
        } catch( Exception e ) { 
            System.out.println("Errore in Targhe.java: "+e);
        }
    }

}
