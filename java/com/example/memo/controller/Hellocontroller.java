package com.example.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","yeongchan");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model){//requestparam안의 name 이라는 값은 url뒤에 name이라는 매개변수를 받고
        //그 변수 name은 곧 key값이 되고 name= (value)의 value부분이 String name이 되는 것이다. 
        model.addAttribute("name", name);
        return "hello-mvc";
    } 

    @GetMapping("hello-string")
    @ResponseBody //다음 어노테이션이 추가되면서 컨트롤러에서 view resolver로(Resources의 template나 static 폴더로 가지 않음)가지 않고 곧바로 
    //http의 바디부로 이동. 그렇기 때문에 페이지 소스 보기를 선택해도 html코드가 나오지 않음.
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;//view를 거치지 않기 때문에 여기서 return값은 매핑할 html파일명이 아닌 실제 출력될 문자를 입력.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        

    }
}
