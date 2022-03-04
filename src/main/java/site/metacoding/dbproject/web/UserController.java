package site.metacoding.dbproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class UserController {
    

    //회원가입 '페이지'를 주는것 (정적) - 로그인 X (인증 필요 없는 페이지)
    @GetMapping("/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    //회원가입 (액션을 하는 것) - 로그인 X
    @PostMapping("/join") 
    public String join(){
        return "redirect:/user/loginForm"; //postController 만들고 수정
    }
    //로그인 페이지 (정적) - 로그인 자체 컨트롤러 필요 - 로그인 X
    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    //SELECT * FROM user WHERE username=? AND password=?
    //원래 SELECT 는 무조건 get 요청이나 로그인만 예외로 POST이다
    //이유: 주소에 패스워드를 남길 수 없기 때문 
    //- 로그인 X
    @PostMapping("/login") //인증이 필요하기 때문에 login으로 
    public String login(){
        return "메인페이지를 돌려주면 됨"; //postController 만들고 수정
    }

    //유저상세 페이지 (동적 - 반드시 DB연결이 필요) - 로그인 O (인증 필요)
    @GetMapping("/user/{id}")
    public String detail(@PathVariable Integer id){
        return "user/detail";
    }

    //유저 수정 페이지
    @GetMapping("/user/updateForm")
    public String updateForm(){
        return "user/updateForm";
    }
    
    //유저 수정을 수행 - 로그인 O (인증 필요)
    @PutMapping("/user/{id}")
    public String update(@PathVariable Integer id){
        return "redirect:/user/";
    }

    //로그아웃 - 로그인 O (인증 필요)
    @GetMapping("/logout")
    public String logout(){
        return "메인페이지를 돌려주면 됨"; //postController 만들고 수정
    }
}
