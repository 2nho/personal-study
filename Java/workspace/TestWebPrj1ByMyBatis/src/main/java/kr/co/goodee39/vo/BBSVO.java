package kr.co.goodee39.vo;

import org.apache.ibatis.type.Alias;

@Alias("bbsVO")
public class BBSVO {
	int sid;
    String title;
    String owner;
    String createDate;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
    
    

}
