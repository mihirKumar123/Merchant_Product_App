package org.jsp.MerchantProductApp.Controller;

import javax.persistence.*;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("dev");
        System.out.println(fac);

	}
}
