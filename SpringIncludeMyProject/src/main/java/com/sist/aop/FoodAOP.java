package com.sist.aop;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect // 메모리 할당 (X) => 공동 모듈 
@Component
public class FoodAOP {
	
	 @After("execution(* com.sist.web.*Controller.*(..))")
	   public void after()
	   {
		   // 현재 사용중인 request를 가지고 온다 
		   HttpServletRequest request=
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
	   }
	   @Around("execution(* com.sist.web.*Controller.*(..))")
	   public Object around(ProceedingJoinPoint jp) throws Throwable
	   {
	   
		   Object obj=null;
		   System.out.println("사용자 요청:"+jp.getSignature().getName());
		   obj=jp.proceed();
		   System.out.println("요청 처리 완료");
		   return obj;
		   
	   }
}
