package DiamonShop.Dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	// add product in Cart
	public CartDto addItemCart(int id, Map<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto productsDto = productsDao.findProductById(id);
		if (productsDto != null) {
			itemCart.setProductsDto(productsDto);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(productsDto.getPrice());
		}
		cart.put(id, itemCart);
		return itemCart;
	}

	// update product in Cart
	public Map<Integer, CartDto> editCart(int id, int quantity, Map<Integer, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProductsDto().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	// reomve product in Cart
	public Map<Integer, CartDto> removeCart(int id, Map<Integer, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	// get total quantity
	public int totalQuantity(Map<Integer, CartDto> cart) {
		int totalQuantity = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	// get total price
	public double totalPrice(Map<Integer, CartDto> cart) {
		double totalPrice = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
