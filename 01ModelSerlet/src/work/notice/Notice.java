package work.notice;

public class Notice {
	
	private int noticeNo;
	private String title;
	private String contents;
	
	public Notice(){
		
	}

	public Notice(int noticeNo, String title, String contents) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.contents = contents;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [noticeNo=");
		builder.append(noticeNo);
		builder.append(", title=");
		builder.append(title);
		builder.append(", contents=");
		builder.append(contents);
		builder.append("]");
		return builder.toString();
	}
	

}
