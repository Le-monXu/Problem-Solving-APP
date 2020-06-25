package servlet;

import dao.AnswerDao;
import model.Answer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addAnswer")
public class AddAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        int qid = Integer.parseInt(req.getParameter("qid"));
        String answer = req.getParameter("answer");
        Answer answer1 = new Answer(uid, 0, qid, answer, null, 5, 0);
        AnswerDao answerDao = new AnswerDao();
        try {
            //返回结果
            resp.setHeader("Access-Control-Allow-Headers", "*");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            // 获取PrintWriter对象
            PrintWriter out = resp.getWriter();
            int aid = answerDao.add(answer1);
            if (aid != 0) {
                out.print(aid);
            } else {
                //返回结果
                out.print("failed");
            }
            // 释放PrintWriter对象
            out.flush();
            out.close();
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
