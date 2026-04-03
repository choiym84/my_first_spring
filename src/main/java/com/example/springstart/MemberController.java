package com.example.springstart;

import com.example.springstart.domain.Member;
import com.example.springstart.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String joinMember() {
        return "form";
    }

    @PostMapping("/new")
    public String joinMember(MemberForm name) {
//        System.out.println(name);
        service.join(new Member(0L, name.getName()));
        return "redirect:/member/members";
    }

    @GetMapping("/members")
    public String findMembers(Model model) {
        List<Member> members = service.findMembers();
        model.addAttribute("members", members);
        return "members";
    }

}
