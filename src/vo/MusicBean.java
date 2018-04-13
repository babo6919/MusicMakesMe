package vo;

public class MusicBean {
	private int MUSIC_NUM;
	private String TITLE;
	private String ARTIST;
	private String MUSIC_FILE_NAME;
	private String MUSIC_FILE_DIR;
	private int DEDUCT_POINT;
	private String IMG_FILE_NAME;
	private String IMG_FILE_DIR;

	public int getMUSIC_NUM() {
		return MUSIC_NUM;
	}
	public int setMUSIC_NUM(int music_NUM) {
		 return MUSIC_NUM = music_NUM;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String Title) {
		TITLE = Title;
	}
	public String getARTIST() {
		return ARTIST;
	}
	public void setARTIST(String Artist) {
		ARTIST = Artist;
	}
	public String getMUSIC_FILE_NAME() {
		return MUSIC_FILE_NAME;
	}
	public void setMUSIC_FILE_NAME(String music_FILE_NAME) {
		MUSIC_FILE_NAME = music_FILE_NAME;
	}
	public String getMUSIC_FILE_DIR() {
		return MUSIC_FILE_DIR;
	}
	public void setMUSIC_FILE_DIR(String music_FILE_DIR) {
		MUSIC_FILE_DIR = music_FILE_DIR;
	}
	public int getDEDUCT_POINT() {
		return DEDUCT_POINT;
	}
	public void setDEDUCT_POINT(int deduct_POINT) {
		DEDUCT_POINT = deduct_POINT;
	}

	public String getIMG_FILE_NAME() {
		return IMG_FILE_NAME;
	}
	public void setIMG_FILE_NAME(String img_FILE_NAME) {
		IMG_FILE_NAME = img_FILE_NAME;
	}
	public String getIMG_FILE_DIR() {
		return IMG_FILE_DIR;
	}
	public void setIMG_FILE_DIR(String img_FILE_DIR) {
		IMG_FILE_DIR = img_FILE_DIR;
	}
	    
}