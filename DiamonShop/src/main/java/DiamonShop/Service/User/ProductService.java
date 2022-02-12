package DiamonShop.Service.User;

import java.util.List;

import DiamonShop.Dto.ProductsDto;

public interface ProductService {
	ProductsDto getProductById(int id);
	List<ProductsDto> getProductByCategoryId(int categoryId);
}
