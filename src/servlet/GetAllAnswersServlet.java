package servlet;

import com.alibaba.fastjson.JSON;
import dao.AnswerDao;
import model.Answer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.SortedSet;

@WebServlet("/getAllAnswer")
public class GetAllAnswersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            if (method == null) {
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                out.print("error:method未指定！");
                // 释放PrintWriter对象
                out.flush();
                out.close();
            } else if (method.equals("uid")) {
                AnswerDao answerDao = new AnswerDao();
                SortedSet<Answer> answersByUid = answerDao.getAnswersByUid(id);
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                String result = JSON.toJSONString(answersByUid);
                out.print(result);
                // 释放PrintWriter对象
                out.flush();
                out.close();
            } else if (method.equals("qid")) {
                AnswerDao answerDao = new AnswerDao();
                SortedSet<Answer> answersByQid = answerDao.getAnswersByQid(id);
                //返回结果
                resp.setHeader("Access-Control-Allow-Headers", "*");
                resp.setContentType("text/html");
                resp.setCharacterEncoding("UTF-8");
                // 获取PrintWriter对象
                PrintWriter out = resp.getWriter();
                String result = JSON.toJSONString(answersByQid);
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
