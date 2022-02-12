package DiamonShop.Service.User;

import java.util.HashMap;

import DiamonShop.Dto.CartDto;

public interface CartService {
	HashMap<Integer, CartDto> addItemCart(int id, HashMap<Integer, CartDto> cart);
	HashMap<Integer, CartDto> editCart(int id, int quantity, HashMap<Integer, CartDto> cart);
	HashMap<Integer, CartDto> removeCart(int id, HashMap<Integer, CartDto> cart);
	int totalQuantity(HashMap<Integer, CartDto> cart);
	double totalPrice(HashMap<Integer, CartDto> cart);
}
