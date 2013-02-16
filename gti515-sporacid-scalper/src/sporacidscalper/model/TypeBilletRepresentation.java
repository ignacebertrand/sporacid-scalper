package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.TypeBilletBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

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
		TypeBilletRepresentationBean bean = new TypeBilletRepresentationBean();
		
		bean.setNbBilletEmis(this.nbBilletEmis);
		bean.setPrix(this.prix);
		bean.setType((TypeBilletBean)this.type.getBean());
		
		return bean;
	}
}