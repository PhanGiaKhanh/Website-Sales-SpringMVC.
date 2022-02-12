package DiamonShop.Service.User.UserImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.CategoriesService;

@Service
public class CategoriesImpl implements CategoriesService{
	@Autowired
	private ProductsDao productsDao;
	
	public List<ProductsDto> getAllProductsPaginate(int categoryId, int start, int end) {
		return productsDao.getAllProductsPaginate(categoryId, start, end);
	}

	public List<ProductsDto> getAllProductsByCategoryId(int categoryId) {
		return productsDao.getAllProductsByCategoryId(categoryId);
	}

}
