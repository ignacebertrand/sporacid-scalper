package sporacidscalper.view.beans;

import java.util.List;

import sporacidscalper.model.Artiste;
import sporacidscalper.model.Representation;
import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public class FormulaireAjoutSpectacle {

	private int id;
	private String nom;
	private String description;
	private String posterUrl;
	private List<ArtisteBean> artistes;
	private TypeSpectacleBean type;
	private List<Representation> representations;
	
	public int getSpectacleId() {
		return id;
	}

	public void setSpectacleId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public List<ArtisteBean> getArtistes() {
		return artistes;
	}

	public void setArtistes(List<ArtisteBean> artistes) {
		this.artistes = artistes;
	}

	public TypeSpectacleBean getType() {
		return type;
	}

	public void setType(TypeSpectacleBean type) {
		this.type = type;
	}

	public List<Representation> getRepresentations() {
		return representations;
	}

	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}
}
