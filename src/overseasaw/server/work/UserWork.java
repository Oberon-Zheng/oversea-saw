package overseasaw.server.work;

import java.util.List;

import overseasaw.server.dao.UserDao;
import overseasaw.server.entity.UserEntity;

public class UserWork {
	public static boolean TryRegister(UserEntity ruser) {
		boolean regResult = true;
		UserDao ud = new UserDao();
		if(ud.uniqueValidation(ruser)) {
			ud.addUserEntity(ruser);
		}
		else {
			regResult = false;
		}
		return regResult;
	}
}
