package DiamonShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDtoMapper implements RowMapper<ProductsDto>{

	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto products = new ProductsDto();
		products.setProductId(rs.getInt("product_id"));
		products.setCategoryId(rs.getInt("category_id"));
		products.setSizes(rs.getString("sizes"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setSale(rs.getInt("sale"));
		products.setTitle(rs.getString("title"));
		products.setHighlight(rs.getBoolean("highlight"));
		products.setProductNew(rs.getBoolean("product_new"));
		products.setDetails(rs.getString("details"));
		products.setColorId(rs.getInt("color_id"));
		products.setColorName(rs.getString("color_name"));
		products.setColorCode(rs.getString("color_code"));
		products.setImg(rs.getString("img"));
		products.setCreatedAt(rs.getDate("created_at"));
		products.setUpdatedAt(rs.getDate("updated_at"));
		return products;
	}

}
