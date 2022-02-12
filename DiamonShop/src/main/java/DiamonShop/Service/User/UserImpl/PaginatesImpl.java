package DiamonShop.Service.User.UserImpl;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.PaginatesService;

@Service
public class PaginatesImpl implements PaginatesService {

	public PaginatesDto getInfoPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto();
		paginatesDto.setTotalPage(setInfoTotalPage(totalData, limit));
		paginatesDto.setLimit(limit);
		paginatesDto.setCurrentPage(checkCurrentPage(currentPage, paginatesDto.getTotalPage()));
		int start = findStart(paginatesDto.getCurrentPage(), limit);
		paginatesDto.setStart(start);
		int end = findEnd(paginatesDto.getStart(), limit, totalData);
		paginatesDto.setEnd(end);
		return paginatesDto;
	}

	private int findEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}

	private int findStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}

	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}

	private int checkCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}

}
