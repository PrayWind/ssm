package com.xmut.service;

import com.xmut.entity.FocusUser;
import com.xmut.entity.User;

import java.util.List;

public interface UserService {

	public User findUser(String username, String password);
	public List<User> findAllUser();
	public void addUser(User user);
	public User findUserById(int id);
	public List<User> findUserByUsername(String username);
	public String delUserById(int id);
	public void updateUser(User user);
	public String focusUser(int main_id, int focus_id);
	public List<FocusUser> showMyFocus(int id);
	public String delFocusUser(int main_id, int focus_id);
	
}
