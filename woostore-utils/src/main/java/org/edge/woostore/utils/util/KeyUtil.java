package org.edge.woostore.utils.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import java.io.*;
import java.security.Key;

/**
 * Created by Administrator on 2017/3/26.
 */
public class KeyUtil {
    private static Log logger = LogFactory.getLog(KeyUtil.class);
    public static Key getKey(ServletContext context) {
        String path = (context.getRealPath("/key"));
        File file = new File(path, "key.txt");
        try {
            if (!file.exists()) {
                Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
                ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
                oo.writeObject(key);
                oo.close();
                return key;
            }
            ObjectInputStream ois = null;

            ois = new ObjectInputStream(new FileInputStream(file));

            Key key = (Key) ois.readObject();
            return key;
        } catch (Exception e) {
            logger.debug(e);
            e.printStackTrace();
            return null;
        }
    }
}
