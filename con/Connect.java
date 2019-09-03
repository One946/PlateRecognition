package con;
import java.sql.*;

public class Connect{  
    public String risultatoQuery;

    public String getRisultato(){
        return risultato;
    }
    
    public void setRisultato(String par){
        this.risultato = par;
    }

    public void cercaTarga(String param){  
        try{
            System.out.println("select * from Targhe where descrizione = '"+param+"'"); 
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
    }

}  