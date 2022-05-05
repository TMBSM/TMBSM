package com.dao;

import java.util.List;

import com.entity.Category;
import com.entity.Guestbook;

public interface GuestbookDAO {
	//声明一个查询所有用户的方法，如果有元素 ，(list.size()>0)返回list,如果没有list.size()==0
	public List<Guestbook>  selectAll();  
	//删除一个对象，一行记录，根据id，成功返回true，否则返回false
	public boolean delete(int wid);
	//根据id查询数据，并封装到对象，如果对象为空，没有查询到，否则查询
	public Guestbook selectByWid(int wid);
	 //根据对象进行修改，成功返回true 否则返回false
	public boolean update(int wid,String answerContent);
	public boolean insert(Guestbook gb);
}
