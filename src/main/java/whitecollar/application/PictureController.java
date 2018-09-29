package whitecollar.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import whitecollar.applicationDTO.PictureDTO;
import whitecollar.domain.Picture;
import whitecollar.domain.Shop;
import whitecollar.persistence.ShopRepository;

@Controller
public class PictureController {
	
	private ShopRepository shoprepository = new ShopRepository();

	//afegir cuadre, li donarem nom de cuadre i d'autor POST /shops/{ID}/pictures
	public PictureDTO addPicture (int shopID, PictureDTO pictureDTO) throws Exception{
		Picture picture = new Picture(pictureDTO.getPictureID(), pictureDTO.getAuthorName(), pictureDTO.getPictureName());
		Shop s = shoprepository.getShopById(shopID);
		s.addPictures(picture);
		return new PictureDTO(picture);
	}	
	
	//Llistar els quadres de la botiga GET /shops/{ID}/pictures
	public List<PictureDTO> getAllPictures(int shopID) throws Exception{
		Shop shop = shoprepository.getShopById(shopID);
		List<PictureDTO> pictures = new ArrayList<>();
		for(Picture p : shop.getAllPictures()) {
			pictures.add(new PictureDTO(p));
		}
		return pictures;
	}
}
