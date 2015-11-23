package dcservice.web.common;

import common.exceptions.PersistenceBeanException;
import dcservice.persistence.dao.DaoManager;
import dcservice.web.BasePageBean;
import models.responses.QResponse;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HeaderBean extends BasePageBean {

	private static final long serialVersionUID = 7844098857850505763L;

	static int responsesCount;
	static {
		responsesCount = 0;
	}

	@Override
	protected void onConstruct() {
		try {
			updateResponsesCount();
		} catch (IllegalAccessException | PersistenceBeanException e) {
			log.error(e.getMessage(), e);
		}
	}

	public static void updateResponsesCount() throws IllegalAccessException,
			PersistenceBeanException {
		responsesCount = (int) DaoManager.query().from(QResponse.response)
				.count();
	}

	@Override
	protected boolean isPageBean() {
		return false;
	}

}
