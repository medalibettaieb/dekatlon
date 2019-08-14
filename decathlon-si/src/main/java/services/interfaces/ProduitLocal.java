package services.interfaces;

import javax.ejb.Local;

import domain.Produit;
import utilitaire.IGenericDAO;
@Local
public interface ProduitLocal extends IGenericDAO<Produit> {

}
