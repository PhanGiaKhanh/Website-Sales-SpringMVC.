package DiamonShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.CategoriesService;
import DiamonShop.Service.User.PaginatesService;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private PaginatesService paginatesService;

	private int totalPage = 9;

	@GetMapping(value = "/product/{id}")
	public ModelAndView showProduct(@PathVariable Integer id) {

		baseModelAndView.setViewName("user/products/category");
		List<ProductsDto> productsDto = categoriesService.getAllProductsByCategoryId(id);
		baseModelAndView.addObject("productsByCategory", productsDto);
		baseModelAndView.addObject("categoryId", id);
		int totalData = productsDto.size();
		PaginatesDto paginatesDto = paginatesService.getInfoPaginates(totalData, totalPage, 1);
		baseModelAndView.addObject("productsPaginate",
				categoriesService.getAllProductsPaginate(id, paginatesDto.getStart(), totalPage));
		baseModelAndView.addObject("paginateInfo", paginatesDto);
		return baseModelAndView;
	}

	@GetMapping(value = "/product/{id}/{currentPage}")
	public ModelAndView showProduct1(@PathVariable Integer id, @PathVariable Integer currentPage) {
		baseModelAndView.setViewName("user/products/category");
		List<ProductsDto> productsDto = categoriesService.getAllProductsByCategoryId(id);
		baseModelAndView.addObject("productsByCategory", productsDto);
		baseModelAndView.addObject("categoryId", id);
		int totalData = productsDto.size();
		PaginatesDto paginatesDto = paginatesService.getInfoPaginates(totalData, totalPage, currentPage);
		baseModelAndView.addObject("productsPaginate",
				categoriesService.getAllProductsPaginate(id, paginatesDto.getStart(), totalPage));
		baseModelAndView.addObject("paginateInfo", paginatesDto);
		return baseModelAndView;
	}
}
