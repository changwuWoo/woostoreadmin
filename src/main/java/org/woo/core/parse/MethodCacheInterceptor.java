package org.woo.core.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/12.
 */
@Component
public class MethodCacheInterceptor implements MethodInterceptor {
    private List<String> targetNamesList; // 不加入缓存的service名称
    private List<String> methodNamesList; // 不加入缓存的方法名称

    /**
     * 初始化读取不需要加入缓存的类名和方法名称
     */
    public MethodCacheInterceptor() {
        try {
            //配置文件位置直接被写死，有需要自己修改下
//			InputStream in = getClass().getClassLoader().getResourceAsStream(
//					"D:\\lunaJee-workspace\\msm\\msm_core\\src\\main\\java\\com\\mucfc\\msm\\common\\cacheConf.properties");
            Properties p = new Properties();
            p.setProperty("", "");
            // 分割字符串
            String[] targetNames = p.getProperty("targetNames").split(",");
            String[] methodNames = p.getProperty("methodNames").split(",");

            // 加载过期时间设置
            // 创建list
            targetNamesList = new ArrayList<String>(targetNames.length);
            methodNamesList = new ArrayList<String>(methodNames.length);
            Integer maxLen = targetNames.length > methodNames.length ? targetNames.length
                    : methodNames.length;
            // 将不需要缓存的类名和方法名添加到list中
            for (int i = 0; i < maxLen; i++) {
                if (i < targetNames.length) {
                    targetNamesList.add(targetNames[i]);
                }
                if (i < methodNames.length) {
                    methodNamesList.add(methodNames[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;

        String targetName = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        // 不需要缓存的内容
        //if (!isAddCache(StringUtil.subStrForLastDot(targetName), methodName)) {
        if (!isAddCache(targetName, methodName)) {
            // 执行方法返回结果
            return invocation.proceed();
        }
        Object[] arguments = invocation.getArguments();
        String key = getCacheKey(targetName, methodName, arguments);
        System.out.println(key);

        try {
            // 写入缓存
            value = invocation.proceed();
            if (value != null) {
                final String tkey = key;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (tkey.startsWith("com.service.impl.xxxRecordManager")) {

                        } else if (tkey.startsWith("com.service.impl.xxxSetRecordManager")) {

                        } else {
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value == null) {
                return invocation.proceed();
            }
        }
        return value;
    }

    /**
     * 是否加入缓存
     *
     * @return
     */
    private boolean isAddCache(String targetName, String methodName) {
        boolean flag = true;
        if (targetNamesList.contains(targetName)
                || methodNamesList.contains(methodName)) {
            flag = false;
        }
        return flag;
    }

    /**
     * 创建缓存key
     *
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }
}