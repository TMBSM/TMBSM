package com.dao;

import java.util.List;

import com.entity.Merchandise;
import com.entity.Orders;
import com.entity.Shouye;


public interface MerchandiseDAO {
	//声明一个查询所有用户的方法，如果有元素 ，(list.size()>0)返回list,如果没有list.size()==0
	public List<Merchandise>  selectAll();  
	//添加用户  对象 Merchandise  返回boolean类型
	public boolean insert(Merchandise mer);
	//删除一个对象，一行记录，根据id，成功返回true，否则返回false
	public boolean delete(int gid);
	//根据id查询数据，并封装到对象，如果对象为空，没有查询到，否则查询
	public Merchandise selectByGid(int gid);
	 //根据对象进行修改，成功返回true 否则返回false
	public boolean update(int gid,int special);
	public List<Merchandise>  selectByCategory(int category);  
	public List<Shouye>  selectById(int minid,int maxid);  
	public Shouye selectBySid(int sid);
	public List<Merchandise> select(String content);
}
