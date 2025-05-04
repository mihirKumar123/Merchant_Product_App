package org.jsp.MerchantProductApp.dao;

import javax.persistence.*;

import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class MerchantDao {
 
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man= fac.createEntityManager();
	
public Merchant saveMerchant(Merchant m) {
		EntityTransaction trans= man.getTransaction();
		trans.begin();
		
		man.persist(m);
		trans.commit();
		return m;
}

public Merchant updateMerchant(Merchant m) {

		EntityTransaction trans= man.getTransaction();
		trans.begin();
		
		Merchant mdb=man.find(Merchant.class, m.getId());
		if(mdb!=null) {
			mdb.setName(m.getName());
			mdb.setGst_num(m.getGst_num());
			mdb.setEmail(m.getEmail());
			
			trans.commit();
			return mdb;
		}else {
			return null;
		}
}

public Merchant findMerchantById(int mid) {
	return man.find(Merchant.class,mid);
	
}

public Merchant verifyMerchantByEmailAndPassword(String email, String password) {

	Query q= man.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
	q.setParameter(1, email);
	q.setParameter(2, password);
	try {
		Merchant mdb=(Merchant) q.getSingleResult();
		return mdb;
	} catch (NoResultException e) {
        return null;
	}
	
}

public Merchant verifyMerchantByEmailAndPassword(long phone, String password) {
	Query q= man.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
	q.setParameter(1, phone);
	q.setParameter(2, password);
	try {
		Merchant mdb=(Merchant) q.getSingleResult();
		return mdb;
	} catch (NoResultException e) {
        return null;
	}
}



}
