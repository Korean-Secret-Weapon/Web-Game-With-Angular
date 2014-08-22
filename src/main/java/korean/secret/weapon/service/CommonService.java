package korean.secret.weapon.service;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
 
/**
 * Handles requests for the application home page.
 */
@Service
public interface CommonService {
 
    public List<Map<String,Object>> select(String sqlId) throws Exception;
          
}