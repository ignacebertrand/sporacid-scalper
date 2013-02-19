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
	
	private double prix;
	private int nbBilletEmis;
	private TypeBilletBean type;
	private int representationId;
	
	public TypeBilletRepresentationBean(int representationId)
	{
		this.prix = 0.0;
		this.nbBilletEmis = 0;
		this.type = new TypeBilletBean();
		this.representationId = representationId;
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
	
	public int getRepresentationId()
	{
		return this.representationId;
	}

	@Override
	public AbstractModelObject getModelObject()
	{
		TypeBilletRepresentation tbr = new TypeBilletRepresentation(this.representationId);
		
		tbr.setNbBilletEmis(this.nbBilletEmis);
		tbr.setPrix(this.prix);
		tbr.setType((TypeBillet)this.type.getModelObject());
		
		return tbr;
	}
}