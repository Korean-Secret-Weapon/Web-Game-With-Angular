package korean.secret.weapon.service;

import java.util.Map;

import org.springframework.stereotype.Service;
 
@Service
public interface LoginService {
    
    public String loginCheck(Map<String,Object> param) throws Exception;
    
}