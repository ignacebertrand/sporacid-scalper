package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;

public class TypeBilletRepresentation extends AbstractModelObject implements Beanable
{
	private double prix;
	private int nbBilletEmis;
	private TypeBillet type;
	
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
	
	public TypeBillet getType()
	{
		return type;
	}
	
	public void setType(TypeBillet type)
	{
		this.type = type;
	}
	
	@Override
	public AbstractBean getBean()
	{
		// TODO Auto-generated method stub
		return null;
	}
}