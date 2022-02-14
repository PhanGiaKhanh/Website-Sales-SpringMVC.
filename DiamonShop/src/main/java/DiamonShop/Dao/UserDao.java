package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entiy.MapperUser;
import DiamonShop.Entiy.User;

@Repository
public class UserDao extends BaseDao {

	public int addAcount(User user) {
		String sql = "INSERT  INO users (email, password, name, address )"
		+ "values "
		+ "( "
		+ "'" + user.getEmail() + "', "
		+ "'" + user.getPassword() + "', "
		+ "'" + user.getName() + "', "
		+ "'" + user.getAddress() + "' "
		+ ") ";
		return jdbcTemplate.update(sql);
	}
	public User findUserByAcount(User user) {
		String sql = "SELECT * FROM users WHERE email = '" + user.getEmail() + "'";
		return jdbcTemplate.queryForObject(sql, new MapperUser());
	}

}
