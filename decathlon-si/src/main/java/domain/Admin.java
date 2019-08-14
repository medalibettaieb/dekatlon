package domain;

import domain.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(String nom, String prenom, String adresse, String numTel, String email, String userName,
			String password) {
		super(nom, prenom, adresse, numTel, email, userName, password);
		// TODO Auto-generated constructor stub
	}
   
}
