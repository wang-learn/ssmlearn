package com.ssmlearn.wang.web;

import com.google.gson.Gson;
import com.ssmlearn.wang.dto.AppointExecution;
import com.ssmlearn.wang.dto.Result;
import com.ssmlearn.wang.entity.Book;
import com.ssmlearn.wang.enums.AppointStateEnum;
import com.ssmlearn.wang.exception.NoNumberException;
import com.ssmlearn.wang.exception.RepeatAppointException;
import com.ssmlearn.wang.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 1：在前台要解析获得的json数据，转换为string类型数据。则js方法eval();
     *
     * 2:springmvc返回json数据用@ResponseBody，前台就可以直接获得数据，
     * 前提是在springmvc中要进行配置json转换配置，在项目中引入jackson jar包。
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList();
        String lists = "asfdsaf";

        model.addAttribute("list", new Gson().toJson(list));
        model.addAttribute("lists", new Gson().toJson(list));
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    //ajax json
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new Result<AppointExecution>(false, "学号不能为空");
        }
        //AppointExecution execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }
}
