package overseasaw.server.work;

import java.util.List;

import overseasaw.database.util.LoginFailure;
import overseasaw.database.util.RegisterFailure;
import overseasaw.server.dao.UserDao;
import overseasaw.server.entity.UserEntity;

public class UserWork {
	
	public static RegisterFailure TryRegister(UserEntity ruser) {
		RegisterFailure regResult = RegisterFailure.REG_SUCCESS;
		UserDao ud = new UserDao();
		regResult = ud.existsWhich(ruser);

		if(ud.existsWhich(ruser) == RegisterFailure.REG_SUCCESS) {
			ud.addUserEntity(ruser);
		}
		
		return regResult;
	}
	
	public static UserEntity TryLogin(String email, String password) {
		UserDao ud = new UserDao();
		UserEntity entity = new UserEntity();
		List<UserEntity> ulist = ud.getUserEntityByEmail(email);
		if(ulist.isEmpty()) {
			entity.setUsr_id(LoginFailure.USER_NOT_EXISTS.value());
		}
		else
		{
			UserEntity authEntity = ulist.get(0);
			if(password.equals(authEntity.getUsr_pswd()))
			{
				entity = authEntity;
			}
			else
			{
				entity.setUsr_id(LoginFailure.PASSWORD_INCORRECT.value());
			}
		}
		return entity;
	}
	
}
