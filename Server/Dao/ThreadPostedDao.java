package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.ThreadPostedEntity;
import Entity.UserEntity;
import Helper.DBHelper;

public class ThreadPostedDao extends DBHelper{

	public List<ThreadPostedEntity> getThreadPostedEntity(ThreadPostedEntity threadPostedEntity) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<ThreadPostedEntity> threadPostedEntitys = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("select * from thread_posted where thr_author = ?;");
			preparedStatement.setInt(1, threadPostedEntity.getThr_author());
			set = preparedStatement.executeQuery();
			while(set.next()){
				ThreadPostedEntity AthreadPostedEntity = new ThreadPostedEntity();
				AthreadPostedEntity.setThr_id(set.getInt("thr_id"));
				AthreadPostedEntity.setThr_author(set.getInt("thr_author"));
				AthreadPostedEntity.setThr_text(set.getString("thr_text"));
				AthreadPostedEntity.setThr_type(set.getInt("thr_type"));
				AthreadPostedEntity.setThr_enabled(set.getInt("thr_enabled"));
				AthreadPostedEntity.setThr_replyto(set.getInt("thr_replyto"));
				threadPostedEntitys.add(AthreadPostedEntity);
			}
		} catch (SQLException e) {
			System.out.println("ThreadPostedEntity查询错误");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return threadPostedEntitys;
	}
	
	
	public void addThreadPostedEntity(ThreadPostedEntity threadPostedEntity) {
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into thread_posted (thr_author,thr_text,thr_type,thr_enabled,thr_replyto) values(?,?,?,?,?);");
			preparedStatement.setInt(1, threadPostedEntity.getThr_author());
			preparedStatement.setString(2, threadPostedEntity.getThr_text());
			preparedStatement.setInt(3, threadPostedEntity.getThr_type());
			preparedStatement.setInt(4, threadPostedEntity.getThr_enabled());
			preparedStatement.setInt(5, threadPostedEntity.getThr_replyto());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("ThreadPostedEntity增加条目错误");
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeThreadPostedEntity(ThreadPostedEntity threadPostedEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update thread_posted set thr_author = '?',thr_text = '?',thr_type = '?',thr_type = '?',thr_enabled = '?',thr_replyto = '?' where thr_id = ?;");
			preparedStatement.setInt(1, threadPostedEntity.getThr_author());
			preparedStatement.setString(2, threadPostedEntity.getThr_text());
			preparedStatement.setInt(3, threadPostedEntity.getThr_type());
			preparedStatement.setInt(4, threadPostedEntity.getThr_enabled());
			preparedStatement.setInt(5, threadPostedEntity.getThr_id());
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
			preparedStatement = connection.prepareStatement("delete from thread_posted where usr_id = ?;");
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
