package com.web.modelViewController;

import com.web.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/a1")
public class M1Contrioller
{
    @GetMapping("/m1")
    public ModelAndView m1(){
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        model.addObject("name" , "kia");
        return model;
    }
    @GetMapping("/m2")
    public String m2(HttpServletRequest request , Model model){
        var name = request.getParameter("name");
        model.addAttribute("name" , name);
        return "home";
    }
    @GetMapping("/m3")
    public String m3(Model model){
        //something like service
        Product p1 = new Product(1, "kia");
        Product p2 = new Product(2, "kia2");
        Product p3 = new Product(3, "kia3");
        List<Product> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        //add to model
        model.addAttribute("list" , pList);
        return "productList";
    }

}
