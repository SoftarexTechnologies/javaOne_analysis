package dcservice.web.pages;

import dcservice.persistence.dao.DaoManager;
import dcservice.web.BasePageBean;
import common.enums.PagesTypes;
import common.exceptions.PersistenceBeanException;
import common.helpers.ListHelper;
import common.helpers.RedirectHelper;
import models.fields.Field;
import models.fields.QField;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class FieldListBean extends BasePageBean implements Serializable {

	private static final long serialVersionUID = -8392767442203245466L;

	private List<Field> fields;

	@Override
	protected void onConstruct() {
			try {
				fields = DaoManager.query().from(QField.field).fetchAll()
						.list(QField.field);
			} catch (IllegalAccessException | PersistenceBeanException e) {
				log.error(e.getMessage(), e);
			}
	}

	public void add() {
		RedirectHelper.goTo(PagesTypes.FIELD_NEW);
	}

	public void edit(Long id) {
		RedirectHelper.goTo(PagesTypes.FIELD_EDIT, id);
	}

	public void delete(Long id) throws Exception {
		Field field = DaoManager.query().from(QField.field)
				.where(QField.field.id.eq(id)).uniqueResult(QField.field);
		ListHelper.remove(fields, field);
		DaoManager.remove(field, true);
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
