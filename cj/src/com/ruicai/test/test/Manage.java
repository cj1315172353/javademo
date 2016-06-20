package com.ruicai.test.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ruicai.test.entity.ProductsData;
import com.ruicai.test.entity.UserData;

public class Manage {
	public static List<ProductsData> shopcar=new ArrayList<ProductsData>();
	public static List<UserData> users=new ArrayList<UserData>();
	public static void main(String[] args) {
		System.out.println("--------欢迎进入瑞才商品管理系统--------");
		System.out.println("\t1:登陆");
		System.out.println("\t2:注册");
		System.out.println("\t3:退出");
		System.out.println("请输入您的选择:");
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		  while(!flag){
		  String num=sc.next();
	      if(num.equals("1")){landing();//显示登录菜单
	      break;
	      }else if(num.equals("2")){login();//显示注册菜单
	       break;
	      }else if(num.equals("3")){exit();//显示退出菜单
	    	  break;
	      }else{System.out.println("请输入正确的选择");
	      }
	    }    
	}
	/**
	 * 登陆 
	 */
	public static void landing(){
		boolean flag=false;
		  while(!flag){
			System.out.println("请输入您的用户名:");
			Scanner sc=new Scanner(System.in);
			String name =sc.next();
			System.out.println("请输入您的密码:");
			String password =sc.next();
			int i;
			/*
			 * 验证账号密码
			 */
			for ( i = 0; i <users.size(); i++) {
				if(users.get(i).getName().equals(name)&&users.get(i).getPassWord().equals(password)){
					System.out.println("欢迎光临");
					flag=true;
					break;
					}
			}
			if(i == users.size()){
				System.out.println("输入错误");
				System.out.print("\t1:登陆");
				System.out.print("\t2:注册");
				System.out.print("\t3:退出");
				System.out.println("\n请输入您的选择:");
				boolean flag1=false;
				  while(!flag1){
				  String num=sc.next();
			      if(num.equals("1")){landing();//显示登录菜单
			      break;
			      }else if(num.equals("2")){login();//显示注册菜单
			       break;
			      }else if(num.equals("3")){exit();//显示退出菜单
			    	  break;
			      }else{System.out.println("请输入正确的选择");
			      }
			    }    
		  }
	}
		choose();  
		   
	}
	/**
	 * 注册
	 */
	public static void login(){
		String name;
		int i=0;
		while(true){
		System.out.println("请输入注册的用户名:");
		Scanner sc=new Scanner(System.in);
		name=sc.next();
		/*
		 * 验证账号是否被注册
		 */
		for (i = 0; i <users.size(); i++) {
			if(name.equals(users.get(i).getName())){
				System.out.println("该账号已被注册");
				break;
			}
		}
			if(i==users.size()){
				break;
			}
		}
		System.out.println("请输入注册的密码:");
		Scanner s=new Scanner(System.in);
		String passWord=s.next();//将用户信息加入集合
		users.add(new UserData(name, passWord));
		System.out.println("注册成功");
		System.out.print("\t1:登陆");
		System.out.print("\t2:注册");
		System.out.print("\t3:退出");
		System.out.println("\n请输入您的选择:");
		boolean flag=false;
		  while(!flag){
		  String num=s.next();
	      if(num.equals("1")){landing();//显示登录菜单
	      break;
	      }else if(num.equals("2")){login();//显示注册菜单
	       break;
	      }else if(num.equals("3")){exit();//显示退出菜单
	    	  break;
	      }else{System.out.println("请输入正确的选择");
	      }
	    }    
		
		}
	
	
	
