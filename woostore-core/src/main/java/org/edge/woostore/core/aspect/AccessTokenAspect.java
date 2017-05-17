package org.edge.woostore.core.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.domain.annotation.AccessTokenValidate;
import org.edge.woostore.domain.dto.JwtToken;
import org.edge.woostore.domain.entity.Token;
import org.edge.woostore.utils.constant.Constants;
import org.edge.woostore.utils.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/3/22.
 */
@Aspect
@Component
public class AccessTokenAspect {
    private Log logger = LogFactory.getLog(AccessTokenAspect.class);
    @Autowired
    @Qualifier
    private ITokenService iTokenService;
    @Before("@annotation(org.edge.woostore.domain.annotation.AccessTokenValidate) )")
    @ResponseBody
    public boolean doAccessCheck(JoinPoint joinPoint)throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = null;
        Map<String, String> reMap = new HashMap<String, String>();
        //如果不是映射到方法直接通过
        Object handler = null;
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        //验证token这里只需要写一个条用函数就好返回验证结果
        Token model = iTokenService.getTokenByAccessToken(authorization);
        if (TokenUtils.valid("","","","")) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            request.setAttribute(Constants.CURRENT_USER_ID, model.hashCode());
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(AccessTokenValidate.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
