package com.callor.book.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_authorities")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
    private long seq;

    private String username;
    private String rolename;

    /*
    두 테이블을 1:N 관계로 설정 할 경우
    Master 클래스에 @OneToMany를 설정하고
    관계 연결되는 클래스에 ManyToOne을 설정해줘야 함

    name : UserRole.username 칼럼과
    referencedColumName : UserVO.username 칼럼을 서로 연결
    insertable = false , updatable = false : tbl_users, tbl_authroities 테이블에 insert, update가 발생 할 경우
    동시에 실행 X / 읽기 전용으로 사용
     */
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserVO userVO;
}
