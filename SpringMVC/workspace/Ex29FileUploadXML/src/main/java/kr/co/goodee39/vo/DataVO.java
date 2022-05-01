package kr.co.goodee39.vo;

import org.springframework.web.multipart.MultipartFile;

public class DataVO {
	private String user;
	private String url;
	private MultipartFile mediaFile;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MultipartFile getMediaFile() {
		return mediaFile;
	}
	public void setMediaFile(MultipartFile mediaFile) {
		this.mediaFile = mediaFile;
	}
	
	
}
