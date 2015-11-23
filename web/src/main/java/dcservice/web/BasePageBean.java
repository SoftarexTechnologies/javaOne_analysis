package dcservice.web;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class BasePageBean implements Serializable {

	private static final long serialVersionUID = -7281819428768535761L;
	protected static final Logger log = Logger.getLogger(BasePageBean.class);
	
	@PostConstruct
	public void init() {
		onConstruct();
	}

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}

	private void readObjectNoData() throws ObjectStreamException {
		throw new InvalidObjectException("Stream data required");
	}
	
	protected abstract void onConstruct();

	protected boolean isPageBean() {
		return true;
	}
	
	public void updateJS(String str) {
		RequestContext context = RequestContext.getCurrentInstance();
		if (context != null) {
			context.update(str);
		}
	}

	public HttpServletRequest getRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public ServletResponse getResponse() {
		return (ServletResponse) getExternalContext().getResponse();
	}

	public FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public ExternalContext getExternalContext() {
		return getContext().getExternalContext();
	}

	public String getRequestContextPath() {
		return getContext().getExternalContext().getRequestContextPath();
	}

	public boolean isPostback() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.isPostback();
	}

}
