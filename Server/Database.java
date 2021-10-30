package Server;

import java.sql.Statement;
import java.time.Instant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Database {
	
	
	//Storing The Message Data to Database
	public static Boolean store(String m) {
		
		String arr[] = m.split("__");
		//connecting to DB file
        String jdc = "jdbc:sqlite:politeDB.sqlite3";
        Connection con;
        
		try {
			con = DriverManager.getConnection(jdc);
			//query to store
	        String q = "Insert into Message values ('"+arr[0].split(" : ")[1]+"','"+arr[1].split(" : ")[1]+"','"+arr[2].split(" : ")[1]+"','"+arr[3].split(" : ")[1]+"','"+arr[4].split(" : ")[1]+"','"+arr[5].split(" : ")[1]+"','"+arr[6].split(" : ")[1]+"')";
	        Statement stat = con.createStatement();
	        stat.execute(q);
	        con.close();
        
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Getting Get Request data and returning
	public static String getData(String data) {
		String arr[] = data.split("##");
		String ret = "";
		String jdc = "jdbc:sqlite:politeDB.sqlite3";
		if(arr[0].equals("To"))
			arr[0] = "Receiver";
		if(arr[0].equals("From"))
			arr[0]= "Sender";
        Connection con;
        
		try {
			con = DriverManager.getConnection(jdc);
			//query to List Request
        String q = "Select Hashid From Message Where "+arr[0]+"= '"+arr[1]+"' And Time>="+arr[2]+" And Time<="+String.valueOf(Instant.now().getEpochSecond());
        Statement stat = con.createStatement();
        ResultSet res =  stat.executeQuery(q);
       int count =0;
        while(res.next()){
           ret += "--"+res.getString("Hashid").replace("SHA-256 ", "");
            count++;
            
        }
        ret = count+""+ret;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		return ret;
	}
	
	
	//Getting Data for get Request
	public static String getMessage(String hash) {
		String ret = "";
		String jdc = "jdbc:sqlite:politeDB.sqlite3";
        Connection con;
        
		try {
			con = DriverManager.getConnection(jdc);
        String q = "Select * From Message Where Hashid= '"+hash+"';";
        Statement stat = con.createStatement();
        ResultSet res =  stat.executeQuery(q);
       
        while(res.next()){
           
           ret += ""+res.getString("Time");
           ret += "--"+res.getString("Sender");
           ret += "--"+res.getString("Receiver");
           ret += "--"+res.getString("Topic");
           ret += "--"+res.getString("Subject");
           ret += "--"+res.getString("Message");
            
            
        }
        
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		return ret;
	}

}
