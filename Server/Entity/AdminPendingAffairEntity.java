package Entity;

public class AdminPendingAffairEntity {

	private int aff_id;
	private int aff_target_user;
	private int aff_type;
	private int aff_admin;
	private String aff_description;
	public int getAff_id() {
		return aff_id;
	}
	public void setAff_id(int aff_id) {
		this.aff_id = aff_id;
	}
	public int getAff_target_user() {
		return aff_target_user;
	}
	public void setAff_target_user(int aff_target_user) {
		this.aff_target_user = aff_target_user;
	}
	public int getAff_type() {
		return aff_type;
	}
	public void setAff_type(int aff_type) {
		this.aff_type = aff_type;
	}
	public int getAff_admin() {
		return aff_admin;
	}
	public void setAff_admin(int aff_admin) {
		this.aff_admin = aff_admin;
	}
	public String getAff_description() {
		return aff_description;
	}
	public void setAff_description(String aff_description) {
		this.aff_description = aff_description;
	}
}
