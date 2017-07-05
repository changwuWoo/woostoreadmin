package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.ILogService;
import org.edge.woostore.domain.entity.Log;
import org.edge.woostore.domain.repository.Page;
import org.edge.woostore.persist.dao.impl.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4.
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogDao logDao;


    @Override
    public Page getListByPage(int pageSize, int page, Log log) {
        String counthql = "select count(*) from Log log";
        int count = logDao.getCount(counthql); // 总记录数
        int totalPage = Page.countTotalPage(pageSize, count); // 总页数
        int offset = Page.countOffset(pageSize, page); // 当前页开始记录
        int length = pageSize; // 每页记录数
        int currentPage = Page.countCurrentPage(page);
        StringBuffer hql = new StringBuffer();
        Map map = new HashMap();
        hql.append("from Log log ");
        Collection<Log> list = logDao.queryForPage(offset, length,hql.toString(),map); // 该分页的记录
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
        String sql="SELECT SEQ_LOG.nextval FROM dual";
        return logDao.getSeq(sql);
    }

    @Override
    public Log getEntityByPkId(String pkId) {
        return logDao.get(pkId);
    }

    @Override
    public boolean clearLog(String pkId) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("DELETE TB_LOG ");
        if(pkId!=null&&pkId.length()>0){
            map.put("PK_ID",pkId);
            sql.append("WHERE PK_ID = ? ");
        }
        if (logDao.updateByPrimaryKey(sql.toString(),map)>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean insertLog(Log log) throws Exception{
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("insert into TB_LOG(PK_ID, PK_MASTER_NAME, FTABLENAME, FOPTYPE,FCONTENT,FPARAMS) values(");
        if(log.getPkId()!=null&&log.getPkId().length()>0){
            map.put("PK_ID",log.getPkId());
            sql.append("?,");
        }else {
            return  false;
        }
        if(log.getFkMasterName()!=null&&log.getFkMasterName().length()>0){
            map.put("PK_MASTER_NAME",log.getFkMasterName());
            sql.append("?,");
        }else {
            return false;
        }
        if (log.getTableName()!=null&&log.getTableName().length()>0){
            map.put("FTABLENAME",log.getTableName());
            sql.append("?,");
        }else {
            return false;
        }
        if(log.getOpType()!=null&&log.getOpType().length()>0){
            map.put("FOPTYPE",log.getOpType());
            sql.append("?,");
        }else {
            return false;
        }
        if(log.getContentNote()!=null&&log.getContentNote().length()>0){
            map.put("FCONTENT",log.getContentNote());
            sql.append("?,");
        }else {
            return false;
        }
        if(log.getParams()!=null&&log.getParams().length()>0){
            map.put("FPARAMS",log.getParams());
            sql.append("?)");
        }else {
            return false;
        }
        System.out.println(map);
        if(logDao.insert(sql.toString(),map)>=0){
            return true;
        }else {
            return false;
        }
    }
}
