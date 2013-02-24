package sporacidscalper.view.beans;

public class FormulaireItemPanierAchat 
{
	private int itemId;
	private int quantite;
	private int spectacleId;
	private int representationId;
	private int typeBilletId;
	
	public FormulaireItemPanierAchat()
	{
		this.itemId = -1;
		this.quantite = 0;
		this.spectacleId = -1;
		this.representationId = -1;
		this.typeBilletId = -1;
	}
	
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getSpectacleId() {
		return spectacleId;
	}
	public void setSpectacleId(int spectacleId) {
		this.spectacleId = spectacleId;
	}
	public int getRepresentationId() {
		return representationId;
	}
	public void setRepresentationId(int representationId) {
		this.representationId = representationId;
	}
	public int getTypeBilletId() {
		return typeBilletId;
	}
	public void setTypeBilletId(int typeBilletId) {
		this.typeBilletId = typeBilletId;
	}
}
