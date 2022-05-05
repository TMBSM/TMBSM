package com.dao;

import java.util.List;
import com.entity.Delivery;
public interface DeliveryDAO {
	//声明一个查询所有用户的方法，如果有元素 ，(list.size()>0)返回list,如果没有list.size()==0
	public List<Delivery>  selectAll();  
	public boolean delete(int gid);
	//根据id查询数据，并封装到对象，如果对象为空，没有查询到，否则查询
	public Delivery selectByDid(int did);
	 //根据对象进行修改，成功返回true 否则返回false
	public boolean update(int did,double dprice);
	//根据did找到价格
	public double select(int did);
	//添加用户  对象 Delivery  返回boolean类型
	public boolean insert(Delivery de);
}
