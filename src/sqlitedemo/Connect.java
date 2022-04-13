package sqlitedemo;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class Connect {
	 public  Connection connect() {  
		 
	        Connection conn = null;  
	        try {
	        	//Class.forName("com.sqlite.jdbc.Driver");
	        	//con = DriverManager.getConnection("jdbc:sqlite://localhost:3306/test_db", "user", "passw");
	            // db parameters  
	            //String url = "jdbc:sqlite:C:/sqlite/sqlitedbsales.db";  
	            // create a connection to the database  
	            //conn = DriverManager.getConnection(url);
	        	conn=DriverManager.getConnection("jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3380200\\testDB.db"
	        			+ "");
	              
	            System.out.println("Connection to SQLite has been established.");  
	              
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            try {  
	                if (conn != null) {  
	                    conn.close();  
	                }  
	            } catch (SQLException ex) {  
	                System.out.println(ex.getMessage());  
	            }  
	        }
			return conn;  
	    }  
	 
	 public  void createNewTable() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
	          
	        // SQL statement for creating a new table  
	        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"  
	                + " id integer PRIMARY KEY,\n"  
	                + " name text NOT NULL,\n"  
	                + " actor text NOT NULL,\n"
	                + " actress text NOT NULL,\n"
	                + " director text NOT NULL,\n"
	                + " year integer NOT NULL\n"
	                + ");";  
	          
	        try{  
	            Connection conn = DriverManager.getConnection(url);  
	            Statement stmt = conn.createStatement();  
	            stmt.execute(sql);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	    
	 public  void insert(int id,String name,String actor,String actress,String director ,int year) {  
	        String sql = "INSERT INTO movies(id,name,actor,actress,director,year) VALUES(?,?,?,?,?,?)";  
	   
	        try{  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setInt(1, id); 
	            pstmt.setString(2,name);
	            pstmt.setString(3,actor);
	            pstmt.setString(4,actress);
	            pstmt.setString(5,director);
	            pstmt.setInt(6, year);  
	            pstmt.executeUpdate();  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	 
	 
	 public  void selectAll(){  
	        String sql = "SELECT * FROM employees";  
	          
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	                System.out.println(rs.getInt("id") +  "\t" +   
	                                   rs.getString("name") + "\t" +  
	                                   rs.getString("actor")+"\t"+
	                                   rs.getString("actress")+"\t"+
	                                   rs.getString("director")+"\t"+
	                                   rs.getInt("year")+"\n");  
	            }  
	        } catch (SQLException e) {  
	            System.out.println("hello");  
	        }  
	    }  
	    /** 
	     * @param args the command line arguments 
	     */  
	    public static void main(String[] args) {  
	    	Connect c=new Connect();
	        c.connect();  
	        //createNewTable();
	        //insert(1,"newyork","ben","priya","yash raj",2000);
	        c.selectAll();
	    }  

}
