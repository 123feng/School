package com.iflytek.tms.controller;

import com.iflytek.tms.pojo.Menu;
import com.iflytek.tms.pojo.User;
import com.iflytek.tms.service.MenuService;
import com.iflytek.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author XiaoFeng
 * @date 2019/4/26 - 13:38
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("tologin")
    public  String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public  String  login(User u, HttpSession session, Model model){

        User user = userService.getUserByNameAndPass(u);
        if (user == null) {
            model.addAttribute("msg","用户名或密码不正确");
            return  "login";

        }
        else {
            session.setAttribute("user",user);
        }
        return  "redirect:main";

    }
    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return  "updateuser";
    }
    @RequestMapping("update")
    public void updateUser(User user) {
       userService.updateUser(user);
    }


    @RequestMapping("exitSession")
    public String  exitSession(HttpSession session) {
        session.invalidate();
        return  "login";
    }

    @RequestMapping("editPassword/{id}")
    public String editPassword(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return  "updatepassword";
    }
    @RequestMapping("updatepassword")
    public String updatePassword(User user) {
        userService.updatePassword(user);
        System.out.println("修改成功");
        return "redirect:tologin";
    }





    @RequestMapping("main")
    public  String menuIndex(HttpSession session, Model model){
        User user= (User) session.getAttribute("user");
        List<Menu> menuList=menuService.getAllMenu(0,0);


        for (Menu menu : menuList) {
            List<Menu> menus = menuService.getAllMenu(user.getAuth(),menu.getId());
            menu.setMenus(menus);
        }
        model.addAttribute("menuList",menuList);
        return  "index";
    }




}
