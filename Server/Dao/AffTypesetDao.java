package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.AffTypesetEntity;
import Helper.DBHelper;

public class AffTypesetDao extends DBHelper{

	public List<AffTypesetEntity> getUsersEntity(AffTypesetEntity affTypesetEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<AffTypesetEntity> affTypesetEntitys = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from aff_typeset where usr_email = ? and usr_pswd = ?;");
			preparedStatement.setString(1, affTypesetEntity.getAff_typename());
			set = preparedStatement.executeQuery();
			while(set.next()){
				AffTypesetEntity AaffTypesetEntity = new AffTypesetEntity();
				AaffTypesetEntity.setAff_typeid(set.getInt("aff_typeid"));
				AaffTypesetEntity.setAff_typename(set.getString("aff_typename"));
				affTypesetEntitys.add(AaffTypesetEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return affTypesetEntitys;
	}
	
	
	public void addAffTypesetEntity(AffTypesetEntity user) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into aff_typeset (aff_typename) values(?);");
			preparedStatement.setString(1, user.getAff_typename());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeAffTypesetEntity(AffTypesetEntity affTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update aff_typeset set aff_typename = ? where aff_typeid = ?;");
			preparedStatement.setString(1, affTypesetEntity.getAff_typename());
			preparedStatement.setInt(2, affTypesetEntity.getAff_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteAffTypesetEntity(AffTypesetEntity affTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from aff_typeset where aff_typeid = ?;");
			preparedStatement.setInt(1, affTypesetEntity.getAff_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
