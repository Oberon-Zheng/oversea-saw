package Entity;

public class ImageEntity {

	private int img_id;
	private int thread_posted_thr_id;
	private String img_url;
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public int getThread_posted_thr_id() {
		return thread_posted_thr_id;
	}
	public void setThread_posted_thr_id(int thread_posted_thr_id) {
		this.thread_posted_thr_id = thread_posted_thr_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
