package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.commons.*;
import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class MainController {
	@Autowired
	private FoodService service;
    @GetMapping("main/main.do")
    public String main_main(String page,Model model)
    {
    	Map map=CommonsPagination.pageconfig(page, 12);
    	List<FoodVO> list=service.foodListData(map);
    	int totalpage=service.foodTotalPage();
    	int curpage=(int)map.get("curpage");
    	
    	final int BLOCK=10;
    	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
    	
    	model.addAttribute("list", list);
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("startPage", startPage);
    	model.addAttribute("endPage", endPage);
    	
    	model.addAttribute("main_jsp", "../main/home.jsp");
    	   // kList
    	return "main/main";
    }
}
