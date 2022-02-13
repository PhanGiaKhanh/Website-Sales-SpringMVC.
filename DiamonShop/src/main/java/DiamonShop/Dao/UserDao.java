package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entiy.User;

@Repository
public class UserDao extends BaseDao {

	public int addAcount(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append("email, ");
		sql.append("password, ");
		sql.append("name, ");
		sql.append("address ");
		sql.append(") ");
		sql.append("values ");
		sql.append("( ");
		sql.append("'" + user.getEmail() + "', ");
		sql.append("'" + user.getPassword() + "', ");
		sql.append("'" + user.getName() + "', ");
		sql.append("'" + user.getAddress() + "' ");
		sql.append(") ");
		return jdbcTemplate.update(sql.toString());
	}

}
