package overseasaw.server.entity;

public class ThreadPostedEntity {

	private int thr_id;
	private int thr_author;
	private String thr_text;
	private int thr_type;
	private int thr_enabled;
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
	public int getThr_enabled() {
		return thr_enabled;
	}
	public void setThr_enabled(int thr_enabled) {
		this.thr_enabled = thr_enabled;
	}
	public int getThr_replyto() {
		return thr_replyto;
	}
	public void setThr_replyto(int thr_replyto) {
		this.thr_replyto = thr_replyto;
	}
	
}
