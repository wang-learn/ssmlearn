package com.ssmlearn.wang.dao;

import com.ssmlearn.wang.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**\
 * 这里为什么要给方法的参数添加@Param注解呢？
 * 是因为该方法有两个或以上的参数，一定要加，不然mybatis识别不了。
 * 这里不需要实现dao接口不用编写daoImpl， mybatis会给我们动态实现，
 * 但是我们需要编写相应的mapper
 */
public interface BookDao {
    /**
     * 通过ID查询单本图书
     *
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);

}
