package com.MBR.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*import com.MBR.pojo.MbrAction;
import com.MBR.pojo.MbrLog;
import com.MBR.pojo.MbrInputParameter;
import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;*/

//持久化层选择hibernate进行管理
public class HibernateUtils {
	// SessionFactory全局只需要一个就可以了
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		// Configuration cfg = new Configuration();
		// cfg.configure();//读取默认的配置文件("hibernate.cfg.xml");
		// cfg.configure("hibernate.cfg.xml");//读取指定位置的配置文件
		// sessionFactory = cfg.buildSessionFactory();
		// //使用configure()方法加载默认的hibernate.cfg.xml配置文件，相反通过hibernate.proprties配置hibernate就得在这儿添加
		// 因为配置文件中已经含有数据库映射信息，因此就不需要使用addClass方法加载各个类文件的映射文件
		sessionFactory = new Configuration()//
				.configure()//
				/*
				 * .addClass(MbrAction.class)// .addClass(MbrLog.class)//
				 * .addClass(MbrInputParameter.class)//
				 * .addClass(MbrModelCondition.class)//
				 * .addClass(MbrModels.class)//
				 */.buildSessionFactory();
	}

	/**
	 * 获取全局唯一的SessionFactory
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 从全局为一的SessionFactory中打开一个Session
	 * 
	 * @return
	 */
	public static Session openASession() {
		session = sessionFactory.openSession();
		return session;
	}

	public static Session getCurrentSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public static void closeSession(){
		if (session!=null) {
			session.close();
		}
	}
}
