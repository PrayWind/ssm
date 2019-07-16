package com.xmut.mapper;

import com.xmut.entity.FocusUser;
import com.xmut.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {

	@Select("select * from t_user where username=#{0} and password=#{1}")
	User findUser(String username, String password);	// 查找用户

	@Select("select * from t_user")
	List<User> findAllUser();	// 查询所有用户

	@Insert("insert into t_user (username, password) values (#{username}, #{password})")
	void addUser(User user);	// 添加用户

	@Select("select * from t_user where id=#{value}")
	public User findUserById(int id);	// 根据id查找用户

	@Select("select * from t_user where username like '%${value}%'")
	public List<User> findUserByUsername(String username);	// 模糊搜索

	@Delete("delete from t_focus where main_id=#{value} or focus_id=#{value}")
	public Boolean delFocusLink(int id);	//删除用户时先删除关注表里的关联

	@Delete("delete from t_user where id=#{value}")
	public Boolean delUserById(int id);	// 根据id删除用户

	@Update("update t_user set username=#{username}, password=#{password} where id=#{id}")
	public void updateUser(User user);	//修改用户

	@Insert("insert into t_focus (main_id, focus_id) values (#{0}, #{1})")
	public Boolean focusUser(int main_id, int focus_id);	// 关注用户

	@Select("select * from t_focus where main_id=#{value}")
	public List<FocusUser> showMyFocus(int id);	//查找我关注的人

	@Delete("delete from t_focus where main_id=#{0} and focus_id=#{1}")
	public Boolean delFocusUser(int main_id, int focus_id);	// 取消关注
}
