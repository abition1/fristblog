package com.fbj.controller.admin;

import com.fbj.pojo.Link;
import com.fbj.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LinkController {

    @Autowired
    LinkService linkService;

    @RequestMapping("/listlink")
//通过@PageableDeafault来对分页数据的控制
    public String linkList(@PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("pages",linkService.listLink(pageable));
        return  "admin/link";
    }

   @RequestMapping("/savelink")
    public  String  saveLink(Link link){
        linkService.saveLink(link);
       return  "redirect:/listlink";
   }
   @RequestMapping("/ret")
public  String  jump(){
        return  "admin/addlink";
   }
@RequestMapping("/deletelink/{id}")
    public String deleteLink(@PathVariable Long id){
linkService.deleteLink(id);
    return  "redirect:/listlink";
}



@RequestMapping("/getlink/{id}")
    public String update(@PathVariable Long id,Model model){
    Link linkType = linkService.getLinkType(id);
    model.addAttribute("infos",linkType);
    return "admin/updatelink";
}
    @RequestMapping("/updatelink")
    public String updateLink(Link link){
       linkService.saveLink(link);
        return  "redirect:/listlink";

    }


}
