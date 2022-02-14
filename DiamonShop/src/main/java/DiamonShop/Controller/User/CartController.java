package DiamonShop.Controller.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entiy.Bills;
import DiamonShop.Entiy.User;
import DiamonShop.Service.User.BillsService;
import DiamonShop.Service.User.CartService;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartService cartService;

	@Autowired
	private BillsService billsService;

	// Add item Cart
	@SuppressWarnings("unchecked")
	@GetMapping(value = "addCart/{id}")
	public String addCart(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		Map<Integer, CartDto> mapCart = (Map<Integer, CartDto>) session.getAttribute("cart");
		if (mapCart == null) {
			mapCart = new HashMap<>();
		}
		cartService.addItemCart(id, mapCart);
		setSessionForCart(session, mapCart);
		return returnCurrentPage(request);
	}

	// Show Cart
	@GetMapping(value = "showCart")
	public ModelAndView showCart(HttpSession session) {
		baseModelAndView.addObject("slides", baseHomeService.getDataSlides());
		baseModelAndView.addObject("categories", baseHomeService.getDataCategories());
		baseModelAndView.addObject("products", baseHomeService.getDataProductsDto());
		baseModelAndView.setViewName("user/cart/list_cart");
		return baseModelAndView;
	}

	// Edit Cart
	@SuppressWarnings("unchecked")
	@GetMapping(value = "editCart/{id}/{quantity}")
	public String editCart(@PathVariable int id, @PathVariable int quantity, HttpSession session,
			HttpServletRequest request) {
		Map<Integer, CartDto> mapCart = (Map<Integer, CartDto>) session.getAttribute("cart");
		if (mapCart == null) {
			mapCart = new HashMap<>();
		}
		mapCart = cartService.editCart(id, quantity, mapCart);
		setSessionForCart(session, mapCart);
		return returnCurrentPage(request);
	}

	// Delete Cart
	@SuppressWarnings("unchecked")
	@GetMapping(value = "deleteCart/{id}")
	public String deleteCart(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		Map<Integer, CartDto> mapCart = (Map<Integer, CartDto>) session.getAttribute("cart");
		if (mapCart == null) {
			mapCart = new HashMap<>();
		}
		mapCart = cartService.removeCart(id, mapCart);
		setSessionForCart(session, mapCart);
		return returnCurrentPage(request);
	}

	private String returnCurrentPage(HttpServletRequest request) {
		return "redirect:" + request.getHeader("Referer");
	}

	private void setSessionForCart(HttpSession session, Map<Integer, CartDto> mapCart) {
		session.setAttribute("cart", mapCart);
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(mapCart));
		session.setAttribute("totalPriceCart", cartService.totalPrice(mapCart));
	}

	// Check info bills
	@GetMapping(value = "checkout")
	public ModelAndView checkout(HttpSession session, HttpServletRequest request) {
		baseModelAndView.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		User loginInfo = (User) session.getAttribute("loginInfo");
		if (loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setName(loginInfo.getName());
			bills.setEmail(loginInfo.getEmail());
		}
		baseModelAndView.addObject("bills", bills);
		return baseModelAndView;
	}

	// Pay cart
	@SuppressWarnings("unchecked")
	@PostMapping(value = "checkout")
	public String checkoutBill(@ModelAttribute("bills") Bills bills, HttpSession session,
			HttpServletRequest request) {
		bills.setQuantity(Integer.parseInt((String) session.getAttribute("totalQuantityCart")) );
		bills.setTotal(Double.parseDouble((String) session.getAttribute("totalPriceCart")));
		if (billsService.addBills(bills) > 0) {
			Map<Integer, CartDto> mapCart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
			billsService.addBillsDetail(mapCart);
		}
		session.removeAttribute("cart");
		return "redirect:showCart";
	}
}
