package services.interfaces;

import javax.ejb.Local;

import domain.User;
import utilitaire.IGenericDAO;


@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);

}
