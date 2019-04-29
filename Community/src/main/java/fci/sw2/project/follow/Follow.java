package fci.sw2.project.follow;

import javax.persistence.*;



@Entity
public class Follow {
	@EmbeddedId
	private Fkey key;
	
	public Follow(){}
	public Follow(Fkey key) {
		super();
		this.key = key;
	}

	public Fkey getKey() {
		return key;
	}
	
	public void setKey(Fkey key) {
		this.key = key;
	}

}
