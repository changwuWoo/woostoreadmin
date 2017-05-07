/**
 * 
 */
package org.edge.woostore.utils.constant;

import java.util.Random;

import org.apache.log4j.Logger;

/** 
 * @ClassName: TokenSign
 * @Description: TODO
 * @author Administrator 
 * @date 2017年3月13日 下午9:41:43 
 *  
 */
public class TokenSignConstant {
	private String typ;
	private String alg;
	/**
     * 保存token值的默认命名空间
     */
    public static final String TOKEN_NAMESPACE = "xxx.tokens";

    /**
     * 持有token名称的字段名
     */
    public static final String TOKEN_NAME_FIELD = "xxx.token.name";
    private static final Logger LOG = Logger.getLogger(TokenSignConstant.class);
    private static final Random RANDOM = new Random();
}
