package DiamonShop.Service.User.UserImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.ProductService;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	ProductsDao productsDao;

	public ProductsDto getProductById(int id) {
		return productsDao.getProductsById(id).get(0);
	}

	public List<ProductsDto> getProductByCategoryId(int categoryId) {
		return productsDao.getAllProductsByCategoryId(categoryId);
	}
	
}
