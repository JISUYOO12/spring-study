package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
@Autowired
private FoodDAO dao;
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
	return dao.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return dao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindTotalPage(map);
	}

	
}