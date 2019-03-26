package com.thymeleaf.example.controller;

import com.thymeleaf.example.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("hi")
//    @ResponseBody
    public String sayHello(HttpServletRequest httpRequest, Model model) {
        String name = httpRequest.getParameter("name");

        if (name == null) {
            name = "world";
        }
        model.addAttribute("name", name);
//        return "<h1>" + "hello " + name + "</h1>" ;
        return "hi";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String renderForm() {
        return "hello";
    }

    @RequestMapping(value = "sayHi", method = RequestMethod.POST)
    public String sayHelloForm(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");

        if (name == null) {
            name = "world";
        }
        model.addAttribute("name", name);
        model.addAttribute("title", "new title");
        return "hi";
    }

    @RequestMapping(value = "ifElse", method = RequestMethod.GET)
    public String checkIfElse() {
        return "conditionTest";
    }

    @RequestMapping(value = "unless", method = RequestMethod.GET)
    public String checkUnless() {
        return "unlessTest";
    }


    @RequestMapping(value = "loop", method = RequestMethod.GET)
    public String checkLoop() {
        return "loop";
    }

    @RequestMapping(value = "loop1", method = RequestMethod.GET)
    public String checkLoop1() {
        return "loop1";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String fetchuserList(Model model) {
        List<User> users = Arrays.asList(new User("jane", "smith"), new User("hanna", "helin"), new User("oskar", "jekin"));
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "competency", method = RequestMethod.GET)
    public String fetchCompetency(Model model) {
        return "competency";
    }

    @RequestMapping(value = "usersAjax", method = RequestMethod.GET)
    @ResponseBody
    public List<User> fetchuserListAjax(Model model) {
        List<User> users = Arrays.asList(new User("jane", "smith"), new User("hanna", "helin"), new User("oskar", "jekin"));
        model.addAttribute("users", users);
        return users;
    }


    @RequestMapping(value = "ajaxTest", method = RequestMethod.GET)

    public String ajaxTest(Model model) {
        return "ajaxTest";
    }


}