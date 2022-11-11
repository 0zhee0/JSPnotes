package com.itwillbs.order.action;

public class ActionForward { // 이동티켓
	private String path;
	private boolean isRedirect;
	
	// ctrl shift s + r  --> setter/getter 생성 
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
