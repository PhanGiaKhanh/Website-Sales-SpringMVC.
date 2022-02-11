package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
	@GetMapping(value= "/product") 
	public ModelAndView showProduct() {
		ModelAndView mv = new ModelAndView("user/category");
		return mv;
	}
}
