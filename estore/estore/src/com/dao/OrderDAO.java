package com.dao;

import java.util.List;

import com.entity.Orders;




public interface OrderDAO {
	//声明一个查询所有用户的方法，如果有元素 ，(list.size()>0)返回list,如果没有list.size()==0
	public List<Orders>  selectAll();  
	//添加用户  对象 Orders  返回boolean类型
	public boolean insert(Orders or);
	//删除一个对象，一行记录，根据id，成功返回true，否则返回false
	public boolean delete(int oid);
	//根据id查询数据，并封装到对象，如果对象为空，没有查询到，否则查询
	public Orders selectByOid(int oid);
	 //根据对象进行修改，成功返回true 否则返回false
	public boolean update(int oid,int orderstatus,int dstatus,int pay);
	//判断用户是否存在
	//public boolean isEixst(String username,String password,int myright);
	//模糊查询
	public List<Orders> select(String content);
	//public List<Book> getPageShow(int pageShow);
}
