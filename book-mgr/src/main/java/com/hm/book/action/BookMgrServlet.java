package com.hm.book.action;

import com.hm.book.bean.Book;
import com.hm.book.bean.Category;
import com.hm.book.service.BookService;
import com.hm.book.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: bookmgr
 * @Date: 2019/7/3 14:50
 * @Author: Mr.Han
 * @Description:
 */
@WebServlet("/back")
public class BookMgrServlet extends HttpServlet {
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
//  super.service(req, resp);
  this.request = req;
  this.response = resp;
  String method = request.getParameter("method");
  switch (method) {
   case "getIndex":
    displayIndex();
    break;
   case "toAddCategory":
    toAddCategory();
    break;
   case "addCategory":
    addCategory();
    break;
   case "toAddBook":
    toAddBook();
    break;
   case "addBook":
    addBook();
    break;
   case "toBookList":
    toBookList();
    break;
  }
 }

 private void toBookList() {
//  List<Book> books = bookService.findBooksByCid();

 }

 /**
  * 添加图书
  */
 private void addBook() {

  if (ServletFileUpload.isMultipartContent(request)) {
   try {
    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload fileUpload = new ServletFileUpload(factory);
    List<FileItem> itemList = fileUpload.parseRequest(request);

    int index = 0;
    String url = "";
    List<Book> books = new ArrayList<>();
    Book book = new Book();
    for (FileItem fileItem : itemList) {
     if (index != 0 && index % 5 == 0) {
      book.setCreateTime(new Date());
      book.setUpdateTime(new Date());
      books.add(book);
     }
     index++;
     //普通表单项
     if (fileItem.isFormField()) {
      String fieldName = fileItem.getFieldName();
      if ("categoryId".equals(fieldName)) {
       book.setCategoryId(Long.valueOf(fileItem.getString()));
      } else if ("name".equals(fieldName)) {
       book.setName(fileItem.getString());
      } else if ("level".equals(fieldName)) {
       book.setLevel(Integer.valueOf(fileItem.getString()));
      } else if ("price".equals(fieldName)) {
       book.setPrice(Integer.valueOf(fileItem.getString()));
      }
     } else {
      //文件上传项
      String itemName = fileItem.getName();
      if (itemName != null && !itemName.equals("")) {
       String sysPath = request.getSession().getServletContext().getRealPath("/resources/img");
       // 定义一个新的图片名称
       String fileName = UUID.randomUUID().toString();
       //  提取图片的类型
       // 获取上传文件的后缀名
       String suffix = itemName.substring(itemName.lastIndexOf("."));
       fileName += suffix;
       url = fileName;
       fileItem.write(new File(sysPath + "/" + fileName));
      }
     }
     book.setImgPath(url);
    }
    books.add(book);
    bookService.addBooks(books);
    request.setAttribute("tip", "图书增加成功");
    displayIndex();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }

 /**
  * 去添加图书界面
  */
 private void toAddBook() throws ServletException, IOException {
  List<Category> categories = categoryService.findAllCategores();
  request.setAttribute("categories", categories);
  request.getRequestDispatcher("/WEB-INF/jsp/add_book.jsp").forward(request, response);

 }

 /**
  * 预览增加分类
  */
 private void toAddCategory() throws ServletException, IOException {
  request.getRequestDispatcher("/WEB-INF/jsp/add_category.jsp").forward(request, response);
 }

 /**
  * 添加图书分类
  */
 private void addCategory() throws ServletException, IOException {

  String name = request.getParameter("name");
  if (StringUtils.isEmpty(name)) {
   request.setAttribute("tip", "请输入名称");
   toAddCategory();
   return;
  }
  Category category = new Category();
  category.setName(name);
  categoryService.addCategory(category);
  request.setAttribute("tip", "图书分类添加成功");
  displayIndex();
 }

 /**
  * 展示主页
  */
 private void displayIndex() throws ServletException, IOException {
  List<Category> categories = categoryService.findAllCategores();
  request.setAttribute("categories", categories);
  request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
 }

 private String getSmallPicPath(Part part) {
  try {
   // 如果用户上传了这里代码是不会出现异常 了
   // 如果没有上传这里出现异常
//   Part part = request.getPart("smallImg");
   // 保存到项目的路径中去
   String sysPath = request.getSession().getServletContext().getRealPath("/resources/img");
   // 定义一个新的图片名称
   String fileName = UUID.randomUUID().toString();
   //  提取图片的类型
   // 上传文件的内容性质
   String contentDispostion = part.getHeader("content-disposition");
   // 获取上传文件的后缀名
   String suffix = contentDispostion.substring(contentDispostion.lastIndexOf("."), contentDispostion.length() - 1);
   fileName += suffix;
   // 把图片保存到路径中去
   part.write(sysPath + "/" + fileName);
   return fileName;
  } catch (Exception e) {
   e.printStackTrace();
   return null;
  }
 }

}
