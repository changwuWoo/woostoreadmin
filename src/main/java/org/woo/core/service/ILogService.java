package org.woo.core.service;


import org.woo.domain.entity.Log;

/**
 * Created by Administrator on 2017/6/4.
 */
public interface ILogService extends ICoreService<Log> {
    boolean clearLog(String pkId);
    boolean insertLog(Log log) throws Exception;
}