	/**
	 * 退出
	 */
	public static void exit(){
		System.out.println("欢迎下次光临");
	}

	
	/**
	 * 购物车
	 */
	public static void gouWuChe(){
		int sum=0;
		ProductsData c=new ProductsData();
		/*
		 * 判断购物车是否是空
		 */
		for (int i = 0; i <shopcar.size(); i++) {
			c=shopcar.get(i);
			sum=sum+c.getNumber();
		}
		if(sum==0){
			System.out.println("购物车空空如也");
			choose();
		}else{
			/*
			 * 展示购物车商品
			 */
			for (int i = 0; i <shopcar.size(); i++) {
				c=shopcar.get(i);
				System.out.println("商品id:"+c.getId()+"\t商品名称:"+c.getName()+"\t商品数量:"+c.getNumber()+"\t商品价格:"+c.getPrice());
			}
				System.out.print("\t1:去结算");
				System.out.print("\t2:再看看");
				System.out.println("\n请输入您的选择:");
				boolean flag1=false;
				  while(!flag1){
				  Scanner sc=new Scanner(System.in);  
				  String num=sc.next();
			      if(num.equals("1")){change();//进入结算菜单
			      break;
			      }else if(num.equals("2")){shopping();//进入购买菜单
			       break;
			      }else{System.out.println("请输入正确的选择");
			      }
			     
				  }
			}
		}
		
	
	/**
	 * 选择
	 */
	public static void choose(){
		System.out.print("\t1:逛一逛");
		System.out.print("\t2:我的购物车");
		System.out.print("\t3:退出");
		System.out.println("\n请输入您的选择:");
		boolean flag1=false;
		  while(!flag1){
		  Scanner sc=new Scanner(System.in);  
		  String num=sc.next();
	      if(num.equals("1")){shopping();//进入购买菜单
	      break;
	      }else if(num.equals("2")){gouWuChe();//进入购物车菜单
	       break;
	      }else if(num.equals("3")){exit();//显示退出菜单
	    	  break;
	      }else{System.out.println("请输入正确的选择");
	      }
	     
		  }
	}
	
