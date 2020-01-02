package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.UserEntity;
import Helper.DBHelper;

public class PlaceOfInterestDao extends DBHelper{

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
				Auser.setUsr_authenticated(set.getInt("usr_authenticated"));
				users.add(Auser);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			System.out.println("UserEntity查询错误");
			this.closeConnection(connection);
		}
		return users;
	}
	
	
	public void addUserEntity(UserEntity user) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		int Stat = 0;
		try {
			preparedStatement = connection.prepareStatement("insert into ordinary_user (usr_email,usr_name,usr_pswd,usr_birth,usr_sex,usr_tel,usr_school,reg_time,usr_authenticated) values(?,?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_name());
			preparedStatement.setString(3, user.getUsr_pswd());
			preparedStatement.setDate(4, user.getUsr_birth());
			preparedStatement.setString(5, user.getUsr_sex());
			preparedStatement.setString(6, user.getUsr_tel());
			preparedStatement.setInt(7, user.getUsr_school());
			preparedStatement.setDate(8, user.getReg_time());
			preparedStatement.setInt(9, user.getUsr_authenticated());
			Stat = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			System.out.println("UserEntity增加条目错误");
			this.closeConnection(connection);
		}
		System.out.println("UserEntity增加结果"+Stat);
	}
	
	public void changeUserEntity(UserEntity user){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update ordinary_user set usr_email = '?',usr_name = '?',usr_pswd = '?',usr_birth = '?',usr_sex = '?',usr_tel = '?',usr_school = '?',reg_time = '?',usr_authenticated = '?' where usr_id = ?;");
			preparedStatement.setString(1, user.getUsr_email());
			preparedStatement.setString(2, user.getUsr_name());
			preparedStatement.setString(3, user.getUsr_pswd());
			preparedStatement.setDate(4, user.getUsr_birth());
			preparedStatement.setString(5, user.getUsr_sex());
			preparedStatement.setString(6, user.getUsr_tel());
			preparedStatement.setInt(7, user.getUsr_school());
			preparedStatement.setDate(8, user.getReg_time());
			preparedStatement.setInt(9, user.getUsr_authenticated());
			preparedStatement.setInt(10, user.getUsr_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			System.out.println("UserEntity增加条目错误");
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			System.out.println("UserEntity增加条目错误");
			this.closeConnection(connection);
		}
	}
}
