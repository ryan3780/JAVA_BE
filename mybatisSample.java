package user;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisSample {
 
	public static void main(String[] args) throws IOException {
		
		String conf = "mybatisSample/mybatis-config.xml";
		User user = new User();
		String userId = user.getUserID();
		String userPassword = user.getUserPassword();
		
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
		try {
			user = (User) session.selectOne("selectLogin", userId); 
			
			if(userId.equals(userPassword)) {
				System.out.println(userId + "" + userPassword);
			}
			else {
				System.out.println("아이디랑 비번이 틀려요.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	// User 정보를 List로 담아서 출력 
	public static void showUserList() throws IOException {
		String conf = "mybatisSample/mybatis-config.xml";
		
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
		try{
			List<User> result = session.selectList("selectListInfo");
		
			for(User vo : result) {
			System.out.println(vo.getUserID());
			System.out.println(vo.getUserName());
			System.out.println(vo.getUserPassword());
			System.out.println(vo.getUserGender());
			System.out.println(vo.getUserEmail());
			}
		} finally {
			session.close();
		}
	}

}