	/**
	 * 购买
	 */
	public static void shopping(){
		ProductsData c=new ProductsData();
		for (int i = 0; i < ProductsData.getProducts().size(); i++){
			c=ProductsData.p.get(i);
			System.out.println("商品id:"+c.getId()+"\t商品名称:"+c.getName()+"\t商品数量:"+c.getNumber()+"\t商品价格:"+c.getPrice());
		}
        System.out.println("通过商品id来购买你喜欢的商品");
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		  while(!flag){
		  int num=sc.nextInt();
	    switch (num){
		case 1:
			System.out.println("确认您当前选择的商品");
			System.out.println("商品名称:"+ProductsData.p.get(0).getName());
			System.out.println("商品价格:"+ProductsData.p.get(0).getPrice());
			System.out.println("商品数量:"+ProductsData.p.get(0).getNumber());
			System.out.println("请输入您购买的数量");
			int num1=sc.nextInt();
			if(num1>ProductsData.p.get(0).getNumber()){
				System.out.println("库存不足");
				shopping();
			}else{
				System.out.println("物品已放入购物车");
				shopcar.add(new ProductsData(num, ProductsData.p.get(0).getName(), num1, ProductsData.p.get(0).getPrice()));
				ProductsData.p.get(0).setNumber(ProductsData.p.get(0).getNumber()-num1);
			}
			choose();
			break;
		case 2:
			System.out.println("确认您当前选择的商品");
			System.out.println("商品名称:"+ProductsData.p.get(1).getName());
			System.out.println("商品价格:"+ProductsData.p.get(1).getPrice());
			System.out.println("商品数量:"+ProductsData.p.get(1).getNumber());
			System.out.println("请输入您购买的数量");
			int num2=sc.nextInt();
			if(num2>ProductsData.p.get(1).getNumber()){
				System.out.println("库存不足");
				shopping();
			}else{
				System.out.println("物品已放入购物车");
				shopcar.add(new ProductsData(num, ProductsData.p.get(1).getName(), num2, ProductsData.p.get(1).getPrice()));
				ProductsData.p.get(1).setNumber(ProductsData.p.get(1).getNumber()-num2);
			}
			choose();
            break;
            case 3:
    			System.out.println("确认您当前选择的商品");
    			System.out.println("商品名称:"+ProductsData.p.get(2).getName());
    			System.out.println("商品价格:"+ProductsData.p.get(2).getPrice());
    			System.out.println("商品数量:"+ProductsData.p.get(2).getNumber());
    			System.out.println("请输入您购买的数量");
    			int num3=sc.nextInt();
    			if(num3>ProductsData.p.get(0).getNumber()){
    				System.out.println("库存不足");
    				shopping();
    			}else{
    				System.out.println("物品已放入购物车");
    				shopcar.add(new ProductsData(num, ProductsData.p.get(2).getName(), num3, ProductsData.p.get(2).getPrice()));
    				ProductsData.p.get(2).setNumber(ProductsData.p.get(2).getNumber()-num3);
    			}
    			choose();
    			break;
    		case 4:
    			System.out.println("确认您当前选择的商品");
    			System.out.println("商品名称:"+ProductsData.p.get(3).getName());
    			System.out.println("商品价格:"+ProductsData.p.get(3).getPrice());
    			System.out.println("商品数量:"+ProductsData.p.get(3).getNumber());
    			System.out.println("请输入您购买的数量");
    			int num4=sc.nextInt();
    			if(num4>ProductsData.p.get(0).getNumber()){
    				System.out.println("库存不足");
    				shopping();
    			}else{
    				System.out.println("物品已放入购物车");
    				shopcar.add(new ProductsData(num, ProductsData.p.get(3).getName(), num4, ProductsData.p.get(3).getPrice()));
    				ProductsData.p.get(3).setNumber(ProductsData.p.get(3).getNumber()-num4);
    			}
    			choose();
    			break;
    		case 5:
    			System.out.println("确认您当前选择的商品");
    			System.out.println("商品名称:"+ProductsData.p.get(4).getName());
    			System.out.println("商品价格:"+ProductsData.p.get(4).getPrice());
    			System.out.println("商品数量:"+ProductsData.p.get(4).getNumber());
    			System.out.println("请输入您购买的数量");
    			int num5=sc.nextInt();
    			if(num5>ProductsData.p.get(0).getNumber()){
    				System.out.println("库存不足");
    				shopping();
    			}else{
    				System.out.println("物品已放入购物车");
    				shopcar.add(new ProductsData(num, ProductsData.p.get(4).getName(), num5, ProductsData.p.get(4).getPrice()));
    				ProductsData.p.get(4).setNumber(ProductsData.p.get(4).getNumber()-num5);
    			}
    			choose();
    			break;
    		case 6:
    			System.out.println("确认您当前选择的商品");
    			System.out.println("商品名称:"+ProductsData.p.get(5).getName());
    			System.out.println("商品价格:"+ProductsData.p.get(5).getPrice());
    			System.out.println("商品数量:"+ProductsData.p.get(5).getNumber());
    			System.out.println("请输入您购买的数量");
    			int num6=sc.nextInt();
    			if(num6>ProductsData.p.get(0).getNumber()){
    				System.out.println("库存不足");
    				shopping();
    			}else{
    				System.out.println("物品已放入购物车");
    				shopcar.add(new ProductsData(num, ProductsData.p.get(5).getName(), num6, ProductsData.p.get(5).getPrice()));
    				ProductsData.p.get(5).setNumber(ProductsData.p.get(5).getNumber()-num6);
    			}
    			choose();
    			break;
    		case 7:
    			System.out.println("确认您当前选择的商品");
    			System.out.println("商品名称:"+ProductsData.p.get(6).getName());
    			System.out.println("商品价格:"+ProductsData.p.get(6).getPrice());
    			System.out.println("商品数量:"+ProductsData.p.get(6).getNumber());
    			System.out.println("请输入您购买的数量");
    			int num7=sc.nextInt();
    			if(num7>ProductsData.p.get(0).getNumber()){
    				System.out.println("库存不足");
    				shopping();
    			}else{
    				System.out.println("物品已放入购物车");
    				shopcar.add(new ProductsData(num, ProductsData.p.get(6).getName(), num7, ProductsData.p.get(6).getPrice()));
    				ProductsData.p.get(6).setNumber(ProductsData.p.get(6).getNumber()-num7);
    			}
    			choose();
    			break;
		default:
			System.out.println("请输入正确选择");
			break;
		}
	     
	  }
		  
   }
	
	/**
	 * 结算
	 */
	public static void change(){
		double sum=0;
		ProductsData c=new ProductsData();
		for (int i = 0; i < shopcar.size(); i++) {
		     c=shopcar.get(i);
		     sum=c.getPrice()*c.getNumber()+sum;
	}
        System.out.println("您一共消费了:"+sum);
        shopcar.clear();
        choose();
}
	

}
