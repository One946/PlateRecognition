package con;
import java.sql.*;

public class Query{  
    private String risultato;

    public String getRisultato(){
        return risultato;
    }
    
    public void setRisultato(String par){
        this.risultato = par;
    }

    public String cercaTarga(String param){  
        try{
            System.out.println("SELECT * from Targhe where descrizione = '"+param+"'"); 
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://remotemysql.com:3306/CGdY7lHCsM","CGdY7lHCsM","73wAAF3djl");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Targhe where descrizione = '"+param+"'");
            while(rs.next()){
                setRisultato(rs.getString(2));
            }
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
        String risultato = getRisultato();
        return risultato;
    }

    public void insTarga(String param){  
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

    public void upTarga(String old, String newOne){  
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

    public void delTarga(String param){
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

}  