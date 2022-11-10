package pres;

import java.util.List;
import java.util.Scanner;

import metier.CatalogueMetierImpl;
import metier.Produit;

public class Presentation {

	public static void main(String[] args) {
		Scanner clavier = new Scanner (System.in);
	CatalogueMetierImpl metier = new CatalogueMetierImpl();
	System.out.print("Nom du produit:"); String nom = clavier.next();
	System.out.print("Prixdu produit:"); Double prix= clavier.nextDouble();
	System.out.print("Quantité:"); int quantite = clavier.nextInt();
	
	Produit pr= new Produit(nom, prix, quantite);
	metier.addProduit(pr);
	
	
	
	
	
	
	System.out.println("Mot clé:");
	String mc = clavier.next();
	List<Produit> prods=metier.produitsParMC(mc);
	for(Produit p:prods) {
		System.out.println(p.getIdProduit()+"\t"+p.getNomProduit()+"\t"+p.getPrix()+"\t"+p.getQuantite());
	}

	}

}
