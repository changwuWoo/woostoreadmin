package org.edge.woostore.core.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
public interface IAuthService {
	List<Map<String, Object>> queryOrg(Map<String, Object> inMap);

	void updateOrg(Map<String, Object> inMap);

	void insertOrg(Map<String, Object> inMap);

	int queryOrgPersons(Map<String, Object> inMap);

	void deleteOrg(Map<String, Object> inMap);

	String addMeun(Map<String, Object> inMap);

	boolean deleteMenu(Map<String, Object> inMap);

	boolean updateMenu(Map<String, Object> inMap);

	List<Map<String, Object>> queryAuthInfo(Map<String, Object> inMap);

	long checkAuthByCodeName(Map<String, Object> inMap);

	String addAuth(Map<String, Object> inMap);

	boolean updateAuth(Map<String, Object> inMap);

	long checkAuth(String authId);

	boolean deleteAuth(String authId);

	List<Map<String, Object>> queryRoleInfo(Map<String, Object> inMap);

	long checkRoleByInfo(Map<String, Object> inMap);

	String addRoleInfo(Map<String, Object> inMap);

	void addRoleToAuth(Map<String, Object> relMap);

	long checkRoleById(Map<String, Object> pObj);

	boolean deleteRoleToAuth(Map<String, Object> pObj);

	boolean deleteRoleInfo(Map<String, Object> pObj);

	boolean updateRoleInfo(Map<String, Object> inMap);

	List<Map<String, Object>> queryPersionInfo(Map<String, Object> inMap);

	boolean updatePerson(Map<String, Object> inMap);

}
