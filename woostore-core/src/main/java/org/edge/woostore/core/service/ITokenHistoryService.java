package org.edge.woostore.core.service;

import org.edge.woostore.domain.entity.TokenHistory;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface ITokenHistoryService extends ICoreService<TokenHistory>{
    TokenHistory getTokenByAccessToken(String AccessToken);
    TokenHistory queryTokenByMasterId(String masterId);
    boolean insert(TokenHistory token);
    String getSeq();
    TokenHistory getTokenHistory(String pkId);
}
