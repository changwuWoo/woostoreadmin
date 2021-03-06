package org.woo.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woo.domain.annotation.Loggable;
import org.woo.domain.entity.Group;
import org.woo.domain.exception.BizException;
import org.woo.domain.repository.Page;
import org.woo.persist.dao.IGroupDao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/4/24.
 */
@Service
public class GroupService implements IGroupService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IGroupDao iGroupDao;
    @Override
    @Transactional(readOnly = false, rollbackFor = BizException.class)
    public Collection<Group> queryListByPkId(String pkId) {
        StringBuffer hql = new StringBuffer();
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        hql.append("from Group group where 1=1 ");
        if(pkId !=null){
            hql.append("and group.parentId = null ");
            return  iGroupDao.getChildNode(hql.toString(),map);
        }else {
            map.put("FKPARENTID",pkId);
            hql.append("and group.parentId = ? ");
            return iGroupDao.getRootNode(hql.toString(),map);
        }
    }

    @Override
    public Collection<Group> queryGroupList() {
        return null;
    }

    @Override
    @Loggable(optType = "update",describe = "更新群组信息",tableName="TB_GROUP")
    public boolean updateGroup(Group group) {
        StringBuffer sql = new StringBuffer();
        Map<String,Object> map = new LinkedHashMap<String,Object>();
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
        if(iGroupDao.updateByPrimaryKey(sql.toString(),map)>=0){
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
        Map<String,Object> map = new LinkedHashMap<String,Object>();
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
        if(iGroupDao.insert(sql.toString(),map)>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page<Group> getListByPage(int pageSize, int page, Group group) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT SEQ_GROUP.nextval FROM dual";
        return iGroupDao.getSeq(sql);
    }

    @Override
    public Group getEntityByPkId(String pkId) {
        return iGroupDao.get(pkId);
    }
}
