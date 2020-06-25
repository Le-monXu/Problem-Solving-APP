package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        String password = req.getParameter("password");
        try {
            UserDao ud = new UserDao();
            if (ud.check(uid, password)) {
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                out.print(uid);
                // 释放PrintWriter对象
                out.flush();
                out.close();
            } else {
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                out.print("failed");
                // 释放PrintWriter对象
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            //返回结果
            resp.setHeader("Access-Control-Allow-Headers", "*");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            // 获取PrintWriter对象
            PrintWriter out = resp.getWriter();
            out.print("error:" + e.toString());
            // 释放PrintWriter对象
            out.flush();
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
