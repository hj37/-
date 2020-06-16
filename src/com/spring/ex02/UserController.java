package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//MVC�� C

// action-servlet2.xml���������� userMethodNameResolver������Ƽ�� ����Ϸ��� 
//�ݵ�� ~ MultiActionControllerŬ������ ��� �޴� ���·� UserControllerŬ������ �������� 
public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		
		String userID = "";
		String passwd = "";
		
		ModelAndView mav = new ModelAndView();
		
		//�ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		//��û�� �� ��� 
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		
		//���������� �Է��� ������ ���� �ϱ� ���� �ӽ÷� ~ ModelAndView��ü�� ���� 
		mav.addObject("userID", userID);
		mav.addObject("passwd",passwd);
		//Ȯ���ڸ��� ������ ���̸� ���� 
		mav.setViewName("result");
		
		//����ó �������� ��ȯ�� action-servlet2.xml�� InternalResourceViewResolver���� 
		//result�� �����ؼ� ... /test/result.jsp ���θ� ���� 
		//����ó �������� �ּҸ� ������ ��� �̵�~�Ͽ� ��� 
		return mav;
	}
		
	
}
