package korean.secret.weapon.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import korean.secret.weapon.service.CommonService;
import korean.secret.weapon.dao.CommonDao;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao CommonDao;

	public List<Map<String,Object>> select(String sqlId) throws Exception {
		return CommonDao.select(sqlId);
	}
    
}
