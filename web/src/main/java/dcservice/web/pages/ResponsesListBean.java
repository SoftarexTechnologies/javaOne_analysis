package dcservice.web.pages;

import dcservice.persistence.dao.DaoManager;
import dcservice.web.BasePageBean;
import dcservice.web.wrappers.ColumnModel;
import dcservice.web.wrappers.ResponseWrapper;
import common.exceptions.PersistenceBeanException;
import models.QFieldResponse;
import models.fields.Field;
import models.fields.QField;
import models.responses.QResponse;
import models.responses.Response;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ResponsesListBean extends BasePageBean {

	private static final long serialVersionUID = 4254482680299501574L;

	private List<ColumnModel> columns;

	private List<ResponseWrapper> responses;

	@Override
	protected void onConstruct() {
		try {
			List<Response> responsesItems = DaoManager
					.query()
					.from(QResponse.response)
					.rightJoin(QResponse.response.fieldResponses,
							QFieldResponse.fieldResponse).fetch()
					.rightJoin(QFieldResponse.fieldResponse.field).fetch()
					.distinct().list(QResponse.response);
			List<Field> fields = DaoManager.query().from(QField.field)
					.list(QField.field);
			
			columns = new ArrayList<>();
			fields.forEach(field -> {
				columns.add(new ColumnModel(field.getLabel(), field.getLabel()));
			});

			responses = new ArrayList<>();
			responsesItems.forEach(item -> {
				responses.add(new ResponseWrapper(item));
			});

		} catch (IllegalAccessException | PersistenceBeanException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public List<ResponseWrapper> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseWrapper> responses) {
		this.responses = responses;
	}

}
