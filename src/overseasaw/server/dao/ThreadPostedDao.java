package overseasaw.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import overseasaw.database.util.DBHelper;
import overseasaw.server.entity.ThreadPostedEntity;

public class ThreadPostedDao extends DBHelper{

	public List<ThreadPostedEntity> getThreadPostedAll() {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<ThreadPostedEntity> threadPostedEntitys = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("select * from thread_posted where thr_enabled = true;");
			set = preparedStatement.executeQuery();
			while(set.next()){
				ThreadPostedEntity AthreadPostedEntity = new ThreadPostedEntity();
				AthreadPostedEntity.setThr_id(set.getInt("thr_id"));
				AthreadPostedEntity.setThr_author(set.getInt("thr_author"));
				AthreadPostedEntity.setThr_text(set.getString("thr_text"));
				AthreadPostedEntity.setThr_type(set.getInt("thr_type"));
				AthreadPostedEntity.setThr_enabled(set.getBoolean("thr_enabled"));
				AthreadPostedEntity.setThr_replyto(set.getInt("thr_replyto"));
				threadPostedEntitys.add(AthreadPostedEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return threadPostedEntitys;
	}
	
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
				AthreadPostedEntity.setThr_enabled(set.getBoolean("thr_enabled"));
				AthreadPostedEntity.setThr_replyto(set.getInt("thr_replyto"));
				threadPostedEntitys.add(AthreadPostedEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
		return threadPostedEntitys;
	}
	public List<ThreadPostedEntity> getThreadPostedEntityById(int id) {
	 	Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		List<ThreadPostedEntity> threadPostedEntitys = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("select * from thread_posted where thr_id = ?;");
			preparedStatement.setInt(1, id);
			set = preparedStatement.executeQuery();
			while(set.next()){
				ThreadPostedEntity AthreadPostedEntity = new ThreadPostedEntity();
				AthreadPostedEntity.setThr_id(set.getInt("thr_id"));
				AthreadPostedEntity.setThr_author(set.getInt("thr_author"));
				AthreadPostedEntity.setThr_text(set.getString("thr_text"));
				AthreadPostedEntity.setThr_type(set.getInt("thr_type"));
				AthreadPostedEntity.setThr_enabled(set.getBoolean("thr_enabled"));
				AthreadPostedEntity.setThr_replyto(set.getInt("thr_replyto"));
				threadPostedEntitys.add(AthreadPostedEntity);
			}
		} catch (SQLException e) {
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
			preparedStatement.setBoolean(4, threadPostedEntity.getThr_enabled());
			preparedStatement.setInt(5, threadPostedEntity.getThr_replyto());
			if(threadPostedEntity.getThr_replyto() == 0)
			{
				preparedStatement.setNull(5, Types.INTEGER);
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void changeThreadPostedEntity(ThreadPostedEntity threadPostedEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update thread_posted set thr_author = ?,thr_text = ?,thr_type = ?,thr_type = ?,thr_enabled = ?,thr_replyto = ? where thr_id = ?;");
			preparedStatement.setInt(1, threadPostedEntity.getThr_author());
			preparedStatement.setString(2, threadPostedEntity.getThr_text());
			preparedStatement.setInt(3, threadPostedEntity.getThr_type());
			preparedStatement.setBoolean(4, threadPostedEntity.getThr_enabled());
			preparedStatement.setInt(5, threadPostedEntity.getThr_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
	
	public void deleteThreadPostedEntity(ThreadPostedEntity threadPostedEntity){
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from thread_posted where thr_id = ?;");
			preparedStatement.setInt(1, threadPostedEntity.getThr_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection(connection);
		}
	}
}
