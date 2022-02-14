package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entiy.User;
import DiamonShop.Service.User.AccountService;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountService accountService;

	// show register
	@GetMapping(value = { "/dang-ky" })
	public ModelAndView showRegister() {
		baseModelAndView.setViewName("user/account/register");
		baseModelAndView.addObject("categories", baseHomeService.getDataCategories());
		baseModelAndView.addObject("user", new User());
		return baseModelAndView;
	}

	// create user
	@PostMapping(value = { "/dang-ky" })
	public ModelAndView createRegister(@ModelAttribute(name = "user") User user) {
		baseModelAndView.setViewName("user/account/register");
		baseModelAndView.addObject("categories", baseHomeService.getDataCategories());
		int count = accountService.addAccount(user);
		if (count > 0) {
			baseModelAndView.addObject("status", "Đăng ký tài khoản thành công");
		} else {
			baseModelAndView.addObject("status", "Đăng ký tài khoản thất bại");
		}
		return baseModelAndView;
	}

	// Login user
	@PostMapping(value = { "/dang-nhap" })
	public ModelAndView loginUser(@ModelAttribute(name = "user") User user, HttpSession session) {
		baseModelAndView.setViewName("user/account/register");
		baseModelAndView.addObject("categories", baseHomeService.getDataCategories());
		user = accountService.checkAccount(user);
		if (user != null) {
			baseModelAndView.setViewName("redirect:home");
			session.setAttribute("loginInfo", user);
		} else {
			baseModelAndView.addObject("statusLogin", "Đăng nhập thất bại");
		}
		return baseModelAndView;
	}

	// Login user
	@PostMapping(value = { "/dang-xuat" })
	public String logOutUser(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("loginInfo");
		return "redrect:" + request.getHeader("Referer");
	}
}
