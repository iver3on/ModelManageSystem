package com.MBR.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.MBR.util.HibernateUtils;

public class SessionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtils.getCurrentSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			chain.doFilter(request, response);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
