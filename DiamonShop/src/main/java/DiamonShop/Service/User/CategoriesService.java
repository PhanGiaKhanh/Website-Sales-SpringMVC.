package DiamonShop.Service.User;

import java.util.List;

import DiamonShop.Dto.ProductsDto;

public interface CategoriesService {
	List<ProductsDto> getAllProductsPaginate(int categoryId, int start, int totalPage);
	List<ProductsDto> getAllProductsByCategoryId(int categoryId);
}
