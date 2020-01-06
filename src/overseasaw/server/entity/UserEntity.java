package overseasaw.server.entity;

import java.sql.Date;

import com.alibaba.fastjson.JSONObject;

public class UserEntity {

	private int usr_id;
	private String usr_email;
	private String usr_name;
	private String usr_pswd;
	private Date usr_birth;
	private String usr_sex;
	private String usr_tel;
	private int usr_school;
	private Date reg_time;
	private boolean usr_authenticated;
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_pswd() {
		return usr_pswd;
	}
	public void setUsr_pswd(String usr_pswd) {
		this.usr_pswd = usr_pswd;
	}
	public Date getUsr_birth() {
		return usr_birth;
	}
	public void setUsr_birth(Date usr_birth) {
		this.usr_birth = usr_birth;
	}
	public String getUsr_sex() {
		return usr_sex;
	}
	public void setUsr_sex(String string) {
		this.usr_sex = string;
	}
	public String getUsr_tel() {
		return usr_tel;
	}
	public void setUsr_tel(String usr_tel) {
		this.usr_tel = usr_tel;
	}
	public int getUsr_school() {
		return usr_school;
	}
	public void setUsr_school(int usr_school) {
		this.usr_school = usr_school;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public boolean getUsr_authenticated() {
		return usr_authenticated;
	}
	public void setUsr_authenticated(boolean usr_authenticated) {
		this.usr_authenticated = usr_authenticated;
	}
	
	public static final int regSuccess = 0;
	public static final int regNameDup = -1;
	public static final int regEmailDup = -2;
	public static final int regTelDup = -4;
	public static final int regNameInvalid = 1;
	public static final int regEmailInvalid = 2;
	public static final int regPswdInvalid = 3;
	public static final int regTelInvalid = 4;
	public static final int regOtherFailure = 255;
	
	public JSONObject Serialize()
	{
		JSONObject json = new JSONObject();
		json.put("usr_id", this.getUsr_id());
		json.put("usr_email",this.getUsr_email());
		json.put("usr_name",this.getUsr_name());
		json.put("usr_pswd", this.getUsr_pswd());
		json.put("usr_birth",this.getUsr_birth());
		json.put("usr_sex",this.getUsr_sex());
		json.put("usr_school", this.getUsr_school());
		json.put("usr_pswd", this.getUsr_pswd());
		json.put("usr_regtime",this.getReg_time());
		json.put("usr_auth",this.getUsr_authenticated());
		return json;
	}
}
