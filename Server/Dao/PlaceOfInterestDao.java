package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.PlaceOfInterestEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class PlaceOfInterestDao extends DBHelper{

	public List<PlaceOfInterestEntity> getUsersEntity(PlaceOfInterestEntity placeOfInterestEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<PlaceOfInterestEntity> placeOfInterestEntitys = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from place_of_interest where poi_name = ?;");
			preparedStatement.setString(1, placeOfInterestEntity.getPoi_name());
			set = preparedStatement.executeQuery();
			while(set.next()){
				PlaceOfInterestEntity AplaceOfInterestEntity = new PlaceOfInterestEntity();
				AplaceOfInterestEntity.setPoi_id(set.getInt("poi_id"));
				AplaceOfInterestEntity.setPoi_name(set.getString("poi_name"));
				AplaceOfInterestEntity.setPoi_nearschool(set.getInt("poi_nearschool"));
				AplaceOfInterestEntity.setPoi_type(set.getInt("poi_type"));
				placeOfInterestEntitys.add(placeOfInterestEntitys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return placeOfInterestEntitys;
	}
	
	
	public void addUserEntity(PlaceOfInterestEntity placeOfInterestEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into place_of_interest (poi_name,poi_nearschool,poi_type) values(?,?,?);");
			preparedStatement.setString(1, placeOfInterestEntity.getPoi_name());
			preparedStatement.setInt(2, placeOfInterestEntity.getPoi_nearschool());
			preparedStatement.setInt(3, placeOfInterestEntity.getPoi_type());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changePlaceOfInterestEntity(PlaceOfInterestEntity placeOfInterestEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update place_of_interest set poi_name = ?,poi_nearschool = ?,poi_type = ? where poi_id = ?;");
			preparedStatement.setString(1, placeOfInterestEntity.getPoi_name());
			preparedStatement.setInt(2, placeOfInterestEntity.getPoi_nearschool());
			preparedStatement.setInt(3, placeOfInterestEntity.getPoi_type());
			preparedStatement.setInt(4, placeOfInterestEntity.getPoi_id());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deletePlaceOfInterestEntity(PlaceOfInterestEntity placeOfInterestEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from place_of_interest where poi_id = ?;");
			preparedStatement.setInt(1, placeOfInterestEntity.getPoi_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
