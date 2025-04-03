package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

/*
 * 
 * 
 * 
	private int fno;
	private String poster,name,type,address,price;;
 * */
public interface FoodMapper {
	@Select("SELECT fno,poster,name,type,price,num "
			+"FROM (SELECT fno,poster,name,type,price,rownum as num "
			+"FROM (SELECT /* +INDEX_ASC(food_menupan fm_fno_pk)*/ fno,poster,name,type,price "
			+"FROM food_menupan)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+"FROM food_menupan ")
	public int foodTotalPage();
	

	@Select("SELECT * FROM food_menupan "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
			
	@Select("SELECT fno,poster,name,type,price,num "
			+"FROM (SELECT fno,poster,name,type,price,rownum as num "
			+"FROM (SELECT /* +INDEX_ASC(food_menupan fm_fno_pk)*/ fno,poster,name,type,price "
			+"FROM food_menupan WHERE type LIKE '%'||#{fd}||'%' "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	
	@Select("SELECT * FROM food_menupan "
			+"WHERE fno=#{fno}"
			+"WHERE REGEXP_LIKE(type,#{fd})")
	public FoodVO foodFindTotalPage(Map map);
	
	
	/*
	 * 
	 *  <select id="recipeFindData" resultType="com.sist.vo.RecipeVO" parameterType="hashmap">
    SELECT no,poster,title,chef,num 
    FROM (SELECT no,poster,title,chef,rownum as num
    FROM (SELECT no,poster,title,chef 
    FROM recipe WHERE title LIKE '%'||#{fd}||'%' 
    AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)))
    WHERE num BETWEEN #{start} AND #{end}
  </select>
  <select id="recipeFindTotalPage" resultType="int"
   parameterType="hashmap"
  >
    SELECT CEIL(COUNT(*)/12.0) FROM recipe
    WHERE REGEXP_LIKE(title,#{fd}) 
    AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
  </select>
	 * */


}
