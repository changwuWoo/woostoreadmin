package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.IPermissionService;
import org.edge.woostore.domain.annotation.Loggable;
import org.edge.woostore.domain.entity.Permission;
import org.edge.woostore.domain.repository.Page;
import org.edge.woostore.persist.dao.IPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private IPermissionDao iPermissionDao;
    

    @Override
    public Collection<Permission> getPermissions() {
        return null;
    }

    @Override
    public Page getListByPage(int pageSize, int page, String filter) {
        String countSql = "select count(*) from Permission permission";
        int count = iPermissionDao.getCount(countSql); // 总记录数
        System.out.println(count);
        int totalPage = Page.countTotalPage(pageSize, count); // 总页数
        int offset = Page.countOffset(pageSize, page); // 当前页开始记录
        int length = pageSize; // 每页记录数
        int currentPage = Page.countCurrentPage(page);
        StringBuffer sql = new StringBuffer();
        sql.append("from Permission permission where 1=1 ");
        Map map = new LinkedHashMap();
        if (filter != null && !"".equals(filter.trim())) {
            map.put("permission.fname", "%" + filter.trim() + "%");
            sql.append("and permission.fname like ? ");
        }
        Collection<Permission> list = iPermissionDao.queryForPage(offset, length, sql.toString(), map); // 该分页的记录
        // 把分页信息保存到Bean中
        Page Page = new Page();
        Page.setPageSize(pageSize);
        Page.setCurrentPage(currentPage);
        Page.setAllRow(count);
        Page.setTotalPage(totalPage);
        Page.setCollection(list);
        Page.init();
        return Page;
    }

    @Override
    @Loggable(optType = "update", describe = "更新权限信息", tableName = "TB_POWER")
    public boolean updatePermission(Permission permission) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("UPDATE TB_PERMISSION ");
        if (permission != null) {
            if (permission.getName() != null && permission.getName().length() > 0) {
                map.put("FNAME", permission.getName());
                sql.append("set FNAME = ?,");
            }
            if (permission.getNumber() != null && permission.getNumber().length() > 0) {
                map.put("FNUMBER", permission.getNumber());
                sql.append(" FNUMBER = ? ");
            }
            if (permission.getPkId() != null && permission.getPkId().length() > 0) {
                map.put("PK_ID", permission.getPkId());
                sql.append(" where PK_ID = ? ");
            } else {
                return false;
            }
        } else {
            return false;
        }
        if (iPermissionDao.updateByPrimaryKey(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Loggable(optType = "insert", describe = "插入权限信息", tableName = "TB_POWER")
    public boolean insertPermission(Permission permission) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("insert into TB_POWER(PK_ID,FNAME,FNUMBER) values(");
        if (permission.getPkId() != null && permission.getPkId().length() > 0) {
            map.put("PK_ID", permission.getPkId());
            sql.append("?, ");
        } else {
            return false;
        }
        if (permission.getName() != null && permission.getName().length() > 0) {
            map.put("FNAME", permission.getName());
            sql.append(" ?,");
        } else {
            return false;
        }
        if (permission.getNumber() != null && permission.getNumber().length() > 0) {
            map.put("FNUMBER", permission.getNumber());
            sql.append("? )");
        } else {
            return false;
        }
        if (iPermissionDao.insert(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Page getListByPage(int pageSize, int page, Permission permission) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT WOOSTOREADMIN.SEQ_POWER.nextval FROM dual";
        return iPermissionDao.getSeq(sql);
    }

    @Override
    public Permission getEntityByPkId(String pkId) {
        return iPermissionDao.get(pkId);
    }
}
