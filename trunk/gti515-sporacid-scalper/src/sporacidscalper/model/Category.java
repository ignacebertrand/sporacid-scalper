package sporacidscalper.model;

import sporacidscalper.model.beans.AbstractBean;
import sporacidscalper.model.beans.CategoryBean;

public class Category extends AbstractModelObject implements Beanable 
{
	private int id;
	private String description;
		
	public Category()
	{
		this(-1);
	}
	
	public Category(int id)
	{
		this.id = id;
	}
	
	public Category(int id, String description)
	{
		this.id = id;
		this.description = description;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	@Override
	public AbstractBean getBean() 
	{
		CategoryBean c = new CategoryBean();
		
		c.setDescription(this.description);
		c.setId(this.id);
		
		return c;
	}

}
