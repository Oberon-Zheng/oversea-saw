package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.PoiTypesetEntity;
import Helper.DBHelper;

public class PoiTypesetDao extends DBHelper{

	public List<PoiTypesetEntity> getUsersEntity(PoiTypesetEntity poiTypesetEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<PoiTypesetEntity> poiTypesetEntitys = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from poi_typeset where poi_typename = ?;");
			preparedStatement.setString(1, poiTypesetEntity.getPoi_typename());
			set = preparedStatement.executeQuery();
			while(set.next()){
				PoiTypesetEntity ApoiTypesetEntity = new PoiTypesetEntity();
				ApoiTypesetEntity.setPoi_typeid(set.getInt("poi_typeid"));
				ApoiTypesetEntity.setPoi_typename(set.getString("poi_typename"));
				poiTypesetEntitys.add(ApoiTypesetEntity);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return poiTypesetEntitys;
	}
	
	
	public void addPoiTypesetEntity(PoiTypesetEntity poiTypesetEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into poi_typeset (poi_typename) values(?);");
			preparedStatement.setString(1, poiTypesetEntity.getPoi_typename());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changePoiTypesetEntity(PoiTypesetEntity poiTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update poi_typeset set poi_typename = ? where poi_typeid = ?;");
			preparedStatement.setString(1, poiTypesetEntity.getPoi_typename());
			preparedStatement.setInt(2, poiTypesetEntity.getPoi_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteUserEntity(PoiTypesetEntity poiTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from poi_typeset where poi_typeid = ?;");
			preparedStatement.setInt(1, poiTypesetEntity.getPoi_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
