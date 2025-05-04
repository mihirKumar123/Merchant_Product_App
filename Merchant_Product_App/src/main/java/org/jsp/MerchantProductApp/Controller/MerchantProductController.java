package org.jsp.MerchantProductApp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.MerchantProductApp.dao.MerchantDao;
import org.jsp.MerchantProductApp.dao.ProductDao;
import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class MerchantProductController {

	static Scanner sc=new Scanner(System.in);
	static MerchantDao mdao=new MerchantDao();
	static ProductDao pdao=new ProductDao();
	public static void main(String[] args) {
		System.out.println("1.save Merchant");
		System.out.println("2.update Merchant");
		System.out.println("3.Find Merchant By Id");
		System.out.println("4.Verify Merchant By Email and Password");
		System.out.println("5.Verify Merchant By phone and Password");
		System.out.println("6.save Product");
		System.out.println("7.Update Product");
		System.out.println("8.Find Product By Merchant id");
		System.out.println("9.Find Products by Brand");
		System.out.println("10.Find Product By Category");
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1:saveMerchant();
		break;
		
		case 2:updateMerchant();
		break;
		
		case 3:findMerchantById();
		break;
		
		case 4:verifyMerchantByEmailAndPassword();
		break;
		
		case 5:verifyMerchantByPhoneAndPassword();
		break;
		
		case 6:saveProduct();
		break;
		
		case 7:updateProduct();
		break;
		
		case 8:findProductByMerchantId();
		break;
		
		case 9:findProductByBrand();
		break;
		
		case 10:findProductByCategory();
		break;
		
		default:System.err.println("Inavlid choice, choose from 1 to 10");
		}
	}

	private static void findProductByCategory() {
		System.out.println("Enter product Category");
		String category=sc.next();
		
		List<Product> lpdb=pdao.findProductByCategory(category);
		if(lpdb.size()>0) {
			for (Product product : lpdb) {
				System.out.println(product.toString());
			}
		}else {
			System.err.println("No product details is found because of invalid brand");
		}
	}

	private static void findProductByBrand() {

		System.out.println("Enter product Brand");
		String brand=sc.next();
		
		List<Product> lpdb=pdao.findProductByBrand(brand);
		if(lpdb.size()>0) {
			for (Product product : lpdb) {
				System.out.println(product.toString());
			}
		}else {
			System.err.println("No product details is found because of invalid brand");
		}
	}

	private static void findProductByMerchantId() {

		System.out.println("Enter Merchant by merchant id");
		int mid= sc.nextInt();
		
		List<Product> p=pdao.findProductByMerchantId(mid);
		if(p.size()>0) {
			for (Product product : p) {
				System.out.println(p.toString());
			}
		}else {
			System.err.println("No product details is found because of invalid merchant id");
		}
		
	}

	private static void updateProduct() {

		System.out.println("Enter product details--id,name,category,cost");
		int pid=sc.nextInt();
		String name=sc.next();
		String category=sc.next();
		double cost=sc.nextDouble();
		
		Product p=new Product();
		p.setId(pid);
		p.setName(name);
		p.setCategory(category);
		p.setCost(cost);
		
		Product pdb=pdao.updateProduct(p);
		if(pdb!=null) {
			System.out.println("Product is saved");
		}else {
			System.err.println("Product is not saved");
		}
	}

	private static void saveProduct() {
		
		System.out.println("Enter Merchant id");
		int mid=sc.nextInt();

		System.out.println("Enter product details--name,brand,category,cost");
		String name=sc.next();
		String brand=sc.next();
		String category=sc.next();
		double cost=sc.nextDouble();
		
		Product p= new Product();
		p.setName(name);
		p.setBrand(brand);
		p.setCategory(category);
		p.setCost(cost);
		
		Product pdb=pdao.saveProduct(mid,p);
		if(pdb!=null) {
			System.out.println("Product is saved");
		}else {
			System.err.println("Product is not saved");
		}
	}

	private static void verifyMerchantByPhoneAndPassword() {
		System.out.println("Enter Merchant phone and password");
		long phone=sc.nextLong();
		String password=sc.next();
		
		Merchant mdb=mdao.verifyMerchantByEmailAndPassword(phone,password);
		if(mdb!=null) {
			System.out.println(mdb.toString());
		}else {
			System.err.println("No Merchant data found because of invalid email and password");
		}
	}

	private static void verifyMerchantByEmailAndPassword() {

		System.out.println("Enter Merchant email and password");
		String email=sc.next();
		String password=sc.next();
		
		Merchant mdb=mdao.verifyMerchantByEmailAndPassword(email,password);
		if(mdb!=null) {
			System.out.println(mdb.toString());
		}else {
			System.err.println("No Merchant data found because of invalid email and password");
		}
	}

	private static void findMerchantById() {

		System.out.println("Enter Merchant Id");
		int id=sc.nextInt();
		Merchant mdb=mdao.findMerchantById(id);
		if(mdb!=null) {
			System.out.println(mdb.toString());
		}else {
			System.err.println("No Merchant data found because of invalid id");
		}
		
	}

	private static void updateMerchant() {
		
		System.out.println("Enter merchant info-- Id,name,Gst_num,email");
		Merchant m= new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());

		Merchant mdb=mdao.updateMerchant(m);
		if(mdb!=null) {
			System.out.println(mdb.getName()+"'s data has been updated");
		}else {
			System.err.println("Merchants data has not been updated");
		}
	}

	private static void saveMerchant() {
		
		System.out.println("Enter merchant info-- name,phone,Gst_num,email,Password");
		String name=sc.next();
		long phone=sc.nextLong();
		String gst_num=sc.next();
		String email=sc.next();
		String password=sc.next();
		
		Merchant m= new Merchant();
		m.setName(name);
		m.setPhone(phone);
		m.setGst_num(gst_num);
		m.setEmail(email);
		m.setPassword(password);
	
		
		Merchant mdb=mdao.saveMerchant(m);
		System.out.println("Merchant is saved with id: "+ mdb.getId());
		
	}
	
}
