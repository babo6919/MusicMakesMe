package vo;



//포워딩에 관련된 정보를 지정하는 클래스
//포워딩할때 redirect여부, 포워딩할 경로값에 대한 지정 등을 할수 있음.
public class ActionForward {
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}//boolean은 get이 안 붙음
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
