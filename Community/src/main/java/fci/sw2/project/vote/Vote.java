package fci.sw2.project.vote;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class Vote {
	 
	private Key key;
	private String type;
	@EmbeddedId
	public Key getKey() {
		return key;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Vote(){}

	public Vote(Key key, String type) {
		super();
		this.key = key;
		this.type = type;
	}
	

}
