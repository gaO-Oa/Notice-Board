package board;

public class Post {
	public int pk;
	public String user;
	public String title;
	public String content;
	public Boolean highlight;

	public Post(String user, String title, String content, Boolean highlight) {
		super();
		this.user = user;
		this.title = title;
		this.content = content;
		this.highlight = highlight;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}

	@Override
	public String toString() {
		return "Board [user=" + user + ", title=" + title + ", content=" + content + ", highlight=" + highlight + "]";
	}
}
