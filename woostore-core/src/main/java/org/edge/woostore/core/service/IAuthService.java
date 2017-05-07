package org.edge.woostore.core.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
public interface IAuthService {
	@Transactional
	List<Map<String, Object>> queryOrg(Map<String, Object> inMap);
	@Transactional
	void updateOrg(Map<String, Object> inMap);
	@Transactional
	void insertOrg(Map<String, Object> inMap);
	@Transactional
	int queryOrgPersons(Map<String, Object> inMap);
	@Transactional
	void deleteOrg(Map<String, Object> inMap);
	@Transactional
	String addMeun(Map<String, Object> inMap);
	@Transactional
	boolean deleteMenu(Map<String, Object> inMap);
	@Transactional
	boolean updateMenu(Map<String, Object> inMap);
	@Transactional
	List<Map<String, Object>> queryAuthInfo(Map<String, Object> inMap);
	@Transactional
	long checkAuthByCodeName(Map<String, Object> inMap);
	@Transactional
	String addAuth(Map<String, Object> inMap);
	@Transactional
	boolean updateAuth(Map<String, Object> inMap);
	@Transactional
	long checkAuth(String authId);
	@Transactional
	boolean deleteAuth(String authId);
	@Transactional
	List<Map<String, Object>> queryRoleInfo(Map<String, Object> inMap);
	@Transactional
	long checkRoleByInfo(Map<String, Object> inMap);
	@Transactional
	String addRoleInfo(Map<String, Object> inMap);
	@Transactional
	void addRoleToAuth(Map<String, Object> relMap);
	@Transactional
	long checkRoleById(Map<String, Object> pObj);
	@Transactional
	boolean deleteRoleToAuth(Map<String, Object> pObj);
	@Transactional
	boolean deleteRoleInfo(Map<String, Object> pObj);
	@Transactional
	boolean updateRoleInfo(Map<String, Object> inMap);
	@Transactional
	List<Map<String, Object>> queryPersionInfo(Map<String, Object> inMap);
	@Transactional
	boolean updatePerson(Map<String, Object> inMap);

}
