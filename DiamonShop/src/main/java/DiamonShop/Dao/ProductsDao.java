package DiamonShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;

	// create query search base product
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

	// create query search product by new product or highlight
	private String sqlNewAndHilightProduct(boolean newProduct, boolean highlight) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		if (newProduct) {
			sql.append("AND p.highlight = true ");
		}
		if (highlight) {
			sql.append("AND p.product_new = true ");
		}
		sql.append("GROUP BY p.id, c.product_id ");
		sql.append("ORDER BY RAND() ");
		if (newProduct) {
			sql.append("LIMIT 12 ");
		}
		if (highlight) {
			sql.append("LIMIT 9 ");
		}
		return sql.toString();
	}

	// create query search product by categoryId
	private StringBuffer sqlProductByCateogyId(int categoryId) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("And category_id = " + categoryId + " ");
		return sql;
	}

	// create query search product by categoryId
	private String sqlProductByCateogyId(int categoryId, int start, int totalPage) {
		StringBuffer sql = sqlProductByCateogyId(categoryId);
		sql.append("LIMIT " + start + ", " + totalPage + " ");
		return sql.toString();
	}

	// get all data product
	public List<ProductsDto> getDataProductsDto() {
		String sql = sqlNewAndHilightProduct(NO, YES);
		return jdbcTemplate.query(sql, new ProductsDtoMapper());
	}

	// get all data new product
	public List<ProductsDto> getDataNewProductsDto() {
		String sql = sqlNewAndHilightProduct(YES, NO);
		return jdbcTemplate.query(sql, new ProductsDtoMapper());
	}

	// get all data product by categoryId
	public List<ProductsDto> getAllProductsByCategoryId(int categoryId) {
		String sql = sqlProductByCateogyId(categoryId).toString();
		return jdbcTemplate.query(sql, new ProductsDtoMapper());
	}

	// get all data product and paginates
	public List<ProductsDto> getAllProductsPaginate(int categoryId, int start, int totalPage) {
		try {
			String sql = sqlProductByCateogyId(categoryId, start, totalPage);
			return jdbcTemplate.query(sql, new ProductsDtoMapper());
		} catch (Exception e) {
			return null;
		}
		
	}
}
