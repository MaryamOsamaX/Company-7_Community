package fci.sw2.project.follow;

import javax.persistence.*;



@Entity
public class Follow {
	@EmbeddedId
	private Fkey key;
	
	public Fkey getKey() {
		return key;
	}
	
	public void setKey(Fkey key) {
		this.key = key;
	}

}
