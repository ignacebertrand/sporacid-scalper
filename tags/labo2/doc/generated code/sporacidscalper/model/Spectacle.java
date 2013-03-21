package sporacidscalper.model;

public class Spectacle
{
	private String nom;
	private String description;
	private Artiste[] artistes;
	private TypeSpectacle type;
	private Representation[] representations;

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}