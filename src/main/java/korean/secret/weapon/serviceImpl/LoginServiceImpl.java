package korean.secret.weapon.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import korean.secret.weapon.service.LoginService;
import korean.secret.weapon.dao.CommonDao;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CommonDao CommonDao;
	
	public String loginCheck(Map<String,Object> param) throws Exception {
		
		String rtMessage; 
		String psw = CommonDao.one("login.user_check",param);
		
		if(psw==null){
			rtMessage = "Invalid E-Mail";
		}else if(!param.get("password").equals(psw)){
			rtMessage = "Invalid Password";
		}else{
			rtMessage = "success";
		}
		
		return rtMessage;
		
	}    
}
