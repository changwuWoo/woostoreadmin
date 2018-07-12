package org.woo.core.aspect;

import io.jsonwebtoken.Claims;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.woo.core.service.ITokenService;
import org.woo.utils.constant.Constants;
import org.woo.utils.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/3/22.
 */
@Aspect
@Component
public class AccessTokenAspect {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITokenService iTokenService;

    private JwtUtil jwt = new JwtUtil();


    @Before("@annotation(AccessTokenValidate) )")// 把定义好的切入通知注解引入，作为切点的通知函数
    @ResponseBody
    public boolean doAccessCheck(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = null;
        String authorization = request.getParameter(Constants.AUTHORIZATION).trim().toString();
        if (authorization != null && authorization.length() > 0) {
            //从header中得到token
            //验证token这里只需要写一个条用函数就好返回验证结果
            Claims claims = null;   //解析loginTokenHistory结构
            claims = jwt.parseJWT(authorization);
            if (claims != null) {
                return true;
            }
        }

        return true;
    }
}
