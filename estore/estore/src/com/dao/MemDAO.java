package com.dao;

import java.util.List;

import com.entity.Member;
import com.entity.Merchandise;


public interface MemDAO {
	//声明一个查询所有用户的方法，如果有元素 ，(list.size()>0)返回list,如果没有list.size()==0
	public List<Member>  selectAll();  
	//添加用户  对象 Member  返回boolean类型
	public boolean insert(Member mem);
	//删除一个对象，一行记录，根据id，成功返回true，否则返回false
	public boolean delete(int mid);
	//根据id查询数据，并封装到对象，如果对象为空，没有查询到，否则查询
	public Member selectByMid(int mid);
	 //根据对象进行修改，成功返回true 否则返回false
	public boolean update(int mid,int intergal);
	//判断用户是否存在
	public boolean isExistA(String name,String passwd);
	public Member selectByName(String name);
	public List<Member> select(String content);
}
