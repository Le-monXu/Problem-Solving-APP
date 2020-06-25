package servlet;

import com.alibaba.fastjson.JSON;
import dao.QuestionDao;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet("/getAllQuestion")
public class GetAllQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            QuestionDao questionDao = new QuestionDao();
            HashSet<Question> allQuestion = questionDao.getAllQuestion();
            if (allQuestion == null) { //返回结果
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
            } else { //返回结果
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                String result = JSON.toJSONString(allQuestion);
                out.print(result);
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
