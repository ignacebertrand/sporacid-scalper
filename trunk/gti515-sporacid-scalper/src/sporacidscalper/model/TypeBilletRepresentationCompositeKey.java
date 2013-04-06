package sporacidscalper.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

//Child entity's composite primary key
@Embeddable
public class TypeBilletRepresentationCompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5119769740933782817L;
	
	int representation_id;
	int type_billet_id;
}
