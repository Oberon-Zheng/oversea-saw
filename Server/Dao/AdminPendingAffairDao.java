package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entity.AdminPendingAffairEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class AdminPendingAffairDao extends DBHelper{

	public List<AdminPendingAffairEntity> getAdminPendingAffairEntity(AdminPendingAffairEntity adminPendingAffairEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<AdminPendingAffairEntity> adminPendingAffairEntities = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from admin_pending_affair where aff_target_user = ?;");
			preparedStatement.setInt(1, adminPendingAffairEntity.getAff_target_user());
			set = preparedStatement.executeQuery();
			while(set.next()){
				AdminPendingAffairEntity AadminPendingAffairEntity = new AdminPendingAffairEntity();
				AadminPendingAffairEntity.setAff_id(set.getInt("aff_id"));
				AadminPendingAffairEntity.setAff_target_user(set.getInt("aff_target_user"));
				AadminPendingAffairEntity.setAff_type(set.getInt("aff_type"));
				AadminPendingAffairEntity.setAff_admin(set.getInt("aff_admin"));
				AadminPendingAffairEntity.setAff_description(set.getString("aff_description"));
				adminPendingAffairEntities.add(AadminPendingAffairEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return adminPendingAffairEntities;
	}
	
	
	public void addAdminPendingAffairEntity(AdminPendingAffairEntity adminPendingAffairEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into admin_pending_affair (aff_target_user,aff_type,usr_pswd,aff_admin,aff_description) values(?,?,?,?);");
			preparedStatement.setInt(1, adminPendingAffairEntity.getAff_target_user());
			preparedStatement.setInt(2, adminPendingAffairEntity.getAff_type());
			preparedStatement.setInt(3, adminPendingAffairEntity.getAff_admin());
			preparedStatement.setString(4, adminPendingAffairEntity.getAff_description());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeAdminPendingAffairEntity(AdminPendingAffairEntity adminPendingAffairEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update admin_pending_affair set aff_target_user = '?',aff_type = '?',aff_admin = '?',aff_description = '?' where aff_id = ?;");
			preparedStatement.setInt(1, adminPendingAffairEntity.getAff_target_user());
			preparedStatement.setInt(2, adminPendingAffairEntity.getAff_type());
			preparedStatement.setInt(3, adminPendingAffairEntity.getAff_admin());
			preparedStatement.setString(4, adminPendingAffairEntity.getAff_description());
			preparedStatement.setInt(5, adminPendingAffairEntity.getAff_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteAdminPendingAffairEntity(AdminPendingAffairEntity adminPendingAffairEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from admin_pending_affair where aff_id = ?;");
			preparedStatement.setInt(5, adminPendingAffairEntity.getAff_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
