package com.cart.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dao.MerDAOImp;
import com.entity.Merchandise;
import com.entity.Shouye;

public class Cart {
       private HashMap<Integer, Shouye> cart=null;

	public Cart() {
		super();
		cart=new HashMap<Integer, Shouye>();
	}

	public HashMap<Integer, Shouye> getCart() {
		return cart;
	}

	public void setCart(HashMap<Integer, Shouye> cart) {
		this.cart = cart;
	}
	public boolean addGood(Shouye sy){
	   boolean flag=false;
	
	   if(!cart.containsKey(sy.getSid())){
		   cart.put(sy.getSid(), sy);
		   flag=true;
	   }else{
		   Shouye oldSy=cart.get(sy.getSid());
		   int number=oldSy.getNumber()+sy.getNumber();
		   sy.setNumber(number);
		   cart.put(sy.getSid(), sy);
		   flag=true;
	   }
	   System.out.println();	   return flag;
	}
	public boolean updateGood(int sid,int number){
	
		boolean flag=false;
		if(cart.containsKey(sid)){
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy = mdi.selectBySid(sid);//找到实体类
		   sy.setNumber(number);
		  cart.put(sid, sy);
		   flag=true;
		}else{

		}
		return flag;
	}
	

	public boolean deleteGood(Shouye sy ){

		boolean flag=false;
		if(cart.containsKey(sy.getSid())){
			cart.remove(sy.getSid());
			flag=true;
		}else{
	
		}
		return flag;
	}
	
	

	public List<Shouye> selectAllGoods(){
		
		List<Shouye> list=new ArrayList<Shouye>();
		Set set=cart.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Shouye> entry=(Map.Entry<Integer, Shouye>) it.next();
			Shouye sy=entry.getValue();
			list.add(sy);
		}
		return list;
	}
	//��� ����
	public double sum(){

		double sum=0.0;
		Set set=cart.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Shouye> entry=(Map.Entry<Integer, Shouye>) it.next();
			Shouye sy=entry.getValue();
			sum+=sy.getSprice()*sy.getNumber();
	
		}
		return sum;
	}
}
