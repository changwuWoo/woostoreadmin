package org.woo.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woo.domain.entity.TokenHistory;
import org.woo.domain.repository.Page;
import org.woo.persist.dao.ITokenHistoryDao;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class TokenHistoryService implements ITokenHistoryService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ITokenHistoryDao iTokenHistoryDao;

    @Override
    public TokenHistory getTokenByAccessToken(String AccessToken) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        sql.append("FROM TokenHistory tokenHistory ");
        if (AccessToken != null && AccessToken.length() > 0) {
            map.put("tokenHistory.accessToken", AccessToken);
            sql.append(" WHERE tokenHistory.accessToken = ? ");
        }
        System.out.println("Kkjhdkfgjk");
        return iTokenHistoryDao.selectByUniqueFiled(sql.toString(), map);
    }

    @Override
    public TokenHistory queryTokenByMasterId(String masterId) {
        return iTokenHistoryDao.get(masterId);
    }

    @Override
    public boolean insert(TokenHistory token) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        sql.append("INSERT INTO TB_TOKENHISTORY(PK_ID,ACCESSTOKEN,LOGINIP,FKMASTERID) VALUES (");
        if (token.getPkId() != null && token.getPkId().length() > 0) {
            map.put("pkId", token.getPkId());
            sql.append("?, ");
        } else {
            return false;
        }
        if (token.getAccessToken() != null && token.getAccessToken().length() > 0) {
            map.put("ACCESSTOKEN", token.getAccessToken());
            sql.append("?, ");
        } else {
            return false;
        }
        if (token.getLoginIp() != null && token.getLoginIp().length() > 0) {
            map.put("LOGINIP", token.getLoginIp());
            sql.append("?, ");
        } else {
            return false;
        }
        if (token.getFkMasterId() != null && token.getFkMasterId().length() > 0) {
            map.put("FKMASTERID", token.getFkMasterId());
            sql.append("?)");
        } else {
            return false;
        }
        if (iTokenHistoryDao.insert(sql.toString(), map) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<TokenHistory> getListByPage(int pageSize, int page, TokenHistory tokenHistory) {
        return null;
    }

    @Override
    public String getSeq() {
        String sql = "SELECT WOOSTOREADMIN.SEQ_TOKENHISTORY.nextval FROM dual";
        return iTokenHistoryDao.getSeq(sql);
    }

    @Override
    public TokenHistory getEntityByPkId(String pkId) {
        return iTokenHistoryDao.get(pkId);
    }

}
