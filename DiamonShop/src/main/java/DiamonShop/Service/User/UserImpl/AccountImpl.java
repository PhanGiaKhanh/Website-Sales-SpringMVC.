package DiamonShop.Service.User.UserImpl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UserDao;
import DiamonShop.Entiy.User;
import DiamonShop.Service.User.AccountService;

@Service
public class AccountImpl implements AccountService {
	@Autowired
	UserDao userDao;
	
	// add Account and hash password
	@Override
	public int addAccount(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );
		return userDao.addAcount(user);
	}

}
