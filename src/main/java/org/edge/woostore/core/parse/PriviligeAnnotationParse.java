package org.edge.woostore.core.parse;


import org.edge.woostore.domain.annotation.AccessPrivilegeValidate;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/24.
 */
public class PriviligeAnnotationParse {
        public static String parse(Class targetclass,String methodName) throws NoSuchMethodException {
            String methodAccess="";
            Method method=targetclass.getMethod(methodName);
            if(method.isAnnotationPresent(AccessPrivilegeValidate.class)){
                AccessPrivilegeValidate accessPrivilege =method.getAnnotation(AccessPrivilegeValidate.class);
                methodAccess= accessPrivilege.value();
            }
            return methodAccess==""?"":methodAccess;
        }
    }
