package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.ProductService;

@Controller
public class ProductController extends BaseController {
	@Autowired
	ProductService productService;
	
	@GetMapping(value = { "chi-tiet-san-pham/{id}"})
	public ModelAndView index(@PathVariable int id) {
		baseModelAndView.setViewName("user/products/product");
		ProductsDto productsDto = productService.getProductById(id);
		baseModelAndView.addObject("product", productsDto);
		baseModelAndView.addObject("productsByCategoryId", productService.getProductByCategoryId(productsDto.getCategoryId()));
		return baseModelAndView;
	}
}
