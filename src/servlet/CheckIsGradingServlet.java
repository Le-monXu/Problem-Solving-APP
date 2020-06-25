package servlet;

import com.alibaba.fastjson.JSON;
import dao.GradingDao;
import model.Grading;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkIsGrading")
public class CheckIsGradingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int aid = Integer.parseInt(req.getParameter("aid"));
        try {
            GradingDao gradingDao = new GradingDao();
            Grading grading = gradingDao.check(uid, aid);
            if (grading != null) {
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                String result = JSON.toJSONString(grading);
                out.print(result);
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
                out.print("false");
                // 释放PrintWriter对象
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
}
