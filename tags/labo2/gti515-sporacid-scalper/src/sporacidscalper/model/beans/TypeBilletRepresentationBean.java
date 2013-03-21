package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.TypeBillet;
import sporacidscalper.model.TypeBilletRepresentation;

public class TypeBilletRepresentationBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 7463123842127037572L;

	// Upper reference
	private int representationId;
	private RepresentationBean representationReference; 
	
	private double prix;
	private int nbBilletEmis;
	private TypeBilletBean type;
	
	public TypeBilletRepresentationBean()
	{
		this(-1);
	}
	
	public TypeBilletRepresentationBean(int representationId)
	{
		// Upper reference
		this.representationId = representationId;
		this.representationReference= null;
		
		this.prix = -1;
		this.nbBilletEmis = -1;
		this.type = null; 
	}
	
	public int getRepresentationId()
	{
		return this.representationId;
	}
	
	public RepresentationBean getRepresentationReference()
	{
		return this.representationReference;
	}
	
	public void setRepresentationReference(RepresentationBean representationReference)
	{
		this.representationReference = representationReference;
	}
	
	public double getPrix()
	{
		return prix;
	}
	
	public void setPrix(double prix)
	{
		this.prix = prix;
	}
	
	public int getNbBilletEmis()
	{
		return nbBilletEmis;
	}
	
	public void setNbBilletEmis(int nbBilletEmis)
	{
		this.nbBilletEmis = nbBilletEmis;
	}
	
	public TypeBilletBean getType()
	{
		return type;
	}
	
	public void setType(TypeBilletBean type)
	{
		this.type = type;
	}


	@Override
	public AbstractModelObject getModelObject()
	{
		TypeBilletRepresentation tbr = null;
		
		if(this != null)
		{
			tbr = new TypeBilletRepresentation(this.representationId);
			
			tbr.setNbBilletEmis(this.nbBilletEmis);
			tbr.setPrix(this.prix);
			tbr.setType((TypeBillet)this.type.getModelObject());
		}
		
		return tbr;
	}
}