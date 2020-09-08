package org.young.domain;

public class AttachFileDTO {
	//파일이름(문자열)
	private String fileName;
	//파일저장위치(문자열)
	private String uploadPath;
	//UUID(문자열)
	private String uuid;
	//image여부(boolean) : ture면 이미지파일 -display , false면 이미지 아닌때 - download
	private boolean image;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "AttachFileDTO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image="
				+ image + "]";
	}
	
	
}
