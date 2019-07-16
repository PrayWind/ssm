package com.xmut.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import com.xmut.entity.FocusUser;
import com.xmut.entity.User;
import com.xmut.mapper.UserMapper;
import com.xmut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	//根据用户名和密码查询某个用户
	@Override
	public User findUser(String username, String password) {

		User user = userMapper.findUser(username, password);
		return user;
	}

	//查询所有用户
	@Override
	public List<User> findAllUser() {
		
		List<User> userList = userMapper.findAllUser();
		return userList;
	}

	//添加用户
	@Override
	public void addUser(User user) {

		userMapper.addUser(user);
	}
	
	//根据用户id查询用户
	@Override
	public User findUserById(int id) {
		
		User user = userMapper.findUserById(id);
		return user;
	}

	//模糊搜索
	@Override
	public List<User> findUserByUsername(String username) {
		
		List<User> userList = userMapper.findUserByUsername(username);
		return userList;
	}

	//删除用户
	@Override
	public String delUserById(int id) {
		
		String msg = "";
		//先删除该用户再关注表里的关联
		Boolean flag1 = userMapper.delFocusLink(id);
		//再删除该用户
		Boolean flag2 = userMapper.delUserById(id);
		if (flag2) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return msg;
	}

	//修改用户
	@Override
	public void updateUser(User user) {

		userMapper.updateUser(user);
	}

	//关注用户
	@Override
	public String focusUser(int main_id, int focus_id) {
		
		String msg = "";
		
		Boolean flag = userMapper.focusUser(main_id, focus_id);
		if (flag) {
			msg = "关注成功！";
		} else {
			msg = "关注失败！";
		}
		return msg;
	}

	//展示关注的用户
	@Override
	public List<FocusUser> showMyFocus(int id) {
		
		List<FocusUser> userList = userMapper.showMyFocus(id);
		return userList;
	}

	//取消关注
	@Override
	public String delFocusUser(int main_id, int focus_id) {
		
		String msg = "";
		Boolean flag = userMapper.delFocusUser(main_id, focus_id);
		if (flag) {
			msg = "取消成功！";
		} else {
			msg = "取消失败！";
		}
		return msg;
	}
}
