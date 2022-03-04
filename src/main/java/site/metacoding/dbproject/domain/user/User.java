package site.metacoding.dbproject.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//JPA 라이브러리 = Java Persistence API (자바언어를 이용하여 DB에 영구적으로 저장할 수 있게 하는 메서드 )
//1.CRUD 메서드 기본 제공
//2.자바코드로 DB 자동생성기능 제공
//3.ORM 제공 (지금 몰라도 됨)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity // 서버실행시 해당클래스로 테이블을 생성하라는 어노테이션
public class User {

    
    //identity 전략은 DB에 번호증가 전략을 위임 -> 알아서 DB에 맞게 찾아줌
    @Id //id를 PK로 인식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(length = 12 , nullable = false)
    private String password;

    @Column(length = 16000000)
    private String email;

    private LocalDateTime createDate;

}
 