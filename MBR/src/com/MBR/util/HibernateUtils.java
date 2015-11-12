package com.MBR.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MBR.pojo.MbrAction;
import com.MBR.pojo.MbrLog;
import com.MBR.pojo.MbrMetaData;
import com.MBR.pojo.MbrModelCondition;
import com.MBR.pojo.MbrModels;

public class HibernateUtils {
	// SessionFactory全局只需要一个就可以了
	private static SessionFactory sessionFactory;

	static {
		// Configuration cfg = new Configuration();
		// cfg.configure();//读取默认的配置文件("hibernate.cfg.xml");
		// cfg.configure("hibernate.cfg.xml");//读取指定位置的配置文件
		// sessionFactory = cfg.buildSessionFactory();

		sessionFactory = new Configuration()//
				.configure()//
				.addClass(MbrAction.class)//
				.addClass(MbrLog.class)//
				.addClass(MbrMetaData.class)//
				.addClass(MbrModelCondition.class)//
				.addClass(MbrModels.class)//
				.buildSessionFactory();
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
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static Session getCurrentSession() {

		return sessionFactory.getCurrentSession();

	}
}
