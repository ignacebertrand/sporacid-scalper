package sporacidscalper.view.presentation;

import java.util.List;

import sporacidscalper.model.beans.ArtisteBean;
import sporacidscalper.model.beans.RepresentationBean;
import sporacidscalper.model.beans.TypeSpectacleBean;

public interface IPresentationBillets {

	public String getAppendedArtists(List<ArtisteBean> artistes);
	public String getRepresentationsListItem(List<RepresentationBean> representations);
	public String getTypesListItem(List<TypeSpectacleBean> types);
	public String getTagsAnchors(List<ArtisteBean> artistes);
}
