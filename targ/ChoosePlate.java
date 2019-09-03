package targ;
import com.openalpr.jni.*;
import com.openalpr.jni.json.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class ChoosePlate{

    public static int getNumb(){
        int x=-1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("inserisci il numero corrispondente alla targa corretta");
        x = keyboard.nextInt();
        return x;
    }
/*
    public static void main(String[] args) throws Exception { 
        Targhe x = new Targhe();
        ArrayList<String> y = new ArrayList<String>();
        String p = "/home/one/Desktop/test/targ/lp.jpg";
        x.getTarghe(p);
        y=x.getTargheList();
        System.out.println(y);
        String tProva=y.get(getNumb());
        System.out.println(tProva);
    }
*/

}