package it.dipvvf.abr.app.auth.servlet;

import java.util.concurrent.Executors;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import it.dipvvf.abr.app.auth.soap.AuthSOAPService;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 8905340039686648745L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		
		Endpoint ep = Endpoint.create(new AuthSOAPService());
		ep.setExecutor(Executors.newCachedThreadPool());
		ep.publish("/auth");
	}
}
