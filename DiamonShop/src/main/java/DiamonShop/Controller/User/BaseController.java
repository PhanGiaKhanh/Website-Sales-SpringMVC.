package DiamonShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeService;

@Controller
public class BaseController {
	@Autowired
	HomeService baseHomeService;
	
	public ModelAndView baseModelAndView = new ModelAndView();
	
	@PostConstruct
	public ModelAndView init() {
		baseModelAndView.addObject("menus", baseHomeService.getDataMenus());
		return baseModelAndView;
	}
}
