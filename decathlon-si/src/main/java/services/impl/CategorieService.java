package services.impl;

import javax.ejb.Stateless;

import domain.Categorie;
import services.interfaces.CategorieLocal;
import utilitaire.GenericDAO;

@Stateless
public class CategorieService extends GenericDAO<Categorie> implements CategorieLocal {
	public CategorieService() {
		super(Categorie.class);
	}
}
