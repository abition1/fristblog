package com.fbj.controller.admin;

import com.fbj.pojo.Type;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;

@Controller
public class TypeController {
    @Autowired
    TypeService  typeService;

@RequestMapping("/types")
//通过@PageableDeafault来对分页数据的控制
    public String  Pagelist(@PageableDefault(size = 10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
       model.addAttribute("pages",typeService.listType(pageable));
      return  "admin/types" ;

}

    @RequestMapping("/delete/{id}")
   public String  delete(@PathVariable Long id){
       typeService.deleteType(id);
       return   "redirect:/types";
    }

@GetMapping("/addtype")
    public String  addtype(){
    return "admin/addtype";
    }

    @PostMapping("/addtypes")
public  String  addtypes(Type type){

     typeService.saveType(type);
     return  "redirect:/types";
    }
   @GetMapping("/gettype/{id}")
    public String  getType(@PathVariable Long id,Model model){
      Type type= typeService.getType(id);
      model.addAttribute("infos",type);
      return "admin/updatetype";
   }
   @PostMapping("/update")
    public String update(Type type){
     typeService.saveType(type);
return "redirect:/types";
   }

}
