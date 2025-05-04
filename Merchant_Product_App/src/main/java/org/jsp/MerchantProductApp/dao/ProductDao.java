package org.jsp.MerchantProductApp.dao;

import java.util.List;

import javax.persistence.*;

import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class ProductDao {

	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man= fac.createEntityManager();
	
public Product saveProduct(int mid, Product p) {

		Merchant mdb=man.find(Merchant.class, mid);
		if(mdb!=null) {
			EntityTransaction trans=man.getTransaction();
			trans.begin();
			
			p.setMerchant(mdb);
			man.persist(p);
			trans.commit();
			return p;
		}else {
			return null;
		}
		
}

public Product updateProduct(Product p) {
	EntityTransaction trans= man.getTransaction();
	trans.begin();
	
	Product pdb=man.find(Product.class, p.getId());
	if(pdb!=null) {
		pdb.setName(p.getName());
		pdb.setCategory(p.getCategory());
		pdb.setCost(p.getCost());
		trans.commit();
		return pdb;
	}else {
		return null;
	}
	
}

public List<Product> findProductByMerchantId(int mid) {

	Query q=man.createQuery("select p from Product p where p.merchant.id=?1");
	q.setParameter(1, mid);
	List<Product> lpdb=q.getResultList();
	return lpdb;
}

public List<Product> findProductByBrand(String brand) {

	Query q=man.createQuery("select p from Product p where p.brand=?1");
	q.setParameter(1, brand);
	List<Product> lpdb=q.getResultList();
	return lpdb;
	
}

public List<Product> findProductByCategory(String category) {

	Query q=man.createQuery("select p from Product p where p.category=?1");
	q.setParameter(1, category);
	List<Product> lpdb=q.getResultList();
	return lpdb;
}

}
