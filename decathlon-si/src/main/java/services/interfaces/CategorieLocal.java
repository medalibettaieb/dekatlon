package services.interfaces;

import javax.ejb.Local;

import domain.Categorie;
import utilitaire.IGenericDAO;

@Local
public interface CategorieLocal extends IGenericDAO<Categorie> {

}
