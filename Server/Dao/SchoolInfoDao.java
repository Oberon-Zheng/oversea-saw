package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.SchoolInfoEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class SchoolInfoDao extends DBHelper{

	public List<SchoolInfoEntity> getSchoolInfoEntity(SchoolInfoEntity schoolInfoEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<SchoolInfoEntity> schoolInfoEntitys = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from school_info where sch_name = ?;");
			preparedStatement.setString(1, schoolInfoEntity.getSch_name());
			set = preparedStatement.executeQuery();
			while(set.next()){
				SchoolInfoEntity AschoolInfoEntity = new SchoolInfoEntity();
				AschoolInfoEntity.setSch_id(set.getInt("sch_id"));
				AschoolInfoEntity.setSch_name(set.getString("sch_name"));
				AschoolInfoEntity.setSch_country(set.getString("sch_country"));
				AschoolInfoEntity.setSch_address(set.getString("sch_address"));
				AschoolInfoEntity.setSch_tel(set.getString("sch_tel"));
				schoolInfoEntitys.add(AschoolInfoEntity);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return schoolInfoEntitys;
	}
	
	
	public void addSchoolInfoEntity(SchoolInfoEntity schoolInfoEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into school_info (sch_name,sch_country,sch_address,sch_tel) values(?,?,?,?);");
			preparedStatement.setString(1, schoolInfoEntity.getSch_name());
			preparedStatement.setString(2, schoolInfoEntity.getSch_country());
			preparedStatement.setString(3, schoolInfoEntity.getSch_address());
			preparedStatement.setString(4, schoolInfoEntity.getSch_tel());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeSchoolInfoEntity(SchoolInfoEntity schoolInfoEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update school_info set sch_name = '?',sch_country = '?',sch_address = '?',sch_tel = '?' where sch_id = ?;");
			preparedStatement.setString(1, schoolInfoEntity.getSch_name());
			preparedStatement.setString(2, schoolInfoEntity.getSch_country());
			preparedStatement.setString(3, schoolInfoEntity.getSch_address());
			preparedStatement.setString(4, schoolInfoEntity.getSch_tel());
			preparedStatement.setInt(5, schoolInfoEntity.getSch_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteSchoolInfoEntity(SchoolInfoEntity schoolInfoEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from school_info where sch_id = ?;");
			preparedStatement.setInt(1, schoolInfoEntity.getSch_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
