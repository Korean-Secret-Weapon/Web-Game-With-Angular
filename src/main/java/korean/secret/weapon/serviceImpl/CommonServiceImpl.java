package korean.secret.weapon.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import korean.secret.weapon.service.CommonService;
import korean.secret.weapon.dao.CommonDao;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao CommonDao;

	public List<Map<String,Object>> list(String sqlId,Map<String,Object> param) throws Exception {
		return CommonDao.list(sqlId,param);
	}
	
	public Map<String,Object> map(String sqlId,Map<String,Object> param) throws Exception {
		return CommonDao.map(sqlId,param);
	}
	
	public String one(String sqlId,Map<String,Object> param) throws Exception {
		return CommonDao.one(sqlId,param);
	}
	
	@Transactional
	public void save(String sqlId,List<Map<String,Object>> param) throws Exception {
    	for(Map<String,Object> dMap : param){
    		if(dMap.get("status").equals("I")){
    			CommonDao.insert(dMap,sqlId);
    		}else if(dMap.get("status").equals("D")){
    			CommonDao.delete(dMap,sqlId);
    		}else if(dMap.get("status").equals("U")){
    			CommonDao.update(dMap,sqlId);
    		}
    	}
    }
	
	public void update(String sqlId,Map<String,Object> param) throws Exception {
		CommonDao.update(param,sqlId);
	}
	
	public void delete(String sqlId,Map<String,Object> param) throws Exception {
		CommonDao.delete(param,sqlId);
	}
	
	public void insert(String sqlId,Map<String,Object> param) throws Exception {
		CommonDao.insert(param,sqlId);
	}
    
}
