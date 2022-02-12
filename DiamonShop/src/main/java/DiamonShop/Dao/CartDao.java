package DiamonShop.Dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	// add product in Cart
	public HashMap<Integer, CartDto> addItemCart(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto productsDto = productsDao.findProductById(id);
		if (productsDto != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProductsDto().getPrice());
		} else if (productsDto != null && !cart.containsKey(id)) {
			itemCart.setProductsDto(productsDto);
			itemCart.setQuantity(1);
			double price = productsDto.getPrice();
			itemCart.setTotalPrice(price);
		}
		cart.put(id, itemCart);
		return cart;
	}

	// update product in Cart
	public HashMap<Integer, CartDto> editCart(int id, int quantity, HashMap<Integer, CartDto> cart) {
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
	public HashMap<Integer, CartDto> removeCart(int id, HashMap<Integer, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	// get total quantity
	public int totalQuantity(HashMap<Integer, CartDto> cart) {
		int totalQuantity = 0;
		for (HashMap.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	// get total price
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		double totalPrice = 0;
		for (HashMap.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
