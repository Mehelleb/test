package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogueMetier {
	List<Produit>produits=new ArrayList<Produit>();

	@Override
	public List<Produit> produitsParMC(String mc) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/yyy","root","");
		PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT like ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			Produit p = new Produit();
			p.setIdProduit(rs.getInt("ID_PRODUIT"));
			p.setNomProduit(rs.getString("NOM_PRODUIT"));
			p.setPrix(rs.getDouble("PRIX"));
			p.setQuantite(rs.getInt("QUANTITE"));
			produits.add(p);
		}
		ps.close(); conn.close();
		} catch (Exception e) {
	   e.printStackTrace();
	}
		return produits;
	}

	
	
	
	
	
	@Override
	public void addProduit(Produit p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/yyy","root","");
			PreparedStatement ps= conn.prepareStatement("insert into PRODUITS (NOM_PRODUIT, PRIX, QUANTITE) values(?, ?, ?)");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			int nb = ps.executeUpdate();
			ps.close(); 
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	
		
	}

}
