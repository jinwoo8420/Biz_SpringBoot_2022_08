package com.callor.book.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_users")
public class UserVO implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    private String email;
    private String realname;

    @Transient // table을 생성 할 때 만들지 않고 VO에서만 사용
    Collection<? extends GrantedAuthority> authorities;

    /*
    @OneToMany : tbl_authorities와 1:N 관계 선언
    자동으로 tbl_users 테이블을 SELECT할 때
    tbl_authorities 테이블도 같이 SELECT 하여 하나의 묶음으로 만듦

    UserVO(tbl_users)와 UserRole(tbl_authorities)끼리 FK설정이 자동으로 형성
    CascadeType.REMOVE : tbl_users 테이블에서 데이터를 DELETE하면
    tbl_authorities 테이블에 연관된 데이터 삭제

    tbl_users 테이블을 SELECT하고 시간을 지연시킨 후
    tbl_authorities 테이블을 SELECT
    fetch = FetchType.LAZY

    List<UserRoles> 타입으로 지정해도 되지만 Set<UserRoles> 타입으로 지정한 이유
    List와 Set은 많이 비슷하지만 Set이 List보다 검색속도가 매우 빠름

    Set은 중복된 데이터를 허용하지 않음
    만약 중복된 데이터를 add하면 원래 있던 데이터를 update

    Set을 생성 할 때 HashSet을 사용하면 데이터가 add한 순서대로 저장되지 않음
    add한 데이터의 순서를 보장하려면
    Set<String> strSet = new LinkedHashSet<String>()을 사용하여 객체 초기화
     */
    @OneToMany(mappedBy = "userVO", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<UserRole> userRoles;
}
