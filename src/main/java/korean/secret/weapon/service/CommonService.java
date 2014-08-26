package korean.secret.weapon.service;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
 
@Service
public interface CommonService {
 
    public List<Map<String,Object>> list(String sqlId,Map<String,Object> param) throws Exception;

    public Map<String,Object> map(String sqlId,Map<String,Object> param) throws Exception;
    
    public String one(String sqlId,Map<String,Object> param) throws Exception;
    
    public void save(String sqlId,List<Map<String,Object>> param) throws Exception;
    
    public void update(String sqlId,Map<String,Object> param) throws Exception;
    
    public void delete(String sqlId,Map<String,Object> param) throws Exception;
    
    public void insert(String sqlId,Map<String,Object> param) throws Exception;
}