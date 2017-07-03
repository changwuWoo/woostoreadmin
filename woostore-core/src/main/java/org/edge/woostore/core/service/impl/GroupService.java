package org.edge.woostore.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IGroupService;
import org.edge.woostore.domain.annotation.Loggable;
import org.edge.woostore.domain.entity.Group;
import org.edge.woostore.domain.exception.BizException;
import org.edge.woostore.domain.repository.Page;
import org.edge.woostore.persist.dao.impl.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/4/24.
 */
@Service
public class GroupService implements IGroupService {
    private Log logger = LogFactory.getLog(GroupService.class);
    @Autowired
    private GroupDao groupDao;
    @Override
    @Transactional(readOnly = false, rollbackFor = BizException.class)
    public Collection<Group> queryListByPkId(String pkId) {
        if(pkId !=null){
            return  groupDao.getChildNode(pkId);
        }else {
            return groupDao.getRootNode();
        }
    }

    @Override
    public Collection<Group> queryGroupList() {
        return null;
    }

    @Override
    public Group queryGroup(String pkId) {
        return groupDao.get(pkId);
    }

    @Override
    @Loggable(optType = "update",describe = "更新群组信息",tableName="TB_GROUP")
    public boolean updateGroup(Group group) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("UPDATE TB_GROUP ");
        if(group.getName()!=null&&group.getName().length()>0){
            map.put("FNAME",group.getName());
            sql.append("set FNAME = ? ,");
        }
        if(group.getNumber()!=null&&group.getNumber().length()>0){
            map.put("FNUMBER",group.getNumber());
            sql.append("FNUMBER = ?");
        }
        if(group.getPkId()!=null&&group.getPkId().length()>0){
            map.put("",group.getPkId());
            sql.append("WHERE PK_ID = ?");
        }else {
            return false;
        }
        if(groupDao.updateByPrimaryKey(sql.toString(),map)>=0){
            return true;
        }
        else {
            return false;
        }
    }

    @Loggable(optType = "insert",describe = "插入群组信息",tableName="TB_GROUP")
    @Override
    public boolean insertGroup(Group group) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("insert into TB_GROUP(PK_ID, PARENT_ID, FNAME, FNUMBER) values(");
        if(group.getPkId()!=null&&group.getPkId().length()>0){
            map.put("PK_ID",group.getPkId());
            sql.append("?, ");
        }else {
            return false;
        }
        logger.debug("group.parentId"+group.getParentId().length());
        if (group.getParentId()!=null){
            map.put("PARENT_ID",group.getParentId());
            sql.append("?, ");
        }else {
            return false;
        }
        if(group.getName()!=null&&group.getName().length()>0){
            map.put("FNAME",group.getName());
            sql.append(" ?,");
        }else {
            return false;
        }
        if (group.getNumber()!=null&&group.getNumber().length()>0){
            map.put("FNUMBER",group.getNumber());
            sql.append("? )");
        }else {
            return false;
        }
        if(groupDao.insert(sql.toString(),map)>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page getListByPage(int pageSize, int page, Group group) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT SEQ_GROUP.nextval FROM dual";
        return groupDao.getSeq(sql);
    }
}
