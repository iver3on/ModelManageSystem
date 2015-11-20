package com.MBR.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.MBR.util.HibernateUtils;


/**
 * @author Iver3oN Zhang
 * @date 2015-11-13
 * Impossible is nothing
 */
public class SessionFilter implements Filter {
	 private static final Log log = LogFactory.getLog(SessionFilter.class);  
	protected FilterConfig config ; 
	public void destroy() {
		this.config = null ; 
	}
	/** 
	* 因为在一次请求中需要共享单一的Session和Transation实例，因此不能在每个方法后关闭Session，应该在一次请求全部处理完成后关闭Session。 
	* 为此可以设计一个过滤器，在过滤器中同意关闭Session，实现该功能的Filter(CloseSessionFilter) 
	*/
	//doFilter()他的作用是将请求转发给过滤器链上下一个对象。这里的下一个指的是下一个filter，
	//如果没有filter那就是你请求的资源。 一般filter都是一个链,web.xml 里面配置了几个就有几个。一个一个的连在一起 
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//getCurrentSession(),事务提交会自动close，不需要像openSession一样自己调用close方法关闭session
		Session session = HibernateUtils.getCurrentSession();
		log.info("HibernateSessionFilter begin transaction"); 
		//开始事务
		Transaction tx = session.beginTransaction();
		try {
			log.debug("HibernateSessionFilter begin doChain");  
			chain.doFilter(request, response);
			System.out.println("HibernateSessionFilter begin commit");  
			tx.commit();
			System.out.println("HibernateSessionFilter commit success");
		} catch (HibernateException  e) {
			 System.out.println("HibernateException exception accurs ");  
	         System.out.println("HibernateSessionFilter begin rollback() ");  
			tx.rollback();
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig ; 
	}

}
