package DiamonShop.Service.User.UserImpl;

import java.util.HashMap;

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
	public HashMap<Integer, CartDto> addItemCart(int id, HashMap<Integer, CartDto> cart) {
		return cartDao.addItemCart(id, cart);
	}

	@Override
	public HashMap<Integer, CartDto> editCart(int id, int quantity, HashMap<Integer, CartDto> cart) {
		return cartDao.editCart(id, quantity, cart);
	}

	@Override
	public HashMap<Integer, CartDto> removeCart(int id, HashMap<Integer, CartDto> cart) {
		return cartDao.removeCart(id, cart);
	}

	@Override
	public int totalQuantity(HashMap<Integer, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	@Override
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}

}
