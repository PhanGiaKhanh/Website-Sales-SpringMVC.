package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CategoriesDao;
import DiamonShop.Dao.MenusDao;
import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dao.SlidesDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entiy.Categories;
import DiamonShop.Entiy.Menus;
import DiamonShop.Entiy.Slides;

@Service
public class HomeImpl implements HomeService {
	@Autowired
	private SlidesDao slidesDao;

	@Autowired
	private CategoriesDao categoriesDao;

	@Autowired 
	private MenusDao menusDao;
	
	@Autowired 
	private ProductsDao productsDao;

	public List<Slides> getDataSlides() {
		return slidesDao.getDataSlides();
	}

	public List<Categories> getDataCategories() {
		return categoriesDao.getDataCategories();
	}

	public List<Menus> getDataMenus() {
		return menusDao.getDataMenu();
	}

	public List<ProductsDto> getDataProductsDto() {
		return productsDao.getDataProductsDto();
	}

	public List<ProductsDto> getDataNewProductsDto() {
		return productsDao.getDataNewProductsDto();
	}

}
