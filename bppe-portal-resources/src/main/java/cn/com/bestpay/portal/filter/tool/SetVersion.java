package cn.com.bestpay.portal.filter.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by yfzx_gd_yanghh on 2016/9/28.
 */
public class SetVersion {
    private static Logger logger = LoggerFactory.getLogger(SetVersion.class);

    private static String resourceVersion;
    /**
     * Response 注入静态资源版本号
     * @param content
     * @return
     */
    public static String setFileVersion(String content){
        if(resourceVersion == null){
            resourceVersion=RandomString(9);
        }
        return content.replaceAll("v=&version&","v="+resourceVersion);
    }


    /** 产生一个随机的字符串*/
    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

}