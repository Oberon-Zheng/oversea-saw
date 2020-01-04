package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.AdminPendingAffairEntity;
import Entity.AdminUserEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class AdminUserDao extends DBHelper{

	public List<AdminUserEntity> getAdminUserEntity(AdminUserEntity adminUserEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<AdminUserEntity> adminPendingAffairEntities = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from admin_user where adm_name = ?;");
			preparedStatement.setString(1, adminUserEntity.getAdm_name());
			set = preparedStatement.executeQuery();
			while(set.next()){
				AdminUserEntity AadminUserEntity = new AdminUserEntity();
				AadminUserEntity.setAdm_id(set.getInt("aff_id"));
				AadminUserEntity.setAdm_name(set.getString("aff_target_user"));
				AadminUserEntity.setAdm_pswd(set.getString("aff_type"));
				adminPendingAffairEntities.add(AadminUserEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return adminPendingAffairEntities;
	}
	
	
	public void addAdminUserEntity(AdminUserEntity adminUserEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into admin_user (adm_name,adm_pswd) values(?,?);");
			preparedStatement.setInt(1, adminUserEntity.getAdm_id());
			preparedStatement.setString(2, adminUserEntity.getAdm_name());
			preparedStatement.setString(3, adminUserEntity.getAdm_pswd());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeAdminUserEntity(AdminUserEntity adminUserEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update admin_user set adm_name = ?,adm_pswd = ? where adm_id = ?;");
			preparedStatement.setString(1, adminUserEntity.getAdm_name());
			preparedStatement.setString(2, adminUserEntity.getAdm_pswd());
			preparedStatement.setInt(3, adminUserEntity.getAdm_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteAdminUserEntity(AdminUserEntity adminUserEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from admin_user where adm_id = ?;");
			preparedStatement.setInt(5, adminUserEntity.getAdm_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
