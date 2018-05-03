package com.zzy.servlet.user.movie;

import com.zzy.po.User;
import com.zzy.service.MovieService;
import com.zzy.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stt on 2018/4/29.
 */
@WebServlet("/uploadMovie")
public class UploadMovieServlet extends HttpServlet {

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 10;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 1000;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 1500;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(req)) {
            // 如果不是则停止
            PrintWriter writer = resp.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = req.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Map<String, String> map = new HashMap<>();
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        req.setAttribute("msg", "文件上传成功!");

                        String url = "http://localhost:8080/" + UPLOAD_DIRECTORY + "/" + fileName;
                        map.put("url", url);
                    } else {
                        String fieldName = item.getFieldName();
                        String value = item.getString();
                        value = new String(value.getBytes("iso-8859-1"), "utf-8");
                        map.put(fieldName, value);
                    }

                }
            }

            UserService userService = new UserService();
            String userUuid = map.get("userUuid");
            User user = userService.findByUserUuid(userUuid);
            req.setAttribute("user", user);

            MovieService movieService = new MovieService();
            String photo = "http://localhost:8080/image/movie.jpg";
            String name = map.get("name");
            String url = map.get("url");
            String director = map.get("director");
            String screenwriter = map.get("screenwriter");
            String starring = map.get("starring");
            String intro = map.get("intro");
            movieService.save(name, url, director, screenwriter, starring, intro, photo, userUuid);
            req.getRequestDispatcher("/user/movieInfo?userUuid=" + user.getUserUuid()).forward(req, resp);
        } catch (Exception ex) {
            req.setAttribute("msg", "上传失败,请联系管理员!");
            req.getRequestDispatcher("/user/message.jsp").forward(req, resp);
        }


    }
}
