package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.ThrTypesetEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class ThrTypesetDao extends DBHelper{

	public List<ThrTypesetEntity> getThrTypesetEntity(ThrTypesetEntity thrTypesetEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<ThrTypesetEntity> thrTypesetEntitys = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from thr_typeset where thr_typeid = ? ;");
			preparedStatement.setInt(1, thrTypesetEntity.getThr_typeid());
			set = preparedStatement.executeQuery();
			while(set.next()){
				ThrTypesetEntity AthrTypesetEntity = new ThrTypesetEntity();
				AthrTypesetEntity.setThr_typeid(set.getInt("thr_typeid"));
				AthrTypesetEntity.setThr_typename(set.getString("thr_typename"));
				thrTypesetEntitys.add(AthrTypesetEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return thrTypesetEntitys;
	}
	
	
	public void addThrTypesetEntity(ThrTypesetEntity thrTypesetEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into thr_typeset (thr_typename) values(?);");
			preparedStatement.setString(1, thrTypesetEntity.getThr_typename());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeThrTypesetEntity(ThrTypesetEntity thrTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update thr_typeset set thr_typename = '?' where thr_typeid = ?;");
			preparedStatement.setString(1, thrTypesetEntity.getThr_typename());
			preparedStatement.setInt(2, thrTypesetEntity.getThr_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteThrTypesetEntity(ThrTypesetEntity thrTypesetEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from thr_typeset where thr_typeid = ?;");
			preparedStatement.setInt(1, thrTypesetEntity.getThr_typeid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
