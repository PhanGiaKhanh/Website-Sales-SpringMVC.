package DiamonShop.Service.User.UserImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillsDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Entiy.BillDetail;
import DiamonShop.Entiy.Bills;
import DiamonShop.Service.User.BillsService;

@Service
public class BillsImpl implements BillsService {
	@Autowired
	private BillsDao billsDao;
	
	public int addBills(Bills bills) {
		return billsDao.addBills(bills);
	}

	public void addBillsDetail(Map<Integer, CartDto> mapCart) {
		int idBills = billsDao.getIdLastBills();
		
		for (Map.Entry<Integer, CartDto> itemCart : mapCart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setBillId(idBills);
			billDetail.setProductId(itemCart.getValue().getProductsDto().getProductId());
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.addBillsDetails(billDetail);
		}
	}

}
