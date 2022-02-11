package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;
	
	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as product_id, ");
		sql.append("p.category_id, ");
		sql.append("p.sizes, ");
		sql.append("p.name, ");
		sql.append("p.price, ");
		sql.append("p.sale, ");
		sql.append("p.title, ");
		sql.append("p.highlight, ");
		sql.append("p.product_new, ");
		sql.append("p.details, ");
		sql.append("c.id as color_id, ");
		sql.append("c.name as color_name, ");
		sql.append("c.code as color_code, ");
		sql.append("c.img, ");
		sql.append("p.created_at, ");
		sql.append("p.updated_at ");
		sql.append("FROM products AS p ");
		sql.append("JOIN colors AS c ON p.id = c.product_id ");
		return sql;
	}
	
	private String sqlNewAndHilightProduct(boolean newProdut, boolean highlight) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		if (newProdut) {
			sql.append("AND p.highlight = true ");
		}
		if (highlight) {
			sql.append("AND p.product_new = true ");
		}
		sql.append("GROUP BY p.id, c.product_id ");
		sql.append("ORDER BY RAND() ");
		if (newProdut) {
			sql.append("LIMIT 12 ");
		}
		if (highlight) {
			sql.append("LIMIT 9 ");
		}
		return sql.toString();
	}
	public List<ProductsDto> getDataProductsDto() {
		List<ProductsDto> productsDtos = new ArrayList<ProductsDto>();
		String sql = sqlNewAndHilightProduct(NO, YES);
		productsDtos = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return productsDtos;
	}
	
	public List<ProductsDto> getDataNewProductsDto() {
		List<ProductsDto> productsDtos = new ArrayList<ProductsDto>();
		String sql = sqlNewAndHilightProduct(YES, NO);
		productsDtos = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return productsDtos;
	}
}
