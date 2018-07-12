package org.woo.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.woo.core.service.IMasterService;
import org.woo.domain.annotation.Loggable;
import org.woo.domain.entity.Group;
import org.woo.domain.entity.Master;
import org.woo.domain.entity.Permission;
import org.woo.domain.entity.Role;
import org.woo.domain.repository.Page;
import org.woo.persist.dao.IGroupDao;
import org.woo.persist.dao.IMasterDao;
import org.woo.persist.dao.IPermissionDao;
import org.woo.persist.dao.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class MasterService implements IMasterService {
    @Autowired
    private IMasterDao iMasterDao;
    @Autowired
    private IRoleDao iRoleDao;
    @Autowired
    private IPermissionDao iPermissionDao;
    @Autowired
    private IGroupDao iGroupDao;

    @Override
    public boolean updateLogOutDate(Master user) {
        return false;
    }


    @Override
    public Master getMasterInfoById(String pkId) {
        Master master = iMasterDao.get(pkId);
        if (master != null && (master.getFkGroupId() != null || master.getFkGroupId() != null)) {
            Role role = new Role();
            role = iRoleDao.get(master.getFkGroupId());
            StringBuffer sql =new StringBuffer();
            Map map = new LinkedHashMap();
            sql.append("SELECT  tpower.PK_ID AS pkId,tpower.FNAME AS fname,tpower.FNUMBER AS fnumber from STSM2017S.TB_POWER tpower " +
                    "LEFT OUTER JOIN STSM2017S.TB_PRIVILEGE tpri ON tpower.PK_ID=tpri.PRIVILEGEACCESSVALUE " +
                    "WHERE tpri.PRIVILEGEMASTERVALUE = ?");

            if (role != null) {
                master.setRole(role);
            }
            Collection<Permission> powerCollection = new ArrayList<>();
            powerCollection = iPermissionDao.selectListByPrivilegeMaster(sql.toString(),map);
            if (powerCollection != null && powerCollection.size() > 0) {
                master.setPowerCollection(powerCollection);
            }
            Collection<Group> groupCollection = new ArrayList<>();
            Group group = new Group();
            group.setParentId(master.getFkGroupId());
            do {
                Group temp = new Group();
                temp = iGroupDao.get(group.getParentId() == null ? "-1" : group.getParentId());
                if (temp != null) {
                    groupCollection.add(temp);
                    group.setParentId(temp.getParentId() == null ? "-1" : temp.getParentId());
                } else {
                    break;
                }
            }
            while (group.getParentId() != null);
            master.setGroupCollection(groupCollection);
        }
        return master;
    }

    @Override
    public Collection<Master> getUsers() {
        String hql = "";
        Map map = new LinkedHashMap();
        return iMasterDao.selectAll(hql,map);
    }

    @Override
    public Master queryByUserName(String name) {
        Collection<Master> masterCollection = new ArrayList<Master>();
        Master master = null;
        StringBuffer hql = new StringBuffer();
        Map map = new LinkedHashMap();
        hql.append("from Master where 1=1 ");
        if (name != null) {
            map.put("LOGINNAME", "" + name + "");
            hql.append("and lower(LOGINNAME) = lower(?) ");
        }
        masterCollection = iMasterDao.selectByFiled(hql.toString(), map);
        if (masterCollection != null && masterCollection.size() > 0) {
            Iterator<Master> iterator = masterCollection.iterator();
            master = iterator.next();
        }
        return master;
    }


    @Override
    @Loggable(optType = "update", describe = "更新用户信息", tableName = "TB_MASTER")
    public boolean updateMasterInfo(Master master) {
        StringBuffer hql = new StringBuffer();
        Map map = new LinkedHashMap();
        hql.append("UPDATE TB_MASTER ");
        if (master != null) {
            if (master.getFkRoleId() != null && master.getFkRoleId().length() > 0) {
                map.put("PK_ROLE_ID", master.getFkRoleId());
                hql.append(" set PK_ROLE_ID = ? ,");
            }
            if (master.getLoginName() != null && master.getLoginName().length() > 0) {
                map.put("FNAME", master.getLoginName());
                hql.append(" FNAME = ? ");
            }
            if (master.getPkId() != null && master.getPkId().length() > 0) {
                map.put("PK_ID", master.getPkId());
                hql.append(" where PK_ID = ? ");
            } else {
                return false;
            }
        } else {
            return false;
        }
        if (iMasterDao.updateByPrimaryKey(hql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean insertMaster(Master master) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("INSERT INTO TB_MASTER(PK_ID,FNAME,FPASSWD,FK_GROUP_ID,FK_ROLE_ID) VALUES (");
        if (master.getPkId() != null && master.getPkId().length() > 0) {
            map.put("pkId", master.getPkId());
            sql.append("?, ");
        } else {
            return false;
        }
        if (master.getLoginName() != null && master.getLoginName().length() > 0) {
            map.put("FNAME", master.getLoginName());
            sql.append("?, ");
        } else {
            return false;
        }
        if (master.getLoginPassWord() != null && master.getLoginPassWord().length() > 0) {
            map.put("FPASSWD", master.getLoginPassWord());
            sql.append("?, ");
        } else {
            return false;
        }
        if (master.getFkGroupId() != null && master.getFkGroupId().length() > 0) {
            map.put("FK_GROUP_ID", master.getFkGroupId());
            sql.append("?, ");
        } else {
            return false;
        }
        if (master.getFkRoleId() != null && master.getFkRoleId().length() > 0) {
            map.put("", master.getFkRoleId());
            sql.append("?)");
        } else {
            return false;
        }
        if (iMasterDao.insert(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page getListByPage(int pageSize, int page, Master master) {
        String counthql = "select count(*) from Master master";
        int count = iMasterDao.getCount(counthql); // 总记录数
        int totalPage = Page.countTotalPage(pageSize, count); // 总页数
        int offset = Page.countOffset(pageSize, page); // 当前页开始记录
        int length = pageSize; // 每页记录数
        int currentPage = Page.countCurrentPage(page);
        StringBuffer hql = new StringBuffer();
        Map map = new HashMap();
        hql.append("from Master master where 1=1 ");
        if (master != null) {
            if (master.getLoginName() != null && master.getLoginName().length() > 0) {
                map.put("master.fname", "%" + master.getLoginName() + "%");
                hql.append("and master.fname like ? ");
            }
            if (master.getFkGroupId() != null && master.getFkGroupId().length() > 0) {
                map.put("master.pkGroupId", "" + master.getFkGroupId() + "");
                hql.append("and master.pkGroupId = ? ");
            }
            if (master.getFkRoleId() != null && master.getFkRoleId().length() > 0) {
                map.put("master.pkRoleId", "" + master.getFkRoleId() + "");
                hql.append("and master.pkRoleId = ? ");
            }
        }

        Collection<Master> list = iMasterDao.queryForPage(offset, length, hql.toString(), map); // 该分页的记录
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
    public String getSeq() {
        String sql = "SELECT WOOSTOREADMIN.SEQ_MASTER.nextval FROM dual";
        return iMasterDao.getSeq(sql);
    }

    @Override
    public Master getEntityByPkId(String pkId) {
        return iMasterDao.get(pkId);
    }

}
