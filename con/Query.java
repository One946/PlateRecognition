package con;
import java.sql.*;

public class Query{  
    private String risultato;

    public String getRisultato(){
        return this.risultato;
    }
    
    public void setRisultato(String par){
        this.risultato = par;
    }

    public String cercaTarga(String param){  //op =1
        Statement stmt = null;
        String query = "SELECT * from Targhe where descrizione = '"+param+"'";
        try{
            System.out.println("SELECT * from Targhe where descrizione = '"+param+"'"); 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                setRisultato(rs.getString(2));
            }
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
        String risultato = getRisultato();
        return risultato;
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
            System.out.println("Targa:''"+old+"'' aggiornata correttamente a"+newOne+" !"); 
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