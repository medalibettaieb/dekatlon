package services.interfaces;

import java.util.Map;

import javax.ejb.Local;

import domain.Produit;

@Local
public interface CommandeServiceLocal {
	void commanderParMap(Map<Produit, Integer> mapOfProduits);

	void commanderParProduit(Produit produit, Integer quantite);
}
