package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entiy.MapperMenus;
import DiamonShop.Entiy.Menus;

@Repository
public class MenusDao extends BaseDao{
	public List<Menus> getDataMenu(){
		List<Menus> menus = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		menus = jdbcTemplate.query(sql, new MapperMenus());
		return menus;
	}
}
