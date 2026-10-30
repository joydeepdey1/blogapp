package com.blog.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.blog.dao.PostDAO; // This is the new line that fixes the errors

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// We are not handling GET requests for this form.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get the data from the JSP form
        String title = request.getParameter("postTitle");
        String content = request.getParameter("postContent");

        // 2. Use the DAO to save the post to the database
        PostDAO postDAO = new PostDAO();
        boolean isSaved = postDAO.createPost(title, content);

        // 3. For now, just print a success or failure message to the console
        if (isSaved) {
            System.out.println("Post successfully saved to the database!");
        } else {
            System.out.println("Error: Post was not saved.");
        }
        
        // 4. Redirect back to the homepage
        response.sendRedirect("index.jsp");
	}
}