package DiamonShop.Service.User;

import java.util.List;

import DiamonShop.Entiy.Categories;
import DiamonShop.Entiy.Menus;
import DiamonShop.Entiy.Slides;

public interface HomeService {
	List<Slides> getDataSlides();

	List<Categories> getDataCategories();

	List<Menus> getDataMenus();
}
