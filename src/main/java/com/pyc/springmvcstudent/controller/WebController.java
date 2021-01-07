//IntelliJ IDEA
//springmvcstudent
//WebController
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.springmvcstudent.controller;


import com.pyc.springmvcstudent.dao.UserInfoRepository;
import com.pyc.springmvcstudent.dao.UserRepository;
import com.pyc.springmvcstudent.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    final UserRepository userRepository;
    final UserInfoRepository userInfoRepository;

    public WebController(UserRepository userRepository,UserInfoRepository userInfoRepository){
        this.userInfoRepository=userInfoRepository;
        this.userRepository=userRepository;
    }
    @RequestMapping("/toSign")
    public String toSign(Model model){
        Msg msg = new Msg("系统提示","请按照格式进行注册");
        model.addAttribute("msg", msg);
        return "page/Sign";
    }
}
