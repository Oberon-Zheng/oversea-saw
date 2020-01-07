package overseasaw.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import overseasaw.server.entity.UserEntity;
import overseasaw.server.work.UserWork;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Scanner reader = new Scanner(request.getInputStream());
		String strContent = reader.nextLine();
		reader.close();
		System.out.println(strContent);
		UserEntity user = null;
		JSONObject jsonReq = new JSONObject(strContent);
		JSONObject jsonResp = null;
		String temail = jsonReq.getString("usr_email");
		String tpswd = jsonReq.getString("usr_pswd");
		
		user = UserWork.TryLogin(temail, tpswd);
		
		if(user.getUsr_id() > 0) {
			jsonResp = user.Serialize();
			System.out.println(String.format("登录成功，用户名%s",user.getUsr_name()));				
		}
		else {
			jsonResp = new JSONObject();
			jsonResp.put("login_fail",user.getUsr_id());
		}
		System.out.println(jsonResp.toString());
		response.getWriter().write(jsonResp.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
