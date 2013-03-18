package sporacidscalper.view.beans;

public class FormulaireAjoutSpectacle {

	private int id;
	private String nomSpectacle;
	private String description;
	private String posterUrl;
	private int[] artistes;
	private int type;
	private int[] representations;
	
	public int getSpectacleId() {
		return id;
	}

	public void setSpectacleId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nomSpectacle;
	}

	public void setNom(String nomSpectacle) {
		this.nomSpectacle = nomSpectacle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public int[] getArtistes() {
		return artistes;
	}

	public void setArtistes(int[] artistes) {
		this.artistes = artistes;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int[] getRepresentations() {
		return representations;
	}

	public void setRepresentations(int[] representations) {
		this.representations = representations;
	}
}
