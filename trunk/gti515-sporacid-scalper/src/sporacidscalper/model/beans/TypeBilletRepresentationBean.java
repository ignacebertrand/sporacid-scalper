package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;

public class TypeBilletRepresentationBean extends AbstractBean implements Modelable
{
	/**
	 * Serializable interface requirement
	 */
	private static final long serialVersionUID = 7463123842127037572L;
	
	private double prix;
	private int nbBilletEmis;
	private TypeBilletBean type;
	
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
		// TODO Auto-generated method stub
		return null;
	}
}