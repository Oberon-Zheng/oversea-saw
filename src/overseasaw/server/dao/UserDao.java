package overseasaw.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import overseasaw.database.util.DBHelper;
import overseasaw.database.util.RegisterFailure;
import overseasaw.server.entity.UserEntity;

public class UserDao extends DBHelper{

	public List<UserEntity> getUsersEntity(UserEntity user) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<UserEntity> users = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_email = ? and usr_pswd = ?;");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_pswd());
			set = preparedStatement.executeQuery();
			while(set.next()){
				UserEntity Auser = new UserEntity();
				Auser.setUsr_id(set.getInt("usr_id"));
				Auser.setUsr_email(set.getString("usr_email"));
				Auser.setUsr_name(set.getString("usr_name"));
				Auser.setUsr_pswd(set.getString("usr_pswd"));
				Auser.setUsr_birth(set.getDate("usr_birth"));
				Auser.setUsr_sex(set.getString("usr_sex"));
				Auser.setUsr_tel(set.getString("usr_tel"));
				Auser.setUsr_school(set.getInt("usr_school"));
				Auser.setReg_time(set.getDate("reg_time"));
				Auser.setUsr_authenticated(set.getBoolean("usr_authenticated"));
				users.add(Auser);
			}
		} catch (SQLException e) {

			System.out.println("UserEntity��ѯ����");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return users;
	}
	public List<UserEntity> getUserEntityByName(String name) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<UserEntity> users = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_name = ?;");
			preparedStatement.setString(1, name);
			set = preparedStatement.executeQuery();
			while(set.next()){
				UserEntity Auser = new UserEntity();
				Auser.setUsr_id(set.getInt("usr_id"));
				Auser.setUsr_email(set.getString("usr_email"));
				Auser.setUsr_name(set.getString("usr_name"));
				Auser.setUsr_pswd(set.getString("usr_pswd"));
				Auser.setUsr_birth(set.getDate("usr_birth"));
				Auser.setUsr_sex(set.getString("usr_sex"));
				Auser.setUsr_tel(set.getString("usr_tel"));
				Auser.setUsr_school(set.getInt("usr_school"));
				Auser.setReg_time(set.getDate("reg_time"));
				Auser.setUsr_authenticated(set.getBoolean("usr_authenticated"));
				users.add(Auser);
			}
		} catch (SQLException e) {

			System.out.println("UserEntity��ѯ����");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return users;
	}
	public List<UserEntity> getUserEntityByEmail(String email) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<UserEntity> users = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_email = ?;");
			preparedStatement.setString(1, email);
			set = preparedStatement.executeQuery();
			while(set.next()){
				UserEntity Auser = new UserEntity();
				Auser.setUsr_id(set.getInt("usr_id"));
				Auser.setUsr_email(set.getString("usr_email"));
				Auser.setUsr_name(set.getString("usr_name"));
				Auser.setUsr_pswd(set.getString("usr_pswd"));
				Auser.setUsr_birth(set.getDate("usr_birth"));
				Auser.setUsr_sex(set.getString("usr_sex"));
				Auser.setUsr_tel(set.getString("usr_tel"));
				Auser.setUsr_school(set.getInt("usr_school"));
				Auser.setReg_time(set.getDate("reg_time"));
				Auser.setUsr_authenticated(set.getBoolean("usr_authenticated"));
				users.add(Auser);
			}
		} catch (SQLException e) {

			System.out.println("UserEntity��ѯ����");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return users;
	}
	public List<UserEntity> getUserEntityByTel(String tel) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<UserEntity> users = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_tel = ?;");
			preparedStatement.setString(1, tel);
			set = preparedStatement.executeQuery();
			while(set.next()){
				UserEntity Auser = new UserEntity();
				Auser.setUsr_id(set.getInt("usr_id"));
				Auser.setUsr_email(set.getString("usr_email"));
				Auser.setUsr_name(set.getString("usr_name"));
				Auser.setUsr_pswd(set.getString("usr_pswd"));
				Auser.setUsr_birth(set.getDate("usr_birth"));
				Auser.setUsr_sex(set.getString("usr_sex"));
				Auser.setUsr_tel(set.getString("usr_tel"));
				Auser.setUsr_school(set.getInt("usr_school"));
				Auser.setReg_time(set.getDate("reg_time"));
				Auser.setUsr_authenticated(set.getBoolean("usr_authenticated"));
				users.add(Auser);
			}
		} catch (SQLException e) {

			System.out.println("UserEntity��ѯ����");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return users;
	}

	public boolean exists(UserEntity user) {
		boolean unique = true;
	 	Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_email = ? or usr_name = ? or (usr_tel = ? and usr_tel is not null);");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_name());
			preparedStatement.setString(3, user.getUsr_tel());
			set = preparedStatement.executeQuery();
			if(set.next()) {
				unique = false;
			}
		} catch (SQLException e) {

			System.out.println("UserEntity\t");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return unique;
	}
	
	public RegisterFailure existsWhich(UserEntity user) {
		RegisterFailure regfail = RegisterFailure.REG_SUCCESS;
	 	Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_email = ?;");
			preparedStatement.setString(1, user.getUsr_email());
			set = preparedStatement.executeQuery();
			if(set.next()) {
				regfail = RegisterFailure.REG_EMAIL_DUP;
			}
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_name = ?;");
			preparedStatement.setString(1, user.getUsr_name());
			set = preparedStatement.executeQuery();
			if(set.next()) {
				regfail = RegisterFailure.REG_NAME_DUP;
			}
			preparedStatement = connection.prepareStatement("select * from ordinary_user where usr_tel = ? and usr_tel is not null;");
			preparedStatement.setString(1, user.getUsr_tel());
			set = preparedStatement.executeQuery();
			if(set.next()) {
				regfail = RegisterFailure.REG_TEL_DUP;
			}
		} catch (SQLException e) {

			System.out.println("UserEntity\t");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return regfail;
	}

	public void addUserEntity(UserEntity user) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		int Stat = 0;
		try {
			preparedStatement = connection.prepareStatement("insert into ordinary_user (usr_email,usr_name,usr_pswd,usr_birth,usr_sex,usr_tel,usr_school,reg_time,usr_authenticated) values(?,?,?,?,?,?,?,now(),?);");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_name());
			preparedStatement.setString(3, user.getUsr_pswd());
			preparedStatement.setDate(4, user.getUsr_birth());
			preparedStatement.setString(5, user.getUsr_sex());
			preparedStatement.setString(6, user.getUsr_tel());
			preparedStatement.setInt(7, user.getUsr_school());
			preparedStatement.setBoolean(8, user.getUsr_authenticated());
			Stat = preparedStatement.executeUpdate();
		} catch (SQLException e) {

			System.out.println("UserEntity Corrupted");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		System.out.println("UserEntity���ӽ��"+Stat);
	}
	public void changeUserEntity(UserEntity user){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update ordinary_user set usr_email = ?,usr_name = ?,usr_pswd = ?,usr_birth = ?,usr_sex = ?,usr_tel = ?,usr_school = ?,reg_time = ?,usr_authenticated = ? where usr_id = ?;");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_name());
			preparedStatement.setString(3, user.getUsr_pswd());
			preparedStatement.setDate(4, user.getUsr_birth());
			preparedStatement.setString(5, user.getUsr_sex());
			preparedStatement.setString(6, user.getUsr_tel());
			preparedStatement.setInt(7, user.getUsr_school());
			preparedStatement.setDate(8, user.getReg_time());
			preparedStatement.setBoolean(9, user.getUsr_authenticated());
			preparedStatement.setInt(10, user.getUsr_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UserEntity Corrupted");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	public void deleteUserEntity(UserEntity user){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from ordinary_user where usr_id = ?;");
			preparedStatement.setInt(1, user.getUsr_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			System.out.println("UserEntity Corrupted");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
}
