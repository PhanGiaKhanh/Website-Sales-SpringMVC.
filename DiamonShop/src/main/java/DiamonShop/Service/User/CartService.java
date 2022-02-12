package DiamonShop.Service.User;

import java.util.Map;

import DiamonShop.Dto.CartDto;

public interface CartService {
	CartDto addItemCart(int id, Map<Integer, CartDto> cart);
	Map<Integer, CartDto> editCart(int id, int quantity, Map<Integer, CartDto> cart);
	Map<Integer, CartDto> removeCart(int id, Map<Integer, CartDto> cart);
	int totalQuantity(Map<Integer, CartDto> cart);
	double totalPrice(Map<Integer, CartDto> cart);
}
