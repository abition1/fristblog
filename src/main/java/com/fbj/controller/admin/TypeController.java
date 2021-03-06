package com.fbj.controller.admin;

import com.fbj.pojo.Type;
import com.fbj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PublicKey;

@Controller
public class TypeController {
    @Autowired
    TypeService  typeService;

@RequestMapping("/types")
//通过@PageableDeafault来对分页数据的控制
    public String  Pagelist(@PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
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
public  String  addtypes(Type type, RedirectAttributes redirectAttributes, BindingResult result, Model model){
    Type type1=  typeService.getTypeByName(type.getName());
    if (type1!=null){
result.rejectValue("name","nameError","不能添加重复的类");
    }
    if(result.hasErrors()){
        model.addAttribute("errormessage","该分类已经存在");
  return "admin/addtype";
    }
   Type type2=   typeService.saveType(type);
    if (type2==null){
        redirectAttributes.addFlashAttribute("message","新增失败");
    }else {
        redirectAttributes.addFlashAttribute("message","新增成功");
    }
     return  "redirect:/types";
    }
   @GetMapping("/gettype/{id}")
    public String  getType(@PathVariable Long id,Model model){
      Type type= typeService.getType(id);
      model.addAttribute("infos",type);
      return "admin/updatetype";
   }
   @RequestMapping("/update")
    public String update(Type type,BindingResult result,Model model){
       Type type2=  typeService.saveType(type);
       Type type1=typeService.getTypeByName(type2.getName());
       if (type1!=null){
           result.rejectValue("name1","nameError2","不能添加重复的类");
       }
       if(result.hasErrors()){
           model.addAttribute("uperrormessage","该分类名已经存在");
           return "redirect:/types";
       }
return "redirect:/types";
   }



}
