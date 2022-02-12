package DiamonShop.Service.User;

import DiamonShop.Dto.PaginatesDto;

public interface PaginatesService {
	PaginatesDto getInfoPaginates(int totalData, int limit, int currentPage);
}
