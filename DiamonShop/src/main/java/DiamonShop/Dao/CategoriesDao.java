package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entiy.Categories;
import DiamonShop.Entiy.MapperCategories;

@Repository
public class CategoriesDao extends BaseDao {
	public List<Categories> getDataCategories() {
		List<Categories> slides = new ArrayList<Categories>();
		String sql = "SELECT * FROM categories";
		slides = jdbcTemplate.query(sql, new MapperCategories());
		return slides;
	}
}
