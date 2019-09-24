package com.example.demo.shiro;

import com.example.demo.entity.Usershiro;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 *  这个是密码加密的部分，是用了加密因子
 */

public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();

    public static final String md5="md5";
    public static final int hash=2;

    public void eencryptPassword(Usershiro usershiro){
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        usershiro.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(md5, usershiro.getPassword(),

                ByteSource.Util.bytes(usershiro.getCredentialsSalt()), hash).toHex();
        /**
         *  getCredentialsSalt 这个是干扰因子，一般是用用户名+salt盐 组合 是一般放在user表里
         */


        usershiro.setPassword(newPassword);
    }


}
