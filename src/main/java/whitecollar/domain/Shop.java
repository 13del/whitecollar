package whitecollar.domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	
	protected int shopID;
	protected String shopName;
	protected int maxCapacity;
	protected List <Picture> allPictures = new ArrayList<Picture>();
	private static int counter=1;
		
	public Shop(int shopID, String shopName, int maxCapacity) throws Exception {
		if (shopName.equals(" ")) throw new Exception();
		if (maxCapacity == 0) throw new Exception();
		this.shopID = counter;
		this.shopName = shopName;
		this.maxCapacity = maxCapacity;
		counter++;
	}
	
	public int getShopID() {
		return shopID;
	}

	public String getShopName() {
		return shopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public List<Picture> getAllPictures() {
		return new ArrayList<>(allPictures);
	}
	
	public void addPictures(Picture picture) throws Exception {	
		if (this.maxCapacity==this.allPictures.size()) {
			throw new Exception();
		}
		allPictures.add(picture);		
	}
		
	public void burnPictures() {
		this.allPictures.removeAll(allPictures);
	}
}
