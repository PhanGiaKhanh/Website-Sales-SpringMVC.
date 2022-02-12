package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	ProductsDao productsDao;

	public ProductsDto getProductById(int id) {
		return productsDao.getProductById(id).get(0);
	}

	public List<ProductsDto> getProductByCategoryId(int categoryId) {
		return productsDao.getAllProductsByCategoryId(categoryId);
	}
	
}
