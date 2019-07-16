package com.xmut.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.xmut.entity.FocusUser;
import com.xmut.entity.User;
import com.xmut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//专门用于跳转到main.jsp页面
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	
	//登录
	@ResponseBody
	@RequestMapping("/login.do")
	public ModelAndView login(String username, String password, HttpServletRequest req, HttpServletResponse rep, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findUser(username, password);
		if (user != null) {
			//登录成功
			session.setAttribute("user", user);
			modelAndView.setViewName("main");
			modelAndView.addObject("user", user);
		} else {
			//登录失败
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
	//查询所有用户
	@RequestMapping("/findAllUser.do")
	public ModelAndView findAllUser(HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		//获取所有用户
		List<User> userList = userService.findAllUser();
		//获取当前登录用户的已关注列表的用户id
		List<FocusUser> focusUserList = userService.showMyFocus(user.getId());
		List<Integer> myFocusUserId = new ArrayList<Integer>();
		for (int i = 0; i < focusUserList.size(); i++) {
			myFocusUserId.add(focusUserList.get(i).getFocus_id());
		}
		
		modelAndView.setViewName("userlist");
		modelAndView.addObject("user", user);
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("myFocusUserId", myFocusUserId);
		return modelAndView;
	}
	
	//添加用户
	@RequestMapping("/addUser.do")
	public String addUser(User user) {

		userService.addUser(user);
		return "success";
	}
	
	//模糊查询，根据用户名查询
	@RequestMapping("/findUserByUsername.do")
	public ModelAndView findUserByUsername(String username) {
		
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList = userService.findUserByUsername(username);
		modelAndView.setViewName("userlist");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	//删除用户
	@ResponseBody
	@RequestMapping("/delUserById.do")
	public String delUserById(int id) {
		
		String msg = "";
		msg = userService.delUserById(id);
		return msg;
	}
	
	//修改用户
	@ResponseBody
	@RequestMapping("/updateUser.do")
	public String updateUser(User user) {

		userService.updateUser(user);
		return "success";
	}
	
	//展示我的关注
	@RequestMapping("/showMyFocus.do")
	public ModelAndView showMyFocus(HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		List<FocusUser> focusUserList = userService.showMyFocus(user.getId());
		List<User> focusUserDetail = new ArrayList<User>();
		for (int i = 0; i < focusUserList.size(); i++) {
			focusUserDetail.add(userService.findUserById(focusUserList.get(i).getFocus_id()));
		}
		
		modelAndView.setViewName("myfocus");
		modelAndView.addObject("user", user);
		//modelAndView.addObject("focusUserList", focusUserList);
		modelAndView.addObject("focusUserDetail", focusUserDetail);
		return modelAndView;
		
	}
	
	//关注用户
	@ResponseBody
	@RequestMapping("/focusUser.do")
	public String focusUser(int id, HttpSession session) {
		
		String msg = "";
		User user = (User) session.getAttribute("user");
		if (user.getId() == id) {
			return "不能关注自己！";
		} else {
			msg = userService.focusUser(user.getId(), id);
			return msg;
		}
	}
	
	//取消关注
	@RequestMapping("/delFocusUser.do")
	public String delFocusUser(int id, HttpSession session) {
		
		String msg = "";
		User user = (User) session.getAttribute("user");
		msg = userService.delFocusUser(user.getId(), id);
		return msg;
	}
}
