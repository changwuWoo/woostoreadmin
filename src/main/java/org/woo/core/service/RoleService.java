package org.woo.core.service;

import org.woo.core.service.IRoleService;
import org.woo.domain.annotation.Loggable;
import org.woo.domain.entity.Role;
import org.woo.domain.repository.Page;
import org.woo.persist.dao.IPermissionDao;
import org.woo.persist.dao.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/30.
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Autowired
    private IPermissionDao iPermissionDao;

    @Override
    public Page<Role> getListByPage(int pageSize, int page, Role role) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT SEQ_ROLE.nextval FROM dual";
        return iRoleDao.getSeq(sql);
    }

    @Override
    public Role getEntityByPkId(String pkId) {
        return iRoleDao.get(pkId);
    }

    @Override
    public Collection<Role> getRoles() {
        String hql = "from Role role";
        return iRoleDao.selectAll(hql,new LinkedHashMap<String,Object>());
    }

    @Override
    @Loggable(optType = "update",describe = "更新角色信息",tableName="TB_ROLE")
    public boolean updateRole(Role role) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE TB_ROLE ");
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if (role.getName() != null && role.getName().length() > 0) {
            map.put("FNAME", role.getName());
            sql.append("SET FNAME = ? ,");
        }
        if (role.getNumber() != null && role.getNumber().length() > 0) {
            map.put("FNUMBER", role.getNumber());
            sql.append(" FNUMBER = ? ");
        }
        if (role.getPkId() != null && role.getPkId().length() > 0) {
            map.put("PK_ID", role.getPkId());
            sql.append(" WHERE PK_ID= ?");
        } else {
            return false;
        }
        if (iRoleDao.updateByPrimaryKey(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Loggable(optType = "insert",describe = "插入角色信息",tableName="TB_ROLE")
    public boolean insertRole(Role role) {
        StringBuffer sql = new StringBuffer();
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        sql.append("insert into TB_ROLE(PK_ID,FNAME,FNUMBER) values(");
        if (role.getPkId() != null && role.getPkId().length() > 0) {
            map.put("PK_ID", role.getPkId());
            sql.append("?, ");
        } else {
            return false;
        }
        if (role.getName() != null && role.getName().length() > 0) {
            map.put("FNAME", role.getName());
            sql.append(" ?,");
        } else {
            return false;
        }
        if (role.getNumber() != null && role.getNumber().length() > 0) {
            map.put("FNUMBER", role.getNumber());
            sql.append("? )");
        } else {
            return false;
        }
        if (iRoleDao.insert(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
