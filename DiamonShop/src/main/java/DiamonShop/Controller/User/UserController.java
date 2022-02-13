package DiamonShop.Controller.User;

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
		baseModelAndView.addObject("user", new User());
		return baseModelAndView;
	}

	// create user
	@PostMapping(value = { "/dang-ky" })
	public ModelAndView createRegister(@ModelAttribute(name = "user") User user) {
		baseModelAndView.setViewName("user/account/register");
		int count = accountService.addAccount(user);
		if (count > 0) {
			addStatus("Đăng ký tài khoản thành công");
		} else {
			addStatus("Đăng ký tài khoản thất bại");
		}
		return baseModelAndView;
	}

	private void addStatus(String message) {
		baseModelAndView.addObject("status", message);
	}
}
