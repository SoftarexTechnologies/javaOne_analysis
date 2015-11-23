package dcservice.web.listeners;

import dcservice.persistence.HibernateUtil;
import dcservice.persistence.IConnectionListner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener, IConnectionListner {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getInstance().addConnectionListener(this);
		HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public void fireConnetionEstablished() {
	}

	@Override
	public void fireConnetionResufed() {
	}

}
