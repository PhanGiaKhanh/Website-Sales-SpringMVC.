package DiamonShop.Controller.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "addCart/{id}")
	public String addCart(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		Map<Integer, CartDto> mapCart = (Map<Integer, CartDto>) session.getAttribute("cart");
		if (mapCart == null) {
			mapCart = new HashMap<>();
		}
		cartService.addItemCart(id, mapCart);
		session.setAttribute("cart", mapCart);
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(mapCart));
		session.setAttribute("totalPriceCart", cartService.totalPrice(mapCart));
		return "redirect:" + request.getHeader("Referer");
	}
}
