package com.ssmlearn.wang.services.impl;

import com.ssmlearn.wang.BaseTest;
import com.ssmlearn.wang.dto.AppointExecution;
import com.ssmlearn.wang.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1003;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }
}
