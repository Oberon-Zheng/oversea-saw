package overseasaw.server.work;

import java.util.List;

import overseasaw.database.util.LoginFailure;
import overseasaw.server.dao.UserDao;
import overseasaw.server.entity.UserEntity;

public class UserWork {
	public static boolean TryRegister(UserEntity ruser) {
		boolean regResult = true;
		UserDao ud = new UserDao();
		if(ud.exists(ruser)) {
			ud.addUserEntity(ruser);
		}
		else {
			regResult = false;
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
