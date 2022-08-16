package com.callor.data.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

// VO 클래스를 JPA의 Data Table화 하기 위한 선언
@Entity // Entity 설계를 위한 도구라는 선언

/*
bootDB라는 DB에 UserVO를 참조한 tbl_users라는 table이 있다고 가정 또는 강제 생성
 */
@Table(name="tbl_users", schema = "bootDB")
public class UserVO {
    // seq BIGINT AUTO_INCREMENT 설정
    @Id // seq 칼럼이 PK라는 선언
    // MySQL Auto_Increment 설정을 하여 Seq 값을 관리
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    // username VARCHAR(20) NOT NULL UNIQUE
    @Column(columnDefinition = "VARCHAR(20)",nullable = false,unique = true)
    private String username;

    // DB 종류에 관계없이 문자열 255자로 설정 / NOT NULL 설정
    @Column(length = 255,nullable = false)
    private String password;

    @Column(length = 125)
    private String email;

    @Column(length = 20)
    private String phone;

    // @Column을 지정하지 않으면 String형의 경우 문자열(VARCHAR) 255를 default로 설정
    private String addr;

    @Column(length = 20)
    private String realname;
}
