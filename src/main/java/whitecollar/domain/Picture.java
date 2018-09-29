package whitecollar.domain;

import java.util.Date;

public class Picture {
	
	protected int pictureID;
	protected String authorName;
	protected String pictureName;
//	protected double picturePrice;
//	protected Date pictureEntryDate;
	private static int counter=1;

	public Picture(int pictureID, String authorName, String pictureName) throws Exception {
		if (pictureName.equals(" ")) throw new Exception ();
		this.pictureID = counter;
		this.authorName = authorName;
		this.pictureName = pictureName;
		counter++;
	}

	public int getPictureID() {
		return pictureID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getPictureName() {
		return pictureName;
	}
}
