package com.manish.javadev.manager;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.Customer;
import com.manish.javadev.model.Order;
import com.manish.javadev.util.HibernateUtil;

public class InsertManager {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("manish", "manish@gmail.com",new Long(22222));
			
			Order o1 = new Order(23, new Double(7000.00), new Date(), "Old");			
			Order o2 = new Order(19, new Double(11000.00), new Date(), "New");
			Order o3 = new Order(20, new Double(12000.00), new Date(),
					"New and new");
			
			o1.setCustomer(cust);
			o2.setCustomer(cust);
			o3.setCustomer(cust);
			
			cust.getOrders().add(o1);
			cust.getOrders().add(o2);
			cust.getOrders().add(o3);
			
			//1 Customer saved
			session.save(cust);

			//2 Order saved
			session.save(o1);
			session.save(o2);
			session.save(o3);
			
			tx.commit();
			session.close();
	
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
