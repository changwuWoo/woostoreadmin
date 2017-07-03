package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.IRoleService;
import org.edge.woostore.domain.annotation.Loggable;
import org.edge.woostore.domain.entity.Permission;
import org.edge.woostore.domain.entity.Role;
import org.edge.woostore.domain.repository.Page;
import org.edge.woostore.persist.dao.IPermissionDao;
import org.edge.woostore.persist.dao.IRoleDao;
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
    public Page getListByPage(int pageSize, int page, Role role) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT SEQ_ROLE.nextval FROM dual";
        return iRoleDao.getSeq(sql);
    }

    @Override
    public Role getByPkId(String pkid) {
        Role role = null;
        role = iRoleDao.get(pkid);
        if (role != null) {
            Collection<Permission> powerCollection = iPermissionDao.selectListByPrivilegeMaster(role.getPkId());
            if (powerCollection != null && powerCollection.size() > 0) {
            }
        }
        return role;
    }

    @Override
    public Collection<Role> getRoles() {
        String hql = "from Role role";
        return iRoleDao.selectAll(hql,new LinkedHashMap());
    }

    @Override
    @Loggable(optType = "update",describe = "更新角色信息",tableName="TB_ROLE")
    public boolean updateRole(Role role) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE TB_ROLE ");
        Map map = new LinkedHashMap();
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
        Map map = new LinkedHashMap();
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
