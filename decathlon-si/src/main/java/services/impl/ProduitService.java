package services.impl;

import javax.ejb.Stateless;

import domain.Produit;
import services.interfaces.ProduitLocal;
import utilitaire.GenericDAO;
@Stateless
public class ProduitService extends GenericDAO<Produit> implements ProduitLocal {
	public ProduitService() {
		super(Produit.class);
	}
}
