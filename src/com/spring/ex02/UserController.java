package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//MVC중 C

// action-servlet2.xml설정파일의 userMethodNameResolver프로퍼티를 사용하려면 
//반드시 ~ MultiActionController클래스를 상속 받는 형태로 UserController클래스를 만들어야함 
public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		
		String userID = "";
		String passwd = "";
		
		ModelAndView mav = new ModelAndView();
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		//요청한 값 얻기 
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		
		//뷰페이지로 입력한 정보를 전달 하기 위해 임시로 ~ ModelAndView객체에 저장 
		mav.addObject("userID", userID);
		mav.addObject("passwd",passwd);
		//확장자명을 제외한 뷰이름 저장 
		mav.setViewName("result");
		
		//디스팩처 서블릿으로 반환후 action-servlet2.xml의 InternalResourceViewResolver에게 
		//result를 전달해서 ... /test/result.jsp 뷰경로를 만들어서 
		//디스팩처 서블릿으로 주소를 전달후 뷰로 이동~하여 출력 
		return mav;
	}
		
	
}
