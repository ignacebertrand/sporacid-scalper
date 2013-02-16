package sporacidscalper.model.beans;

import java.io.Serializable;

/**
 * Common abstraction for beans throughout the application.
 * @author Simon
 *
 */
public abstract class AbstractBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6903860789107110778L;
	
	private boolean isForDeletion;
	private boolean isForInsertion;
	private boolean isForEdition;
	
	public AbstractBean() 
	{ 
		
	}	
	
	public boolean isForDeletion() 
	{
		return isForDeletion;
	}

	public void setForDeletion(boolean isForDeletion) 
	{
		this.isForDeletion = isForDeletion;
	}

	public boolean isForInsertion() 
	{
		return isForInsertion;
	}

	public void setForInsertion(boolean isForInsertion) 
	{
		this.isForInsertion = isForInsertion;
	}

	public boolean isForEdition() 
	{
		return isForEdition;
	}

	public void setForEdition(boolean isForEdition) 
	{
		this.isForEdition = isForEdition;
	}
}