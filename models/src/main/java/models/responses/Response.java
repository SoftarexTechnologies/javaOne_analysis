package models.responses;

import models.FieldResponse;
import models.base.BaseModel;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Response extends BaseModel implements Serializable {

	private static final long serialVersionUID = 754140410656222737L;

	@OneToMany(mappedBy = "response")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<FieldResponse> fieldResponses;

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		setId(ois.readLong());
		setVersion(ois.readLong());
		setCreatedDate((Date)ois.readObject());
		setUpdatedDate((Date)ois.readObject());
		
		setFieldResponses((Set<FieldResponse> )ois.readObject());
		
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeLong(getId());
		oos.writeLong(getVersion());
		oos.writeObject(getCreatedDate());
		oos.writeObject(getUpdatedDate());
		
		oos.writeObject(getFieldResponses());
	}

	private void readObjectNoData() throws ObjectStreamException {
		throw new InvalidObjectException("Stream data required");
	}
	
	public Set<FieldResponse> getFieldResponses() {
		return fieldResponses;
	}

	public void setFieldResponses(Set<FieldResponse> fieldResponses) {
		this.fieldResponses = fieldResponses;
	}

}
