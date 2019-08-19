package decathlon_si.webCtr.mBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import decathlon_si.domaine.Admin;
import decathlon_si.domaine.Client;
import decathlon_si.domaine.StockManager;
import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private Boolean isLogged = false;
	private Boolean isEmployee = false;
	private Boolean isAdmin = false;
	@EJB
	private UserServiceLocal userManagementLocal;
	private boolean loggedInAsClient;
	private boolean loggedInAsAdministrateur;
	private boolean loggedInAsStockManager;

	public String doLogin() {
		String navigateTo = null;
		User userLoggedIn = userManagementLocal.login(user.getUserName(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			isLogged = true;
			if (userLoggedIn instanceof Client) {
				setLoggedInAsClient(true);
				navigateTo = "a?faces-redirect=true";
			} else if (userLoggedIn instanceof Admin) {
				setLoggedInAsAdministrateur(true);
				navigateTo = "/pages/adminHome?faces-redirect=true";
			}
			else if (userLoggedIn instanceof StockManager) {
				setLoggedInAsStockManager(true);
				navigateTo = "/pages/stockManagerHome?faces-redirect=true";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Veuillez insérer une matricule et un mot de passe valide",
							           ""));
			;
		}
		return navigateTo;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	

	public boolean isLoggedInAsClient() {
		return loggedInAsClient;
	}

	public void setLoggedInAsClient(boolean loggedInAsClient) {
		this.loggedInAsClient = loggedInAsClient;
	}

	public boolean isLoggedInAsAdministrateur() {
		return loggedInAsAdministrateur;
	}

	public void setLoggedInAsAdministrateur(boolean loggedInAsAdministrateur) {
		this.loggedInAsAdministrateur = loggedInAsAdministrateur;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isLoggedInAsStockManager() {
		return loggedInAsStockManager;
	}

	public void setLoggedInAsStockManager(boolean loggedInAsStockManager) {
		this.loggedInAsStockManager = loggedInAsStockManager;
	}

}
