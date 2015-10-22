package com.dcservice.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.dcservice.web.common.HeaderBean;
import com.dcservice.web.pages.TestBean;
import com.sun.xml.internal.ws.client.RequestContext;

public abstract class BasePageBean implements Serializable {

  @PostConstruct
  public void init() {
    onConstruct();
  }

  protected abstract void onConstruct();

  protected boolean isPageBean() {
    return true;
  }

  public void submit() {
    try {
      ((TestBean) this).onSubmit();
      HeaderBean.updateResponsesCount();
    } catch (Exception e) {
    }
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
