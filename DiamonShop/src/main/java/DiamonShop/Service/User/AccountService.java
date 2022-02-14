package DiamonShop.Service.User;

import DiamonShop.Entiy.User;

public interface AccountService {
	int addAccount(User user);
	User checkAccount(User user);
}
