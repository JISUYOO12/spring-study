package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.service.*;


/*
 * 
 * 
 * 	private int fno,hit,score;
	private String name,type,phone,addrss,theme,poster,images,time,parking,content,price;
 * 
 * */
/*
@Controller
public class FoodController {
   @Autowired
   private FoodService service; // 자동 주입 (주소값)

   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model)
   {	FoodVO vo=service.foodDetailData(fno);
	   model.addAttribute("vo",vo);
	   model.addAttribute("main_jsp", "../food/detail.jsp");
	   return "main/main";
   }
   @RequestMapping("food/find.do")
   public String food_find_do(String page,String fd,Model model)
   {
	   Map map=CommonsPagination.pageconfig(page, 12);
	   int curpage=(int)map.get("curpage");
	   if(fd==null)
		   fd="한식";
	   map.put("fd", fd);
	   List<FoodVO> list=service.foodFindData(map);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   int totalpage=service.foodFindTotalPage(map);
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("fd", fd); 
	   
	   model.addAttribute("main_jsp", "../food/find.jsp");
	   return "main/main";
   }
   
}
/*
 *    // request => Model을 이용해서 전송 
	   Map map=CommonsPagination.pageConfig(page, 12);
	   //            => request가 포함 
	   int curpage=(int)map.get("curpage");
	   // map => start/end 
	   if(fd==null)
		   fd="감자";
	   map.put("fd", fd);
	   List<RecipeVO> list=service.recipeFindData(map);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   int totalpage=service.recipeFindTotalPage(map);
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("fd", fd); // JSP(X) => Ajax , Vue
	   
	   model.addAttribute("main_jsp", "../recipe/find.jsp");
	   return "main/main";
 * */
 