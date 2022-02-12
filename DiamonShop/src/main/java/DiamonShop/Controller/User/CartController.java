package DiamonShop.Controller.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import DiamonShop.Dto.CartDto;
import DiamonShop.Service.User.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping(value = "addCart/{id}")
	public String addCart(@PathVariable int id, HttpSession session) {
		Map<Integer, CartDto> mapCart = (Map<Integer, CartDto>) session.getAttribute("Cart");
		if (mapCart == null) {
			mapCart = new HashMap<>();
		}
		cartService.addItemCart(id, mapCart);
		session.setAttribute("cart", mapCart);
		return "redirect:/chi-tiet-san-pham/" + id;
	}
}
