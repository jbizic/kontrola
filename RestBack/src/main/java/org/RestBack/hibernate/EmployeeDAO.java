package org.RestBack.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.RestBack.bean.Employee;
import org.hibernate.Session;
import org.hibernate.TransactionException;
/**
 * @author Jovan
 *
 */
public class EmployeeDAO {
	
	 public static boolean saveUser(Employee employee) {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   try {
		   session.beginTransaction();

		   session.save(employee);

		   session.getTransaction().commit();
		   }catch(TransactionException ex) {
			   return false;
		   }
		   return true;
		  }

		  public static void updateUser(Employee employee) {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   session.beginTransaction();

		   session.merge(employee);

		   session.getTransaction().commit();
		  }

		  public void deleteUser(Employee employee) {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   session.beginTransaction();

		   session.delete(employee);

		   session.getTransaction().commit();
		  }
		  
		  public static Employee getEmpByName(String name) {
			   Session session = HibernateUtil.getSessionFactory().openSession();
			   Query query = session.createQuery("from Employee e where e.name = :name");
			   query.setParameter("name", name);
			   Employee e = (Employee) query.getSingleResult();
			  return e;
		  }
		  
		  @SuppressWarnings("unchecked")
		public static List<Employee> getUsers() {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   session.beginTransaction();

		   ArrayList<Employee> list = (ArrayList<Employee>) session.createQuery("from Employee e ORDER by e.parentId ").list();
		   if (list != null) {
		    for (int i = 0; i < list.size(); i++) {
		     System.out.println("Employee ID : " + list.get(i).getId());
		     System.out.println("Employee Name : "+ list.get(i).getName());
		     System.out.println("Employee Job Description : "+ list.get(i).getJobDescription());
		     System.out.println("Employee Month Salary : " + list.get(i).getMonthSalary());
		     System.out.println("Employee Parent Id: " + list.get(i).getParentId());
		   }
		   }
		   session.getTransaction().commit();
		   return list;
		  }
}
