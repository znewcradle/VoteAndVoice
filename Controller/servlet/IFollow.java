package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import vo.*;

/**
 * Servlet implementation class IFollow
 */
@WebServlet("/IFollow")
public class IFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IFollow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String u_id = request.getParameter("u_id");
		HttpSession session = request.getSession(true);
		String u_id = (String)session.getAttribute("u_id");
		if (u_id == null)
		{
			u_id = "yyf123";
		}
		ArrayList<Dbuser> followingList = new ArrayList<Dbuser>();			
		int message = DAOFactory.getFollowDAO().getFollowedUser(u_id, followingList);
		switch(message) {
		case FollowDAO.SUCCESS:
			System.out.println("id");
			request.setAttribute("followingList", followingList);
			request.getRequestDispatcher("/iFollow.jsp").forward(request, response);
			break;
		case FollowDAO.EXCEPTION:
			response.getWriter().append("somthing wrong with our website");
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String del_fing_id = (String)request.getParameter("del_fing_id");
		if (del_fing_id == null)
		{
			System.out.println("mdzz");
			request.getRequestDispatcher("/safe.jsp").forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession(true);
			String u_id = (String)session.getAttribute("u_id");
			if (u_id == null)
			{
				u_id = "yyf123";
			}
			int message = DAOFactory.getFollowDAO().unfollow(u_id, del_fing_id);
			switch(message) {
			case FollowDAO.SUCCESS:
				break;
			case FollowDAO.FAILED:
				System.out.println("failed");
				break;
			case FollowDAO.EXCEPTION:
				System.out.println("exception");
				break;
			default:
				break;
			}
			doGet(request, response);
		}
		//doGet(request, response);
	}

}
