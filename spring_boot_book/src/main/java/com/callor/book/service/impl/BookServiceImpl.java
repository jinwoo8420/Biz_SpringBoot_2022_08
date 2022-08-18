package com.callor.book.service.impl;

import com.callor.book.model.BookVO;
import com.callor.book.persistance.BookDao;
import com.callor.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookVO> selectAll() {
        // 조건에 관계없이 데이터를 모두 SELECT
        List<BookVO> bookList = bookDao.findAll();

        return bookList;
    }

    @Override
    public BookVO findById(String isbn) {
        return null;
    }

    @Override
    public int insert(BookVO bookVO) {
        log.debug("데이터 {}", bookVO);

        /*
        mybatis에서는 insert를 수행한 후 int 값을 return한다
        이때 return하는 값은 몇개의 데이터가 추가 되었는지를 알려준다
        하지만 Spring-Data(JPA)에서는 save를 실행 후 다시 자기 자신을(save를 실행한 데이터) return한다

        Spring-Data에서는 CRUD에서 INSERT와 UPDATE를 별도로 구분하지 않는다

        save() method에 VO를 전달 시
        1. 먼저 PK를 기준으로 데이터를 SELECT하여 table에 데이터가 있는지 검사한다
        2. 만약 table에 PK에 해당하는 데이터가 없으면 INSERT 수행
        3. 만약 table에 PK에 해당하는 데이터가 있으면 UPDATE 수행
         */

        BookVO result = bookDao.save(bookVO);

        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        return 0;
    }

    @Override
    public int delete(String isbn) {
        return 0;
    }

    @Override
    public List<BookVO> findByTitle(String title) {
        return null;
    }

    @Override
    public List<BookVO> findByCompany(String comp) {
        return null;
    }

    @Override
    public List<BookVO> findByAuthor(String author) {
        return null;
    }
}
