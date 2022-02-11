package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	@GetMapping(value = { "", "/home" })
	public ModelAndView index() {
		baseModelAndView.addObject("slides", baseHomeService.getDataSlides());
		baseModelAndView.addObject("categories", baseHomeService.getDataCategories());
		baseModelAndView.setViewName("user/index");
		return baseModelAndView;
	}

	@GetMapping(value = "product")
	public ModelAndView product() {
		return new ModelAndView("user/product");
	}
}
