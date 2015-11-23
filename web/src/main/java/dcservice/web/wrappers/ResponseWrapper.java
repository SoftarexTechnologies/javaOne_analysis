package dcservice.web.wrappers;

import models.responses.Response;

import java.util.HashMap;
import java.util.Map;

import static common.helpers.ValidationHelper.isNullOrEmpty;

public class ResponseWrapper {

	private Map<String, String> values;

	public ResponseWrapper(Response response) {
		values = new HashMap<String, String>();
		if (!isNullOrEmpty(response.getFieldResponses())) {
			response.getFieldResponses().forEach(item -> {
				values.put(item.getField().getLabel(), item.getAnswer());
			});
		}
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

}
