package org.edge.woostore.core.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.edge.woostore.core.parse.PriviligeAnnotationParse;
import org.springframework.stereotype.Component;
import org.edge.woostore.domain.entity.Privilege;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */
@Aspect
@Component
public class AccessPrivilegeAspect {
    private Log logger = LogFactory.getLog(AccessPrivilegeAspect.class);
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Around("@annotation(org.edge.woostore.domain.annotation.AccessPrivilegeValidate)")
    public void isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Class targetClass=joinPoint.getTarget().getClass();
        String methodName=joinPoint.getSignature().getName();
        //解析访问这个资源需要的权限
        String methodAccess= PriviligeAnnotationParse.parse(targetClass,methodName);
        boolean isAccessed=false;
        logger.debug(joinPoint);
        for (Privilege frimPrivilege:privileges) {
            if("".equals(methodAccess)){
                isAccessed=true;
                break;
            }
            if(frimPrivilege.getPrivilegeAccessValue()!=null&&frimPrivilege.getPrivilegeAccessValue().equalsIgnoreCase(methodAccess)){
                isAccessed=true;
                break;
            }
        }
        if (isAccessed){
            joinPoint.proceed();
            System.out.println(methodName+" action accessed");
        }else{
            System.out.println(methodName+"action failed");
        }

    }
}
