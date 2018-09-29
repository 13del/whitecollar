package whitecollar.applicationDTO;

import com.google.gson.annotations.Expose;

import whitecollar.domain.Picture;

public class PictureDTO {
	@Expose
	public int pictureID;
	@Expose
	public String authorName;
	@Expose
	public String pictureName;

	public PictureDTO(Picture picture) {
		this.pictureID = picture.getPictureID();
		this.authorName = picture.getAuthorName();
		this.pictureName = picture.getPictureName();
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
