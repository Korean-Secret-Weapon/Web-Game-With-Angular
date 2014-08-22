package korean.secret.weapon.dao;
 
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class CommonDao {
 
    @Autowired
    private SqlSessionTemplate sqlSession;
    
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> select(String sqlId){
        return (List<Map<String,Object>>) sqlSession.selectList(sqlId);
    }
}