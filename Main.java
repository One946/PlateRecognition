import con.*;
class Main{
    public static void main(String[] args) { 
        try{
            Query q = new Query();
            q.initQ("/home/one/Desktop/test/imgs/su.jpg");
        }
        catch(Exception e){ System.out.println(e);}
    }
}    
