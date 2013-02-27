package sporacidscalper.view.beans;

import java.util.Date;
import java.util.List;

import sporacidscalper.model.beans.SalleBean;
import sporacidscalper.model.beans.TypeBilletRepresentationBean;

public class FormulaireAjoutReprésentation {

	private int id;
	private Date dateDebutRepresentation;
	private Date dateFinRepresentation;
	private String statut;
	private List<TypeBilletRepresentationBean> typesBillet;
	private SalleBean salle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebutRepresentation() {
		return dateDebutRepresentation;
	}

	public void setDateDebutRepresentation(Date dateDebutRepresentation) {
		this.dateDebutRepresentation = dateDebutRepresentation;
	}

	public Date getDateFinRepresentation() {
		return dateFinRepresentation;
	}

	public void setDateFinRepresentation(Date dateFinRepresentation) {
		this.dateFinRepresentation = dateFinRepresentation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<TypeBilletRepresentationBean> getTypesBillet() {
		return typesBillet;
	}

	public void setTypesBillet(List<TypeBilletRepresentationBean> typesBillet) {
		this.typesBillet = typesBillet;
	}

	public SalleBean getSalle() {
		return salle;
	}

	public void setSalle(SalleBean salle) {
		this.salle = salle;
	}
}
