package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/downloadFile")
public class DownloadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 得到要下载的文件名
        String fileName = request.getParameter("filename");
        fileName = fileName.replace("__", ".");
        System.out.println(fileName);
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        // 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        // 得到要下载的文件
        File file = new File(fileSaveRootPath + "\\" + fileName);
        // 如果文件不存在
        if (!file.exists()) {
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            // 获取PrintWriter对象
            PrintWriter out = response.getWriter();
            out.print("failed");
            // 释放PrintWriter对象
            out.flush();
            out.close();
            return;
        }
        // 处理文件名
        String realname = fileName.substring(fileName.indexOf("_") + 1);
        // 设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        // 循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            // 输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        // 关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // 获取PrintWriter对象
        PrintWriter writer = response.getWriter();
        writer.print("success");
        // 释放PrintWriter对象
        writer.flush();
        writer.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
