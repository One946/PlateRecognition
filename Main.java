import targ.*;
import con.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws Exception { 
            //Inzializo l'oggetto targhe e la lista che conterrà il risultato dell'algoritmo per l'individuazione della targa
            Targhe targheObj = new Targhe();
            ArrayList<String> listaTarghe = new ArrayList<String>();
            String targaSelezionata;
            String p = "/home/one/Desktop/test/imgs/lp.jpg";// http://193.45.228.92/mjpg/video.mjpg Video o immagine contenenti la targa
            int operazione;
            String old=null; //vecchia targa in caso si voglia aggiornarne il valore
            //Selezione targa
            targheObj.getTarghe(p);
            listaTarghe=targheObj.getTargheList();
            System.out.println(listaTarghe);
            targheObj.getNumb();
            targaSelezionata = targheObj.getTargaCustom();
   
            //Selezione operazione
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Seleziona l'operazione da effettuare");
            System.out.println("Digita 1 per cercare la targa");
            System.out.println("Digita 2 per inserire la targa");
            System.out.println("Digita 3 per aggiornare la targa");
            System.out.println("Digita 4 per eliminare la targa");
            operazione = keyboard.nextInt();
            Query q = new Query();
            if(operazione == 1 ||operazione == 2 ||operazione == 4 ){
            //q.op(operazione,targaSelezionata);
            //System.out.println(q.getRisultato());
            }else if(operazione == 3){
                Scanner kb = new Scanner(System.in);
                System.out.println("hai selezionato l'opzione di aggiorna");
                System.out.println("inserisci la targa inserita precdentemente");
                old= kb.nextLine();
                q.upTarga(old, targheObj.getTargaCustom());
            }
    }
}    
