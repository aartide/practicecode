
public class ReportDTO {

	private long  id;
	private String PlaceName;
	private String PlaceDcid;
	private String PlaceType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaceName() {
		return PlaceName;
	}
	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}
	public String getPlaceDcid() {
		return PlaceDcid;
	}
	public void setPlaceDcid(String placeDcid) {
		PlaceDcid = placeDcid;
	}
	public String getPlaceType() {
		return PlaceType;
	}
	public void setPlaceType(String placeType) {
		PlaceType = placeType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportDTO [id=");
		builder.append(id);
		builder.append(", PlaceName=");
		builder.append(PlaceName);
		builder.append(", PlaceDcid=");
		builder.append(PlaceDcid);
		builder.append(", PlaceType=");
		builder.append(PlaceType);
		builder.append("]");
		return builder.toString();
	}
	
	
}
