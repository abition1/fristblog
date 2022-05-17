package com.fbj.service;

import com.fbj.pojo.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface LinkService {

    Page<Link>  listLink(Pageable pageable);

    Link  saveLink(Link link);
   void   deleteLink(Long  id);

   Link  getLinkType(long id);
}
