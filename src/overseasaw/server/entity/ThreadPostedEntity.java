package overseasaw.server.entity;

import org.json.JSONObject;

public class ThreadPostedEntity {

	private int thr_id;
	private int thr_author;
	private String thr_text;
	private int thr_type;
	private boolean thr_enabled;
	private int thr_replyto;
	
	public int getThr_id() {
		return thr_id;
	}
	public void setThr_id(int thr_id) {
		this.thr_id = thr_id;
	}
	public int getThr_author() {
		return thr_author;
	}
	public void setThr_author(int thr_author) {
		this.thr_author = thr_author;
	}
	public String getThr_text() {
		return thr_text;
	}
	public void setThr_text(String thr_text) {
		this.thr_text = thr_text;
	}
	public int getThr_type() {
		return thr_type;
	}
	public void setThr_type(int thr_type) {
		this.thr_type = thr_type;
	}
	public boolean getThr_enabled() {
		return thr_enabled;
	}
	public void setThr_enabled(boolean thr_enabled) {
		this.thr_enabled = thr_enabled;
	}
	public int getThr_replyto() {
		return thr_replyto;
	}
	public void setThr_replyto(int thr_replyto) {
		this.thr_replyto = thr_replyto;
	}
	
	public ThreadPostedEntity()
	{
		
	}
	
	public ThreadPostedEntity(JSONObject json)
	{
		thr_id = json.optInt("thr_id",0);
		thr_author =  json.optInt("thr_author",0);
		thr_text = json.optString("thr_text",null);
		thr_replyto = json.optInt("thr_replyto",0);
		thr_type = json.optInt("thr_type",0);
		thr_enabled = json.optBoolean("thr_enable",false);
	}
	
	public JSONObject Serialize()
	{
		JSONObject json = new JSONObject();
		json.put("thr_id", thr_id);
		json.put("thr_author", thr_author);
		json.put("thr_text", thr_text);
		json.put("thr_reply", thr_replyto);
		json.put("thr_type", thr_type);
		json.put("thr_enable", thr_enabled);
		return json;
	}
	
}
