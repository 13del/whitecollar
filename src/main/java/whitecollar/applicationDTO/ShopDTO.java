package whitecollar.applicationDTO;

import com.google.gson.annotations.Expose;

import whitecollar.domain.Shop;

public class ShopDTO {
	
	@Expose
	public int shopID;
	@Expose
	public String shopName;
	@Expose
	public int maxCapacity;
	
	public ShopDTO(Shop shop) {
		this.shopID = shop.getShopID();
		this.shopName = shop.getShopName();
		this.maxCapacity = shop.getMaxCapacity();
	}

	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
