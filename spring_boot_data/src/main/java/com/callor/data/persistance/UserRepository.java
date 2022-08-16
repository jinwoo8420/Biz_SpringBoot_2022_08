package com.callor.data.persistance;

/*
자동 import : alt + enter
import 최적화 : ctrl + alt + o
 */
import com.callor.data.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Spring-data(JPA)에서는 JapRepository를 Generic 방식으로 상속받아 사용한다
 */
public interface UserRepository extends JpaRepository<UserVO,Long> {

}
