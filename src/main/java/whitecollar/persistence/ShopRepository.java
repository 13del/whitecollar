package whitecollar.persistence;

import java.util.ArrayList;
import java.util.List;

import whitecollar.domain.Shop;


public class ShopRepository {
	
	private static List<Shop> shops=new ArrayList<>();
	
	public ShopRepository(){		
	}
	
	public void addShop(Shop shop) throws Exception{
		if(shop==null) throw new Exception();
		shops.add(shop);
	}	
	
	public List<Shop> getAllShops(){
		return new ArrayList<>(shops);
	}
	
	public Shop getShopById(int shopID) throws Exception {
		for (Shop shop : shops) {
			if(shop.getShopID() == shopID) {
				return shop;
			} 
		}
		throw new Exception();
	}
}
	
