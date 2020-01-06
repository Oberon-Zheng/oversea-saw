package overseasaw.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import overseasaw.dao.UserDAO;

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
		JSONObject jsonReq = JSONObject.parseObject(strContent);
		Integer i = jsonReq.getInteger("usr_id");
		
		String 	uname = request.getParameter("uname"),
				umail = request.getParameter("umail"),
				upswd = request.getParameter("upswd"),
				utel = request.getParameter("utel"),
				usex = request.getParameter("usex");
		System.out.println(String.format("%s %s %s %s %s", uname,umail,upswd,utel,usex));
		UserDAO ureg = new UserDAO(0,umail,uname,utel,usex.charAt(0));
		int rsucc = ureg.AttemptRegister(upswd);
		if(rsucc != 0)
		{
			System.out.println(String.format("------------------------Reg failed %d-----------------------", rsucc));
		}
		else
		{
			System.out.println("=================可注册并成功===============");
		}
		reader.close();
		response.getWriter().write(String.format("%d", rsucc));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
