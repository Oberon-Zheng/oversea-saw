package overseasaw.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import overseasaw.dao.UserDAO;
import overseasaw.database.util.RegisterFailure;
import overseasaw.server.entity.UserEntity;
import overseasaw.server.work.UserWork;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		JSONObject jsonReq = new JSONObject(strContent);
		UserEntity user= new UserEntity(jsonReq);
		RegisterFailure success = UserWork.TryRegister(user);
		JSONObject jsonResp = new JSONObject();
		jsonResp.put("reg_result", success.value());
		response.getWriter().write(jsonResp.toString());
		System.out.println(jsonReq.toString(4));
		reader.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
