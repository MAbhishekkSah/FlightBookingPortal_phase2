package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.project.model.Airlines;
import com.project.model.Flight;

public class FlightAirlinesDAO {
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Flight> flightList1 = new ArrayList<Flight>();
		List<Flight> flightList2 = new ArrayList<Flight>();
		List<Flight> flightList3 = new ArrayList<Flight>();
		
		Airlines airline1 =new Airlines(1112,"Air-Asia",flightList1);
		Airlines airline2 =new Airlines(1131,"Spice-Jet",flightList2);
		Airlines airline3 =new Airlines(1421,"INDIGO",flightList3);
		
		Flight flight1 = new Flight("ARI-121","ARI-Udaan",airline1,50,"Kolkata","Chennai");
		Flight flight2 = new Flight("ARI-122","ARI-Udaan",airline1,50,"Chennai","Kolkata");
		Flight flight3 = new Flight("ARI-123","ARI-Udaan",airline1,50,"Delhi","Mumbai");
		Flight flight4 = new Flight("ARI-124","ARI-Udaan",airline1,50,"Mumbai","Delhi");
		Flight flight13 = new Flight("ARI-125","ARI-Udaan",airline1,50,"Hyderabad","Delhi");
		Flight flight5 = new Flight("SPC-131","SPC-Udaan",airline2,50,"Kolkata","Delhi");
		Flight flight6 = new Flight("SPC-132","SPC-Udaan",airline2,50,"Delhi","Chennai");
		Flight flight7 = new Flight("SPC-133","SPC-Udaan",airline2,50,"Mumbai","Chennai");
		Flight flight8 = new Flight("SPC-134","SPC-Udaan",airline2,50,"Kolkata","Mumbai");
		Flight flight14 = new Flight("SPC-135","SPC-Udaan",airline2,50,"Bangalore","Delhi");
		Flight flight9 = new Flight("IND-141","IND-Udaan",airline3,50,"Mumbai","Hyderabad");
		Flight flight10 = new Flight("IND-142","IND-Udaan",airline3,50,"Bangalore","Kolkata");
		Flight flight11 = new Flight("IND-143","IND-Udaan",airline3,50,"Delhi","Chennai");
		Flight flight12 = new Flight("IND-144","IND-Udaan",airline3,50,"Delhi","Hyderabad");
		Flight flight15 = new Flight("IND-145","IND-Udaan",airline3,50,"Bangalore","Mumbai");
		
		flightList1.add(flight1);
		flightList1.add(flight2);
		flightList1.add(flight3);
		flightList1.add(flight4);
		flightList1.add(flight13);
		flightList2.add(flight5);
		flightList2.add(flight6);
		flightList2.add(flight7);
		flightList2.add(flight8);
		flightList2.add(flight14);
		flightList3.add(flight9);
		flightList3.add(flight10);
		flightList3.add(flight11);
		flightList3.add(flight12);
		flightList3.add(flight15);
		
		session.save(airline1);
		session.save(airline2);
		session.save(airline3);
		transaction.commit();
		System.out.println("Succesfully inserted the value");
		factory.close();
		session.close();
		
	}

}
