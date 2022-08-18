package com.callor.book.service;

import com.callor.book.model.BookVO;

import java.util.List;


public interface BookService {
    public List<BookVO> selectAll();

    public BookVO findById(String isbn);

    public int insert(BookVO bookVO);

    public int update(BookVO bookVO);

    public int delete(String isbn);

    public List<BookVO> findByTitle(String title);

    public List<BookVO> findByCompany(String comp);

    public List<BookVO> findByAuthor(String author);
}
