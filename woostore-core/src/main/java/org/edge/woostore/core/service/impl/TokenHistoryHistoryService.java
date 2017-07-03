package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.ITokenHistoryService;
import org.edge.woostore.domain.entity.TokenHistory;
import org.edge.woostore.persist.dao.ITokenHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class TokenHistoryHistoryService implements ITokenHistoryService {
    @Autowired
    private ITokenHistoryDao iTokenHistoryDao;

    @Override
    public TokenHistory getTokenByAccessToken(String accessToken) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("FROM TokenHistory tokenHistory ");
        if (accessToken!=null&&accessToken.length()>0){
            map.put("tokenHistory.accessToken",accessToken);
            sql.append(" WHERE tokenHistory.accessToken = ? ");
        }
        Object tokenHistory=iTokenHistoryDao.selectByUniqueFiled(sql.toString(),map);
        System.out.println("Kkjhdkfgjk");
        return iTokenHistoryDao.selectByUniqueFiled(sql.toString(),map);
    }

    @Override
    public TokenHistory QueryTokenByMasterId(String masterId) {
        return  iTokenHistoryDao.get(masterId);
    }

    @Override
    public boolean insert(TokenHistory token) {
        StringBuffer sql = new StringBuffer();
        Map map = new LinkedHashMap();
        sql.append("INSERT INTO TB_TOKENHISTORY(PK_ID,ACCESSTOKEN,LOGINIP,FKMASTERID) VALUES (");
        if (token.getPkId()!=null&&token.getPkId().length()>0){
            map.put("pkId",token.getPkId());
            sql.append("?, ");
        }else{
            return false;
        }
        if(token.getAccessToken()!=null&&token.getAccessToken().length()>0){
            map.put("ACCESSTOKEN",token.getAccessToken());
            sql.append("?, ");
        }else {
            return false;
        }
        if (token.getLoginIp()!=null&&token.getLoginIp().length()>0){
            map.put("LOGINIP",token.getLoginIp());
            sql.append("?, ");
        }else {
            return false;
        }
        if (token.getFkMasterId()!=null&&token.getFkMasterId().length()>0){
            map.put("FKMASTERID",token.getFkMasterId());
            sql.append("?)");
        }
        else {
            return false;
        }
        if(iTokenHistoryDao.insert(sql.toString(),map)>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getSeq() {
        String sql="SELECT WOOSTOREADMIN.SEQ_TOKENHISTORY.nextval FROM dual";
        return iTokenHistoryDao.getSeq(sql);
    }

    @Override
    public TokenHistory getTokenHistory(String pkId) {
        return  iTokenHistoryDao.get(pkId);
    }

}
