package DiamonShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dao.SlidesDao;
import DiamonShop.Entiy.Slides;
import DiamonShop.Service.User.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService homeService;
	
	@GetMapping(value = {"", "/home"})
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView("user/index");
		mv.addObject("slides", homeService.getDataSlides());
		return mv;
	}
	
	@GetMapping(value = "product")
	public ModelAndView product() {
		return new ModelAndView("user/product");
	}
}
