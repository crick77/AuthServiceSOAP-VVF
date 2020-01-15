package it.dipvvf.abr.app.auth.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStore {
	private final static UserStore _instance = new UserStore();
	private final static List<String> EMPTY_GROUPS = new ArrayList<String>(0);
	private Map<User, List<String>> userMap;
	
	private UserStore() {
		userMap = new HashMap<>();
		
		userMap.put(new User("admin", "admin"), Arrays.asList(new String[] { "GAdmin" }));
		userMap.put(new User("user1", "pass1"), Arrays.asList(new String[] { "GAdmin", "GBacheca" }));
		userMap.put(new User("user2", "pass2"), Arrays.asList(new String[] { "GBacheca" }));
		userMap.put(new User("user3", "pass3"), Arrays.asList(new String[] { "GOtherApp" }));
	}
	
	public static UserStore getStore() {
		return _instance;
	}
	
	public boolean checkUser(String userName, String password) {
		return (userMap.get(new User(userName, password))!=null);
	}
	
	public List<String> getGroups(String userName) {
		for(User u : userMap.keySet()) {
			if(u.getUserName().equalsIgnoreCase(userName))
				return userMap.get(u);
		}
		
		return EMPTY_GROUPS;
	}
	
	/**
	 * Inner class
	 * 
	 * @author ospite
	 *
	 */
	class User {
		private String userName;
		private String password;
		
		public User(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}
		
		public String getUserName() {
			return userName;
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}
	}
}
