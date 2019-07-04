package com.hm.book;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.book.bean.Book;
import com.hm.book.bean.Category;
import com.hm.book.service.BookService;
import com.hm.book.service.CategoryService;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Administrator
 * @Date 2019/7/5/005 0:08
 */
@WebServlet("/site")
public class SiteServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private CategoryService categoryService;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        // 获取sping的容器。
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        categoryService = (CategoryService) context.getBean("categoryService");
        bookService = (BookService) context.getBean("bookService");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        this.request = req;
        this.response = resp;
        this.request.setCharacterEncoding("UTF-8");
        this.response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        switch (method) {
            case "getIndex":
                getIndex();
                break;
        }

    }

    /**
     * 前台首页
     */
    private void getIndex() throws ServletException, IOException {
        int pageStart = 1;
        String num = request.getParameter("num");
        if (!StringUtils.isEmpty(num)) {
            pageStart = Integer.parseInt(num);
        }
        String cid = request.getParameter("cid");
        Page<Book> page = PageHelper.startPage(pageStart <= 0 ? 1 : pageStart, 3);
        List<Book> books = bookService.findAllBooks(cid);
        PageInfo<Book> pageInfo = page.toPageInfo();
        System.out.println("pageInfo = " + pageInfo);
        List<Category> categoryList = categoryService.findAllCategores();
        request.setAttribute("categories", categoryList);
        request.setAttribute("pagehelper", pageInfo);
        request.setAttribute("books", books);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}
