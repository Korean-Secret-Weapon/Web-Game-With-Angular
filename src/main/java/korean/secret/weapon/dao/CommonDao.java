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
    
	public List<Map<String,Object>> list(String sqlId,Map<String,Object> param){
        return (List<Map<String,Object>>) sqlSession.selectList(sqlId);
    }
	
	public Map<String,Object> map(String sqlId,Map<String,Object> param){
        return (Map<String,Object>)sqlSession.selectOne(sqlId, param);
    }
	
	public String one(String sqlId,Map<String,Object> param){
        return (String)sqlSession.selectOne(sqlId, param);
    }
	
	public void update(Map<String,Object> param,String sqlId){
        sqlSession.update(sqlId,param);
    }
	
	public void delete(Map<String,Object> param,String sqlId){
        sqlSession.delete(sqlId,param);
    }
	
	public void insert(Map<String,Object> param,String sqlId){
        sqlSession.insert(sqlId,param);
    }
}