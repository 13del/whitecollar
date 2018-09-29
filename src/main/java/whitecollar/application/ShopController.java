package whitecollar.application;

import java.util.ArrayList;
import java.util.List;

import whitecollar.utilities.NotFoundException;
import whitecollar.applicationDTO.PictureDTO;
import whitecollar.applicationDTO.ShopDTO;
import whitecollar.domain.Shop;
import whitecollar.persistence.ShopRepository;

public class ShopController {
	
	private ShopRepository shoprepository= new ShopRepository();
	
	//Crear botiga: li direm el nom i la capacitat POST /shops/  
	public ShopDTO addShop (ShopDTO shopDTO) throws Exception{
		Shop shop = new Shop(shopDTO.shopID, shopDTO.getShopName(), shopDTO.getMaxCapacity());
		shoprepository.addShop(shop);
		return new ShopDTO(shop);
	}
	// Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat GET /shops/  
	public List<ShopDTO> listShops() throws NotFoundException {
		List<Shop> shopList = shoprepository.getAllShops();
		List<ShopDTO> userDTOList = new ArrayList<>();

		if (shopList.isEmpty())
			throw new NotFoundException();
		for (Shop u : shopList) {
			userDTOList.add(new ShopDTO(u));
		}
		return userDTOList;
	}

	public void burnPicturesByShopID(int shopID) throws Exception {
		Shop shop = shoprepository.getShopById(shopID);
		shop.burnPictures();				
	}
}
