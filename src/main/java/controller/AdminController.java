package controller;


import com.sun.org.apache.xpath.internal.operations.Bool;
import dao.UserDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This servlet program is used to print "Hello World" on
 * client browser using annotations.
 */
@WebServlet(urlPatterns = {"/admin", "/users","/createUser","/viewUser","/deleteuser","/edituser","/updateuser"})
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public AdminController() {

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        RequestDispatcher view = null;

        if (path.equals("/admin")) {

            view = request.getRequestDispatcher("admin/success.jsp");
            view.forward(request, response);

        }

        if (path.equals("/users")) {

            UserDAO userDAO = new UserDAO();
            List<User> users = userDAO.findAll();
            request.setAttribute("usersList", users);
            view = request.getRequestDispatcher("admin/users.jsp");
            view.forward(request, response);

        }
        if (path.equals("/createUser")) {

            view = request.getRequestDispatcher("admin/createuser.jsp");
            view.forward(request, response);

        }
        if (path.equals("/deleteuser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDAO delete = new UserDAO();
            delete.delete(id);
            response.sendRedirect("/users");

        }
        if (path.equals("/viewUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            UserDAO user = new UserDAO();
            User usr = user.findById(id) ;

            request.setAttribute("ouruser",usr);


            view = request.getRequestDispatcher("admin/viewDetails.jsp");
            view.forward(request, response);

        }
        if (path.equals("/edituser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            UserDAO user = new UserDAO();
            User usr = user.findById(id) ;

            request.setAttribute("ouruser",usr);


            view = request.getRequestDispatcher("admin/edituser.jsp");
            view.forward(request, response);

        }



    }

//    private List<User> runthis() {
//        List<User> students = new ArrayList<>();
//        // using try-with-resources to avoid closing resources (boiler plate code)
//
//        // Step 1: Establishing a Connection
//        try (Connection connection = JDBCUtils.getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement("select * from student");) {
//            // preparedStatement.setInt(1, 1);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String firstName = rs.getString(2);
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                User user = new User();
//                user.setId(id);
//                user.setEmail(email);
//                user.setPhone(phone);
//                students.add(user);
//            }
//
//        } catch (SQLException e) {
//            JDBCUtils.printSQLException(e);
//        }
//        return students;
//        // Step 4: try-with-resource statement will auto close the connection.
//    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/createUser")) {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            boolean active = Boolean.parseBoolean(request.getParameter("active"));
            User user = new User(name,email,phone,username,password,active);
            UserDAO udao = new  UserDAO();
            udao.create(user);



            response.sendRedirect("/users");
        }
        if (request.getServletPath().equals("/updateuser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            boolean active = Boolean.parseBoolean(request.getParameter("active"));
            User user = new User(id,name,email,phone,username,password,active);
            UserDAO udao = new  UserDAO();
            udao.update(user);

            response.sendRedirect("/users");
        }
    }

}