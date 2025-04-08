package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {

	/*
	 *    private int fno,hit,jjimcount,likecount,replycount;
   private double score;
   private String name,type,phone,address,theme,
           poster,images,time,parking,content,price,rdays;
   */
	@Select("SELECT fno,poster,name,num "
			+"FROM (SELECT fno,poster,name,rownum as num "
			+"FROM (SELECT /*+INDEX_ASC(project_food pf_fno_pf)*/fno,poster,name "
			+"FROM project_food ))"
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	@Select("SELECT fno,poster,name,num "
			+"FROM (SELECT fno,poster,name,rownum as num "
			+"FROM (SELECT /*+INDEX_ASC(project_food pf_fno_pf)*/fno,poster,name "
			+"FROM project_food WHERE address LIKE '%'||#{fd}||'%' "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
}
