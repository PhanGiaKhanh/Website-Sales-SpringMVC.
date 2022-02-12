package DiamonShop.Dto;

public class CartDto {
	private int quantity;
	private double totalPrice;
	private ProductsDto productsDto;

	public CartDto() {
	}

	public CartDto(int quantity, double totalPrice, ProductsDto productsDto) {
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productsDto = productsDto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductsDto getProductsDto() {
		return productsDto;
	}

	public void setProductsDto(ProductsDto productsDto) {
		this.productsDto = productsDto;
	}

}
