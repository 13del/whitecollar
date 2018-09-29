package whitecollar.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import whitecollar.application.ShopController;
import whitecollar.applicationDTO.ShopDTO;

@CrossOrigin
@RestController
public class ShopRestController {
	
	private ShopController controller= new ShopController();

	//Crear botiga: li direm el nom i la capacitat POST /shops/
	@PostMapping(value = "/shops", produces = "application/json;charset=UTF-8")
	public String addShop(@RequestBody String jShop) throws Exception {

		ShopDTO newShop = new Gson().fromJson(jShop, ShopDTO.class);

		ShopDTO shop = controller.addShop(newShop);

		return toJson(shop);
	}
	private String toJson(Object object){
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	
	//Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat GET /shops/
	@GetMapping(value = "/shops", produces = "application/json;charset=UTF-8")
	public String listShops() throws Exception {

		List<ShopDTO> shops = controller.listShops();

		return toJson(shops);
	}
	@DeleteMapping(value = "/shops/{shopID}/pictures",produces = "application/json;charset=UTF-8")
	public void burnAllPictures(@PathVariable int shopID) throws Exception {
		controller.burnPicturesByShopID(shopID);
	}
	
}
