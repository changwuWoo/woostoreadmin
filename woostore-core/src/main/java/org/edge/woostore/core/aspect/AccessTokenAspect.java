package org.edge.woostore.core.aspect;

import io.jsonwebtoken.Claims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.utils.constant.Constants;
import org.edge.woostore.utils.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/3/22.
 */
@Aspect
@Component
public class AccessTokenAspect {
    private Log logger = LogFactory.getLog(AccessTokenAspect.class);
    @Autowired
    private ITokenService iTokenService;
    @Autowired
    private JwtUtil jwt;


    @Before("@annotation(org.edge.woostore.domain.annotation.AccessTokenValidate) )")// 把定义好的切入通知注解引入，作为切点的通知函数
    @ResponseBody
    public boolean doAccessCheck(JoinPoint joinPoint)throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = null;
        String authorization = request.getParameter(Constants.AUTHORIZATION).trim().toString();
        if(authorization!=null&&authorization.length()>0){
            //从header中得到token
            //验证token这里只需要写一个条用函数就好返回验证结果
            Claims claims = null;   //解析loginTokenHistory结构
            claims=jwt.parseJWT(authorization);
            if (claims!=null){
                return true;
            }
        }

        return true;
    }
}
