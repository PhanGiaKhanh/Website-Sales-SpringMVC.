package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.SlidesDao;
import DiamonShop.Entiy.Slides;

@Service
public class HomeImpl implements HomeService{
	@Autowired 
	private SlidesDao slidesDao;
	
	public List<Slides> getDataSlides() {
		return slidesDao.getDataSlides();
	}

}
