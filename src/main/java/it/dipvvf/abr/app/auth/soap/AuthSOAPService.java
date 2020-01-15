package it.dipvvf.abr.app.auth.soap;

import it.dipvvf.abr.app.auth.support.UserStore;

public class AuthSOAPService implements AuthSOAP {

	@Override
	public boolean authenticate(String userName, String password) {
		return UserStore.getStore().checkUser(userName, password);
	}

	@Override
	public boolean hasRole(String userName, String role) {
		return UserStore.getStore().getGroups(userName).contains(role);
	}

}
