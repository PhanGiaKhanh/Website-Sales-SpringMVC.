package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entiy.BillDetail;
import DiamonShop.Entiy.Bills;

@Repository
public class BillsDao extends BaseDao {

	public int addBills(Bills bills) {
		String sql = "INSERT INTO bills (`email`,`phone`,`name`,`address`,`total`,`quantity`,`note`) " 
				+ "VALUES ( "
				+ "'" + bills.getEmail() + "', " 
				+ "'" + bills.getPhone() + "', " 
				+ "'" + bills.getName() + "', " 
				+ "'" + bills.getAddress() + "', " 
				+ "'" + bills.getTotal() + "', " 
				+ "'" + bills.getQuantity() + "', " 
				+ "'" + bills.getNote() + "' "
				+ ");";
		return jdbcTemplate.update(sql);
	}

	@SuppressWarnings("deprecation")
	public int getIdLastBills() {
		String sql = "SELECT MAX(id) FROM bills;";
//		queryForObject(sql, new Object[] {}, Integer.class)
		return jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
	}

	
	public int addBillsDetails(BillDetail billDetail) {
		String sql = "INSERT INTO billDetail (`product_id`,`bills_id`,`quantity`,`total`) " 
				+ "VALUES ( "
				+ "'" + billDetail.getProductId() + "', " 
				+ "'" + billDetail.getBillId() + "', " 
				+ "'" + billDetail.getQuantity() + "', " 
				+ "'" + billDetail.getTotal() + "'" 
				+ ");";
		return jdbcTemplate.update(sql);
	}

}
