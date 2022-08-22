package com.callor.book.service;

import com.callor.book.model.BookVO;

import java.util.List;


public interface BookService {
    public List<BookVO> selectAll();

    /*
    Spring-Data와 관련된 method에서 findById() method의 return 타입은 Optional<T>이다
    보통 findById()는 1개의 데이터를 SELECT하여 VO에 담아주는 method이다
    그런데 id에 해당하는 데이터가 없을 경우 findById()는 null 값을 return 한다
    null 값을 return 하는 것은 NullPointer Exception을 일으킬 가능성이 있다
    Optional은 null 값이 될만한 데이터를 Optional로 감싸서 null 검사를 조금 쉽게 할 수 있도록 만들어 놓은 타입이다
    실제 데이터를 감싸는 wrapper이면 null 취급을 쉽게 할 수 있도록 하는 도구이다
     */

    public BookVO findById(String isbn);

    public int insert(BookVO bookVO);

    public int update(BookVO bookVO);

    public int delete(String isbn);

    public List<BookVO> findByTitle(String title);

    public List<BookVO> findByCompany(String comp);

    public List<BookVO> findByAuthor(String author);
}
