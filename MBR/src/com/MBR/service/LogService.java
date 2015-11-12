package com.MBR.service;

import java.util.Date;
import java.util.List;

import com.MBR.pojo.MbrLog;

public interface LogService {

	void addLog(String username, String name, Date time, String actionId,
			String action);

	List<MbrLog> getAllLogs();

	List<MbrLog> findLogByFiveCondition(String actionid, String searchName,
			String timedate, String timedateLate, String content);
}
