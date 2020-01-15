package it.dipvvf.abr.app.auth.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AuthSOAP {
	@WebMethod
	public boolean authenticate(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);
	
	@WebMethod
	public boolean hasRole(@WebParam(name = "userName") String userName, @WebParam(name = "role") String role);
}
