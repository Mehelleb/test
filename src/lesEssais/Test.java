package lesEssais;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/yyy","root","");
			
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS");
		
			ResultSet rs= ps.executeQuery();
			
//			while(rs.next()) {
//				System.out.println(rs.getInt("ID_PRODUIT")+"\t"+ rs.getString("NOM_PRODUIT")+
//						"\t"+ rs.getDouble("PRIX")+"\t"+ rs.getInt("QUANTITE"));
//			}
			
			
			
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1; i<=rsmd.getColumnCount(); i++){
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next()) {
				for(int i=1; i<=rsmd.getColumnCount(); i++) {
					System.out.print(rs.getString(i)+"\t"+"\t");	
				}
				System.out.println();
			}
			
			}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}	
