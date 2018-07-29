package org.RestBack.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
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
			   Employee e = null;
			  try {
			  e = (Employee) query.getSingleResult();
			  }catch(NoResultException ex) {
				  
			  }
			  return e;
		  }
		  
		  @SuppressWarnings("unchecked")
		public static List<Employee> getAllUsers() {
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
			@SuppressWarnings("unchecked")
			public static List<Employee> getChildren(long id) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();

				ArrayList<Employee> list = (ArrayList<Employee>) session.createQuery("from Employee e WHERE e.parentId = "+id+" ")
						.list();

				session.getTransaction().commit();
				return list;
			}
			public static void addChildren(Employee em) {
				if(!em.getChildren().isEmpty()) {
					for(Employee e : em.getChildren()) {
						e.setChildren(getChildren(e.getId()));
						addChildren(e);
					}
				}
			}
			@SuppressWarnings("unchecked")
			public static List<Employee> getUsers() {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				ArrayList<Employee> list = new ArrayList<>();;
				Employee root =  (Employee) session.createQuery("from Employee e WHERE e.parentId is null").getSingleResult();
				root.setChildren(getChildren(root.getId()));

				if(!root.getChildren().isEmpty()) {
						addChildren(root);
				}
				list.add(root);
				session.getTransaction().commit();
				return list;
			}
}
