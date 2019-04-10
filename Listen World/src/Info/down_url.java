package Info;

public class down_url {
	private String url;
	private int id;
	private int size;
	public down_url(String u,int i,int size) {
		this.url=u;
		this.id=i;
		this.size=size;
	}
	public String getUrl() {
		return url;
	}
	public int getId() {
		return id;
	}
	public int getSize() {
		return size;
	}
	public String toString() {
		return url+"  ID  "+id+"  SIZE: "+size;
	}
}
