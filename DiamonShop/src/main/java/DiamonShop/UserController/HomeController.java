package DiamonShop.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dao.HomeDao;
import DiamonShop.Entiy.Slides;

@Controller
public class HomeController {
	@Autowired
	HomeDao homeDao;
	
	@GetMapping(value = {"", "/home"})
	public ModelAndView index() {
		List<Slides> slides = homeDao.getDataSlides();
		for (int i = 0; i < slides.size(); i++) {
			System.out.println(slides.get(i).toString());
		}
		
		return new ModelAndView("user/index");
	}
	
	@GetMapping(value = "product")
	public ModelAndView product() {
		return new ModelAndView("user/product");
	}
}
