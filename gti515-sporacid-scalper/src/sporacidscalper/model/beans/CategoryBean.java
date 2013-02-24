package sporacidscalper.model.beans;

import sporacidscalper.model.AbstractModelObject;
import sporacidscalper.model.Category;

public class CategoryBean extends AbstractBean implements Modelable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	
	
	public CategoryBean()
	{
		this(-1);
	}
	
	public CategoryBean(int id)
	{
		this.id = id;
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
	public AbstractModelObject getModelObject() 
	{
		Category c = new Category();
		
		c.setId(this.id);
		c.setDescription(this.description);
		
		return c;
	}

}
