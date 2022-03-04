package site.metacoding.dbproject.domain.post;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.metacoding.dbproject.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Post {
    
    @Id //id를 PK로 인식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 300 , nullable = false)
    private String tittle;

    @Lob //CLOB 4GB 문자타입
    @Column(nullable = false)
    private String content;

    @JoinColumn(name = "userid")
    @ManyToOne
    private User user;

    private LocalDate createDate;
}
