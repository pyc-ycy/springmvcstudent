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
import com.pyc.springmvcstudent.domain.User;
import com.pyc.springmvcstudent.domain.UserInfo;
import com.pyc.springmvcstudent.function.OptPassword;
import org.springframework.data.repository.query.Param;
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
    @RequestMapping("/sign")
    public String Sign(Model model, @Param("stuID")String stuID,
                       @Param("password")String password,
                       @Param("stuName")String stuName,
                       @Param("profession")String profession,
                       @Param("stuClass")String stuClass,
                       @Param("broth")String broth,
                       @Param("tel")String tel){
        User u = userRepository.findAllByStudentID(stuID);
        Msg msg = new Msg("","");
        if(u!=null){
            msg.setTitle("错误");
            msg.setContent("该学号已被注册，请将能证明你是该学号拥有者的资料，发送到管理员邮箱：");
            model.addAttribute("msg",msg);
            return "page/Sign";
        }
        try {
            OptPassword op = new OptPassword();
            String encodePassword = op.encrypt(password);
            User user = new User(stuID, encodePassword);
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        UserInfo userInfo = new UserInfo(stuID,stuName,profession,stuClass,broth,tel);
        userInfoRepository.save(userInfo);
        msg.setTitle("系统提醒");
        msg.setContent("注册成功，请前往登陆页面登陆");
        model.addAttribute("msg",msg);
        return "page/Sign";
    }
    @RequestMapping("/login")
    public String Login(Model model,@Param("stuID")String stuID,
                        @Param("password")String password){
        User u = userRepository.findAllByStudentID(stuID);
        UserInfo ui = userInfoRepository.findAllByStuID(stuID);
        boolean key=false;
        if(ui.getOnline()==false){
            try{
                OptPassword op = new OptPassword();
                String decodePassword = op.decrypt(u.getPassword());
                if(decodePassword.equals(password))
                {
                   int t= userInfoRepository.setOnlineByStuID(true,stuID);
                   if(t!=0)
                       key=true;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            if(key){
                Msg msg = new Msg("系统信息",ui.getName()+",欢迎使用学生信息管理系统！");
                model.addAttribute("msg",msg);
                return "page/Home";
            }
            Msg msg = new Msg("系统信息","登陆失败！");
            model.addAttribute("msg",msg);
            return "Error";
        }
        Msg msg = new Msg("系统信息","登陆失败,因为当前账号已在其他设备进行登陆");
        model.addAttribute("msg",msg);
        return "Error";
    }
}
