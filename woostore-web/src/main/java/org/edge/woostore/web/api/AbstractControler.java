package org.edge.woostore.web.api;

import org.edge.woostore.utils.util.NetworkUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/25.
 */
public abstract class AbstractControler implements IControler{
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    public String getIpV4(){
        String ip=null;
        request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            NetworkUtil.getIpAddress(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
