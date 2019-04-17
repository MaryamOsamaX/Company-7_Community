package fci.sw2.project.follow;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Follow {
	private Fkey key;
	@EmbeddedId
	public Fkey getKey() {
		return key;
	}
	
	public void setKey(Fkey key) {
		this.key = key;
	}

}
