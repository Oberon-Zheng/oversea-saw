package overseasaw.dao;

import java.sql.*;

public class UserDAO
{
	private int id;
	private String name;
	private String email;
	private String tel;
	private String password;
	private Gender sex;
	private String nationality;
	private boolean authenticated;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public void setSex(char sex)
	{
		switch(sex)
		{
		case 'M':
			this.sex = Gender.MALE;
			break;
		case 'F':
			this.sex = Gender.FEMALE;
			break;
		default:
			this.sex = Gender.UNKNOWN;
			break;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public static final int regSuccess = 0;
	public static final int regNameDup = -1;
	public static final int regEmailDup = -2;
	public static final int regTelDup = -4;
	public static final int regNameInvalid = 1;
	public static final int regEmailInvalid = 2;
	public static final int regPswdInvalid = 3;
	public static final int regTelInvalid = 4;
	public static final int regOtherFailure = 255;
	
	public UserDAO(int id,String email,String name,String tel,Gender sex)
	{
		setId(id);
		setEmail(email);
		setName(name);
		setTel(tel);
		setSex(sex);
	}
	public UserDAO(int id,String email,String name,String tel,char sex)
	{
		setId(id);
		setEmail(email);
		setName(name);
		setTel(tel);
		switch(sex)
		{
			case 'M':
				this.sex = Gender.MALE;
				break;
			case 'F':
				this.sex = Gender.FEMALE;
				break;
			default:
				this.sex = Gender.UNKNOWN;
				break;
		}
	}
	
	
	public static int AttemptRegister(UserDAO usr,String password)
	{
		int result = regSuccess;
		
		Connection conn = DBConnection.GetConn();
		PreparedStatement prstm = null;
		ResultSet rs = null;
		String qform = "select usr_id from ordinary_user where %s = ?;";
		
		if(usr.name == null || usr.name.isEmpty())
		{
			return regNameInvalid;
		}
		else if(usr.email == null)
		{
			return regEmailInvalid;
		}
		else if(password == null || password.length() < 6 || password.length() > 64)
		{
			return regPswdInvalid;
		}
		else
		{
			try
			{
				prstm = conn.prepareStatement(String.format(qform, "usr_email"));
				prstm.setString(1, usr.email);
				rs = prstm.executeQuery();
				if(rs.next())
				{
					DBConnection.CleanConn(rs, prstm, conn);
					return regEmailDup;
				}
				prstm = conn.prepareStatement(String.format(qform, "usr_name"));
				prstm.setString(1, usr.name);
				rs = prstm.executeQuery();
				if(rs.next())
				{
					DBConnection.CleanConn(rs, prstm, conn);
					return regNameDup;
				}
				
				prstm = conn.prepareStatement(String.format(qform, "usr_tel"));
				prstm.setString(1, usr.tel);
				rs = prstm.executeQuery();
				if(rs.next())
				{
					DBConnection.CleanConn(rs, prstm, conn);
					return regTelDup;
				}
				
				prstm = conn.prepareStatement("insert into ordinary_user(usr_email,usr_name,usr_pswd,usr_sex,usr_tel,reg_time) values(?,?,?,?,?,now());");
				prstm.setString(1, usr.email);
				prstm.setString(2, usr.name);
				prstm.setString(3, password);
				prstm.setString(4, String.format("%c", StringUtil.Gender2Char(usr.sex)));
				if(usr.tel == null || usr.tel.isEmpty())
					prstm.setNull(5,java.sql.Types.NULL);
				else
					prstm.setString(5, usr.tel);
				prstm.execute();
				
			}
			catch(SQLException e)
			{
				return regOtherFailure;
			}
		}
		
		return result;
	}
	public int AttemptRegister(String password)
	{
		return UserDAO.AttemptRegister(this, password);
	}
	
	public static int AttemptLogin(String email,String password)
	{
		Connection conn = null;
		PreparedStatement prstm = null;
		ResultSet rs = null;
		int uid = 0;
		try
		{
			conn = DBConnection.GetConn();
			prstm = conn.prepareStatement("select usr_id from ordinary_user where usr_email=? and usr_pswd=?");
			prstm.setString(1,email);
			prstm.setString(2,password);
			rs = prstm.executeQuery();
			if(!rs.next())
			{
				uid = -1;
			}
			else
			{
				uid = rs.getInt("usr_id");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.CleanConn(rs, prstm, conn);
		}
		return uid;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
}
