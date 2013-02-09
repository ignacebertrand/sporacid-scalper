package sporacidscalper.model.beans;

public class SpectacleBean
{
	private String nom;
	private String description;
	private ArtisteBean[] artistes;
	private TypeSpectacleBean type;
	private RepresentationBean[] representations;

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}