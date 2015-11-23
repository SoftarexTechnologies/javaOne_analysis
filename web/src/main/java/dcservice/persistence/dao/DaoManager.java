package dcservice.persistence.dao;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import common.exceptions.PersistenceBeanException;
import dcservice.persistence.PersistenceSessionManager;
import models.base.BaseModel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.faces.context.FacesContext;
import java.util.Date;

public class DaoManager {

	public final static Logger log = Logger.getLogger(DaoManager.class);

	public static Session getSession() throws IllegalAccessException,
			PersistenceBeanException {
		if (FacesContext.getCurrentInstance() == null) {
			throw new IllegalAccessException(
					"DaoManager: 44; \"FacesContext.getCurrentInstance() is null\"");
		}
		return PersistenceSessionManager.getBean().getSession();
	}

	public static HibernateQuery query() throws IllegalAccessException,
			PersistenceBeanException {
		return new HibernateQuery(getSession());
	}

	public static void save(BaseModel object) {
		save(object, false);
	}

	public static void save(BaseModel object, boolean beginTransaction) {
		Transaction tr = null;
		try {
			if (beginTransaction) {
				tr = DaoManager.getSession().beginTransaction();
			}
			beforeSaveOrUpdate(object);

			if (getSession().contains(object)) {
				getSession().update(object);
			} else {
				getSession().saveOrUpdate(object);
			}
		} catch (IllegalAccessException | PersistenceBeanException e) {
			log.error(e.getMessage(), e);
			if (beginTransaction) {
				if (tr != null && tr.getStatus() == TransactionStatus.ACTIVE) {
					tr.rollback();

					try {
						if (getSession().isOpen()) {
							getSession().close();
						}

					} catch (IllegalAccessException | PersistenceBeanException ex) {
						log.error(ex.getMessage(), ex);
					}
				}
			}
		} finally {
			if (beginTransaction) {
				if (tr != null && tr.getStatus() == TransactionStatus.ACTIVE
						&& tr.getStatus() != TransactionStatus.ROLLED_BACK) {
					tr.commit();
				}
			}
		}
	}

	public static void beforeSaveOrUpdate(BaseModel object) {
		if (object.getCreatedDate() == null) {
			object.setCreatedDate(new Date());
		} else {
			object.setUpdatedDate(new Date());
		}
	}

	public static <T extends BaseModel> void remove(T object) {
		remove(object, false);
	}

	public static <T extends BaseModel> void remove(T object,
			boolean beginTransaction) {
		Transaction tr = null;
		try {
			if (beginTransaction) {
				tr = DaoManager.getSession().beginTransaction();
			}

			getSession().delete(object);

		} catch (IllegalAccessException | PersistenceBeanException e) {
			log.error(e);
			if (beginTransaction) {
				if (tr != null && tr.getStatus() == TransactionStatus.ACTIVE) {
					tr.rollback();
				}
			}
		} finally {
			if (beginTransaction) {
				if (tr != null && tr.getStatus() == TransactionStatus.ACTIVE
						&& tr.getStatus() != TransactionStatus.ROLLED_BACK) {
					tr.commit();
				}
			}
		}
	}

}
