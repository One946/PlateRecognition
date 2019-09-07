package con;
import java.sql.*;
import targ.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Query{  
    private String risultato;
    private Targhe targheObj = new Targhe();

    public String getRisultato(){
        return this.risultato;
    }
    public void setRisultato(String par){
        this.risultato = par;
    }

    public void initQ(String path) throws Exception{
            ArrayList<String> listaTarghe = new ArrayList<String>();
            String targaSelezionata;
            String p = path;                                                                                                         // http://193.45.228.92/mjpg/video.mjpg Video o immagine contenenti la targa
            int operazione;
            String old=null;                                                                                                                                                                    //vecchia targa in caso si voglia aggiornarne il valore
            //Selezione targa
            this.targheObj.getTarghe(p);
            listaTarghe=targheObj.getTargheList();
            System.out.println(listaTarghe);
            this.targheObj.getNumb();
            targaSelezionata = this.targheObj.getTargaCustom();
            //Selezione operazione
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Seleziona l'operazione da effettuare");
            System.out.println("Digita 1 per cercare la targa");
            System.out.println("Digita 2 per inserire la targa");
            System.out.println("Digita 3 per aggiornare la targa");
            System.out.println("Digita 4 per eliminare la targa");
            operazione = keyboard.nextInt();
            this.op(operazione,targaSelezionata);
            if(operazione == 1 ||operazione == 2 ||operazione == 4 ){
                if(this.getRisultato()!= null){
                System.out.println("Operazione effettuata sulla targa: "+this.getRisultato());
                }
            }else if(operazione == 3){
                Scanner kb = new Scanner(System.in);
                System.out.println("hai selezionato l'opzione di aggiorna");
                System.out.println("inserisci la targa inserita precdentemente");
                old= kb.nextLine();
                this.op(operazione, old, targaSelezionata);
            }
    }

    public void cercaTarga(String param){  //op =1
        Statement stmt = null;
        String query = "SELECT * from Targhe where descrizione = '"+param+"'";
        try{
            System.out.println("SELECT * from Targhe where descrizione = '"+param+"'"); 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    String res = rs.getString(2);
                        this.setRisultato(res);
                }
            } else {
                System.out.println("Targa non trovata");
            }
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }
    public void insTarga(String param){  //op = 2
        Statement stmt = null;
        String query = "INSERT INTO Targhe (descrizione) VALUES ('"+param+"')";
        try{
            System.out.println("INSERT INTO Targhe (descrizione) VALUES ('"+param+"')"); 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Targa inserita correttamente!");
            this.setRisultato(param);
        }
        catch(Exception e){ System.out.println("Errore nell'inserimento della targa errore:"+e);}
    }
    public void upTarga(String old, String newOne){  //op = 3
        Statement stmt = null;
        String query = "UPDATE Targhe set descrizione = '"+newOne+"' where descrizione = '"+old+"'";
        try{
            System.out.println("UPDATE Targhe set descrizione = '"+newOne+"' where descrizione = '"+old+"'");
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Targa:''"+old+"'' aggiornata correttamente a: "+newOne+" !"); 
        }
        catch(Exception e){ System.out.println(e);}
    }
    public void delTarga(String param){ //op = 4
        Statement stmt = null;
        String query = "DELETE from Targhe WHERE descrizione = '"+param+"'";  
        try{
            System.out.println(query); 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Targa:'"+param+"' rimossa correttamente!");
            this.setRisultato(param);
        }
        catch(Exception e){ System.out.println("Erorre nella rimozione della targa:"+e);}
    }
    
    public void op(int num, String param){
        switch(num) {
            case 1:
              this.cercaTarga(param);
              break;
            case 2:
              this.insTarga(param);
              break;
            case 4:
              this.delTarga(param);
              break;
          }
    }
    public void op(int num, String old, String newOne){
        switch(num) {
            case 1:
              this.cercaTarga(newOne);
              break;
            case 2:
              this.insTarga(newOne);
              break;
            case 3:
              this.upTarga(old, newOne);
              break;
            case 4:
              this.delTarga(newOne);
              break;
          }
    }
}  