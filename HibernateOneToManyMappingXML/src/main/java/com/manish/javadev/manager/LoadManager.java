package com.manish.javadev.manager;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.Customer;
import com.manish.javadev.model.Order;
import com.manish.javadev.util.HibernateUtil;

public class LoadManager {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			System.out.println("Loading from Customer");
			Customer cust = (Customer) session.load(Customer.class, 1);
			System.out.println(cust);
			System.out.println(cust.getCid() + "\t" + cust.getCname() + "\t"
					+ cust.getEmail() + "\t" + cust.getPhone());
			Set<Order> orders = cust.getOrders();
			for (Order ordr : orders) {
				System.out.println(ordr.getOrderId() + "\t"
						+ ordr.getTotalQty() + "\t" + ordr.getStatus() + "\t"
						+ ordr.getTotalCost());
			}
			System.out.println("=========================");
			// Here we are loading from Order and displaying corresponding
			// Customer
			System.out.println("Loading from Order");
			Order ordr = (Order) session.load(Order.class, 2);
			System.out.println(ordr.getOrderId() + "\t" + ordr.getTotalQty()
					+ "\t" + ordr.getTotalCost() + "\t" + ordr.getOrderDate());

			Customer cust1 = ordr.getCustomer();
			System.out.println(cust1.getCid() + "\t" + cust1.getCname() + "\t"
					+ cust1.getEmail() + "\t" + cust1.getPhone());

			tx.commit();
			session.close();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
