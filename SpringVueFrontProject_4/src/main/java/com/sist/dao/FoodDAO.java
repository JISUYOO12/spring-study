package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(int start,int end)
	{
	return mapper.foodListData(start, end);	
	}
	public int foodTotalPage() 
	{
		return mapper.foodTotalPage();
	}
	public List<FoodVO> foodFindListData(Map map)
	{return mapper.foodFindListData(map);
	}
}
