package com.MBR.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.MBR.pojo.MbrLog;
import com.MBR.util.HibernateUtils;

/**
 * @author Iver3oN Zhang
 * @date 2015-11-5 Impossible is nothing
 */
@Repository("LogDao")
public class LogDao {

	public void add(MbrLog log) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(log);
	}

	@SuppressWarnings("unchecked")
	public List<MbrLog> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		List<MbrLog> list = new ArrayList<MbrLog>();
		list = session.createQuery("from MbrLog").list();
		return list;
	}

	// 查询Log的各种情况
	@SuppressWarnings("unchecked")
	public List<MbrLog> getLogByFiveCondition(String action, String searchName,
			String timedate, String timedateLate, String content) {

		String hql = "from MbrLog as l where ";
		Session session = HibernateUtils.getCurrentSession();
		List<MbrLog> list = new ArrayList<MbrLog>();
		if (!isZero(action) && isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			hql = hql + " l.actionid =:action";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action)).list();
		} else if (!isZero(action) && !isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			hql = hql + " l.actionid =:action and l.userName like :searchName";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%").list();
		} else if (!isZero(action) && isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.dateTime between :timedate and :t2";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("timedate", d).setParameter("t2", d2).list();

		} else if (!isZero(action) && isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.dateTime between :timedateLate and :t2";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("timedateLate", d).setParameter("t2", d2)
					.list();
		} else if (!isZero(action) && isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			hql = hql + " l.actionid =:action and l.content like:content ";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("content", "%" + content + "%").list();

		} else if (!isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.dateTime between :timedate and :t2";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d).setParameter("t2", d2).list();
		} else if (!isZero(action) && !isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.dateTime between :timedateLate and :t2";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedateLate", d).setParameter("t2", d2)
					.list();
		} else if (!isZero(action) && !isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.content like:content ";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("content", "%" + content + "%").list();
		} else if (!isZero(action) && isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.actionid =:action and l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		} else if (!isZero(action) && isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.dateTime between :timedate and :t2 and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("content", "%" + content + "%")
					.setParameter("timedate", d).setParameter("t2", d2).list();
		} else if (!isZero(action) && isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.dateTime between :timedateLate and :t2 and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("content", "%" + content + "%")
					.setParameter("timedateLate", d).setParameter("t2", d2)
					.list();
		} else if (!isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		} else if (!isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.dateTime between :timedate and :t2 and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d).setParameter("t2", d2)
					.setParameter("content", "%" + content + "%").list();
		} else if (!isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.actionid =:action and l.userName like :searchName and l.dateTime between :timedate and :timedateLate and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("action", Integer.parseInt(action))
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2)
					.setParameter("content", "%" + content + "%").list();
		}

		if (isZero(action) && !isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			hql = hql + " l.userName like :searchName";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%").list();
		} else if (isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.userName like :searchName and l.dateTime between :timedate and :t2";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d).setParameter("t2", d2).list();
		} else if (isZero(action) && !isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.userName like :searchName and l.dateTime between :timedateLate and :t2";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedateLate", d).setParameter("t2", d2)
					.list();
		} else if (isZero(action) && !isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			hql = hql
					+ " l.userName like :searchName and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("content", "%" + content + "%").list();
		} else if (isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.userName like:searchName and l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		} else if (isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.userName like :searchName and l.dateTime between :timedate and :t2 and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedate", d).setParameter("t2", d2)
					.setParameter("content", "%" + content + "%").list();
		} else if (isZero(action) && !isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.userName like :searchName and l.dateTime between :timedateLate and :t2 and l.content like :content";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("timedateLate", d).setParameter("t2", d2)
					.setParameter("content", "%" + content + "%").list();
		} else if (isZero(action) && !isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.userName like :searchName and l.content like :content and l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql)
					.setParameter("searchName", "%" + searchName + "%")
					.setParameter("content", "%" + content + "%")
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		}
		if (isZero(action) && isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql + " l.dateTime between :timedate and :t2";
			list = session.createQuery(hql).setParameter("timedate", d)
					.setParameter("t2", d2).list();
		} else if (isZero(action) && isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedate);
			Date d1 = stringToDate(timedateLate);
			Date d2 = nextDate(d1);
			hql = hql + " l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql).setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		} else if (isZero(action) && isZero(searchName) && !isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.dateTime between :timedate and :t2 and l.content like :content";
			list = session.createQuery(hql).setParameter("timedate", d)
					.setParameter("t2", d2)
					.setParameter("content", "%" + content + "%").list();
		} else if (isZero(action) && isZero(searchName) && !isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedate);
			Date dl = stringToDate(timedateLate);
			Date d2 = nextDate(dl);
			hql = hql
					+ " l.content like :content and l.dateTime between :timedate and :timedateLate";
			list = session.createQuery(hql)
					.setParameter("content", "%" + content + "%")
					.setParameter("timedate", d)
					.setParameter("timedateLate", d2).list();
		}
		if (isZero(action) && isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql + " l.dateTime between :timedateLate and :t2";
			list = session.createQuery(hql).setParameter("timedateLate", d)
					.setParameter("t2", d2).list();
		} else if (isZero(action) && isZero(searchName) && isZero(timedate)
				&& !isZero(timedateLate) && !isZero(content)) {
			Date d = stringToDate(timedateLate);
			Date d2 = nextDate(d);
			hql = hql
					+ " l.dateTime between :timedateLate and :t2 and l.content like :content";
			list = session.createQuery(hql).setParameter("timedateLate", d)
					.setParameter("t2", d2)
					.setParameter("content", "%" + content + "%").list();
		}
		if (isZero(action) && isZero(searchName) && isZero(timedate)
				&& isZero(timedateLate) && !isZero(content)) {
			hql = hql + " l.content like :content";
			list = session.createQuery(hql)
					.setParameter("content", "%" + content + "%").list();
		}

		return list;
	}

	// 判断 前端 页面输入 选择参数是否是空的
	public boolean isZero(String number) {
		try {
			int num = Integer.parseInt(number);
			if (num == 0) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Date stringToDate(String time) {
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public Date nextDate(Date d) {
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
}
