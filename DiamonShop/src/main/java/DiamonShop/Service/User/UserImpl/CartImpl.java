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

	@Override
	public CartDto addItemCart(int id, Map<Integer, CartDto> cart) {
		return cartDao.addItemCart(id, cart);
	}

	@Override
	public Map<Integer, CartDto> editCart(int id, int quantity, Map<Integer, CartDto> cart) {
		return cartDao.editCart(id, quantity, cart);
	}

	@Override
	public Map<Integer, CartDto> removeCart(int id, Map<Integer, CartDto> cart) {
		return cartDao.removeCart(id, cart);
	}

	@Override
	public int totalQuantity(Map<Integer, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	@Override
	public double totalPrice(Map<Integer, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}

}
