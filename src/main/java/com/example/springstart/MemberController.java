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
    public String joinMember(@ModelAttribute MemberForm form, Model model) {

        try{
            service.join(new Member(0L, form.getName()));

        }catch(IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("errorType", "duplicate input");
            model.addAttribute("memberForm", form);
            return "form";
        }catch(IllegalArgumentException e){
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("errorType", "wrong input");
            return "form";
        }
        return "redirect:/member/members";
    }

    @GetMapping("/members")
    public String findMembers(Model model) {
        List<Member> members = service.findMembers();
        model.addAttribute("members", members);
        return "members";
    }

}
