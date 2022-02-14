package DiamonShop.Service.User;

import java.util.Map;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entiy.Bills;

public interface BillsService {
	int addBills(Bills bills);

	void addBillsDetail(Map<Integer, CartDto> mapCart);
}
