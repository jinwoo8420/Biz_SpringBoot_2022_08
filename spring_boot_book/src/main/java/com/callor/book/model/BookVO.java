package com.callor.book.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
도서 정보 관리를 위한 객체 추상화
도서명, 출판사, 저자, 출판일, 가격 등의 항목 필요

JPA의 Entity로 등록하고 물리적 table로 구성
 */

@Entity
@Table(name="tbl_books", schema = "bootdb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookVO {
    @Id // VO 클래스를 Entity로 등록하면 반드시 PK 항목을 지정해 주어야 한다

    /*
    isbn처럼 규칙, 규격에 의해 자릿수가 정해진 문자열이 존재한다
    이때는 규격에 맞는 문자열을 최소한으로 지정하는 것이 좋다
     */
    @Column(length = 13)
    private String isbn; // 도서코드

    @Column(length = 125,nullable = false)
    private String title; // 도서명
    private String comp; // 출판사
    private String author; // 저자

    @Column(length = 10)
    private String pubdate; // 출판일

    @Column(nullable = true)
    private int price; // 정가
}
