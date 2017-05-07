package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.IAuthService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**   
* @Title: AuthService.java 
* @Package com.woostore.core.service.impl 
* @Description: TODO
* @author Administrator  
* @date 20172017年2月28日 下午12:19:06 
* @version V 1.0.0   
*/
@Service("AuthService")
public class AuthService implements IAuthService {
    /* (non-Javadoc)
     * @see IAuthService#queryOrg(java.util.Map)
     */
    public List<Map<String, Object>> queryOrg(Map<String, Object> inMap) {
        return null;
    }

    public void updateOrg(Map<String, Object> inMap) {
    	
    }

    public void insertOrg(Map<String, Object> inMap) {

    }

    public int queryOrgPersons(Map<String, Object> inMap) {
        return 0;
    }

    public void deleteOrg(Map<String, Object> inMap) {

    }

    public String addMeun(Map<String, Object> inMap) {
        return null;
    }

    public boolean deleteMenu(Map<String, Object> inMap) {
        return false;
    }

    public boolean updateMenu(Map<String, Object> inMap) {
        return false;
    }

    public List<Map<String, Object>> queryAuthInfo(Map<String, Object> inMap) {
        return null;
    }

    public long checkAuthByCodeName(Map<String, Object> inMap) {
        return 0;
    }

    public String addAuth(Map<String, Object> inMap) {
        return null;
    }

    public boolean updateAuth(Map<String, Object> inMap) {
        return false;
    }

    public long checkAuth(String authId) {
        return 0;
    }

    public boolean deleteAuth(String authId) {
        return false;
    }

    public List<Map<String, Object>> queryRoleInfo(Map<String, Object> inMap) {
        return null;
    }

    public long checkRoleByInfo(Map<String, Object> inMap) {
        return 0;
    }

    public String addRoleInfo(Map<String, Object> inMap) {
        return null;
    }

    public void addRoleToAuth(Map<String, Object> relMap) {

    }

    public long checkRoleById(Map<String, Object> pObj) {
        return 0;
    }

    public boolean deleteRoleToAuth(Map<String, Object> pObj) {
        return false;
    }

    public boolean deleteRoleInfo(Map<String, Object> pObj) {
        return false;
    }

    public boolean updateRoleInfo(Map<String, Object> inMap) {
        return false;
    }

    public List<Map<String, Object>> queryPersionInfo(Map<String, Object> inMap) {
        return null;
    }

    public boolean updatePerson(Map<String, Object> inMap) {
        return false;
    }
}
