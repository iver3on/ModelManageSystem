package com.MBR.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBR.dao.LogDao;
import com.MBR.pojo.MbrLog;
import com.MBR.service.LogService;

@Service("logService")
public class LogServiceImp implements LogService {

	@Autowired
	private LogDao logDao;

	public void addLog(String username, String name, Date time,
			String actionId, String action) {
		MbrLog log = new MbrLog();
		// SimpleDateFormat dateformat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm");
		Timestamp nousedate = new Timestamp(time.getTime());
		log.setAction(action);
		log.setActionid(Integer.parseInt(actionId));
		log.setContent(name);
		log.setDataId(0);
		log.setDateTime(nousedate);
		log.setUserName(username);
		logDao.add(log);
	}

	public List<MbrLog> getAllLogs() {
		List<MbrLog> list = new ArrayList<MbrLog>();
		list = logDao.findAll();
		return list;
	}

	public List<MbrLog> findLogByFiveCondition(String actionid,
			String searchName, String timedate, String timedateLate,
			String content) {
		List<MbrLog> list = logDao.getLogByFiveCondition(actionid, searchName,
				timedate, timedateLate, content);
		return list;
	}

	public List<MbrLog> findLogsByActionAndContent(String content) {
		List<MbrLog> list = logDao.getLogsByActionAndContent(content);
		return list;
	}

}
