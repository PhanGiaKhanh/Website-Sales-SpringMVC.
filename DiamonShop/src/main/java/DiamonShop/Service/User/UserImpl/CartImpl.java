package DiamonShop.Service.User.UserImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CartDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Service.User.CartService;

@Service
public class CartImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	public Map<Integer, CartDto> addItemCart(int id, Map<Integer, CartDto> cart) {
		return cartDao.addItemCart(id, cart);
	}

	public Map<Integer, CartDto> editCart(int id, int quantity, Map<Integer, CartDto> cart) {
		return cartDao.editCart(id, quantity, cart);
	}

	public Map<Integer, CartDto> removeCart(int id, Map<Integer, CartDto> cart) {
		return cartDao.removeCart(id, cart);
	}

	public int totalQuantity(Map<Integer, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	public double totalPrice(Map<Integer, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}

}
