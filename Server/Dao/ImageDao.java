package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.ImageEntity;
import Helper.DBHelper;

public class ImageDao extends DBHelper{

	public List<ImageEntity> getImageEntity(ImageEntity imageEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<ImageEntity> imageEntities = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from image where thread_posted_thr_id = ?;");
			preparedStatement.setInt(1, imageEntity.getThread_posted_thr_id());
			set = preparedStatement.executeQuery();
			while(set.next()){
				ImageEntity AImageEntity = new ImageEntity();
				AImageEntity.setImg_id(set.getInt("usr_id"));
				AImageEntity.setThread_posted_thr_id(set.getInt("usr_email"));
				AImageEntity.setImg_url(set.getString("usr_name"));
				imageEntities.add(AImageEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return imageEntities;
	}
	
	
	public void addImageEntity(ImageEntity imageEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into image (thread_posted_thr_id,img_url) values(?,?);");
			preparedStatement.setInt(1, imageEntity.getThread_posted_thr_id());
			preparedStatement.setString(2, imageEntity.getImg_url());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeImageEntity(ImageEntity imageEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update image set thread_posted_thr_id = ?,img_url = ? where img_id = ?;");
			preparedStatement.setInt(1, imageEntity.getThread_posted_thr_id());
			preparedStatement.setString(2, imageEntity.getImg_url());
			preparedStatement.setInt(3, imageEntity.getImg_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteImageEntity(ImageEntity imageEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from image where img_id = ?;");
			preparedStatement.setInt(1, imageEntity.getImg_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
