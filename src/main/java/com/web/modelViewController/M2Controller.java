package com.web.modelViewController;

import com.web.entity.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/")
public class M2Controller {
    @GetMapping("/showForm")
    public String showForm(){
        return "createProduct";
    }
    //receive data from form
    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute("product")Product product){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        modelAndView.addObject(product);
        return modelAndView;
    }
    //receive data from request param /m2?name=kia&id=23
    @GetMapping("/createRequestParam")
    public ModelAndView createProductRequestParam(
            @RequestParam("name") String name,
            @RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        modelAndView.addObject(new Product(id, name));
        return modelAndView;
    }
    //receive data from path param /m2/23
    @GetMapping("/p/{id}")
    public String  getPath(@PathVariable("id") int id){
        System.out.println(id);
        return "home";
    }
    //receive data from header
    @GetMapping("/headers")
    public String getHeader(@RequestHeader Map<String, String> headers){
        System.out.println(headers);
        return "home";
    }
    @GetMapping("/headers2")
    public String getHeader2(@RequestHeader HttpHeaders headers){
        long contentLength = headers.getContentLength();
        System.out.println(contentLength);
        System.out.println(headers);
        return "home";
    }
    //get data from matrix
    //first of all we need a new config in webConfig which override configurePathMatch
    //setRemoveSemicolonContent set to false
    @GetMapping("/matrix/{name}")
    public String matrixVariable(@PathVariable String name, @MatrixVariable int id)
    {
        System.out.println(id);
        return "home";
    }
    @GetMapping("/matrix2/{name}/{critical}")
    public String twoMatrixVariable(
            @PathVariable String name,
            @PathVariable String critical,
            @MatrixVariable(name = "id",pathVar = "name") int id,
            @MatrixVariable(name = "code",pathVar = "name") int code,
            @MatrixVariable(name = "cc",pathVar = "critical") int cc)
    {
        System.out.println(id);
        System.out.println(code);
        System.out.println(cc);
        return "home";
    }

    //get cookie
    @GetMapping("/cookie")
    public String getCookie(@CookieValue(value = "name" /*, required = false*/, defaultValue = "dd") String name){
        System.out.println(name);
        return "home";
    }
    //set cookie --
    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse res){
        Cookie cookie = new Cookie("name" , "kiabala");
        res.addCookie(cookie);
        return "home";
    }





}
