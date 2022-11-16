package com.kangkang.common.utils;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * ClassName:EncryptUtil
 * Package:com.asiainfo.utils
 * Description:
 *
 * @date:2022/7/27 16:15
 * @author:kangkang
 */
public class EncryptUtil {
    public static void urlAndUsernameAndPassword(String url,String username,String password) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // 加密秘钥(盐)
        textEncryptor.setPassword("kangkang");
        // 要加密的数据（数据库的用户名或密码）
        String username1 = textEncryptor.encrypt(username);
        String password1 = textEncryptor.encrypt(password);
        String url1= textEncryptor.encrypt(url);
        System.out.println("url:"+url1);
        System.out.println("username:" + username1);
        System.out.println("password:" + password1);
    }

    public static void main(String[] args) {
        //生成密文
        EncryptUtil.urlAndUsernameAndPassword("jdbc:mysql://localhost:3366/agricultural?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8","root","kangkang");
    }
}
