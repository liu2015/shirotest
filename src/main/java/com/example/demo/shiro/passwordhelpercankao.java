package com.example.demo.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;

public class passwordhelpercankao {

    private RandomNumberGenerator randomOb = new RandomNumberGenerator();

    //散列算法名（md5方式）
    private static final String ALGORITHM_NAME = "md5";

    //散列迭代次数
    private static final int HASH_ITERATION = 2;

    /**
     *  加密用户
     * @param user 用户，用户名(name)、密码(pwd)、盐\加密因子(salt)
     */
    public void encryptPassword(User user){
        //生成加密因子，保存盐。
        user.setSalt(randomOb.nextBytes().toHex());
        //加密密码 SimpleHash（算法名，密码，盐的byte，次数）.toHex()
        String newPassword = new SimpleHash(ALGORITHM_NAME ,user.getPwd,ByteSource.Util.bytes(user.getSalt()),HASH_ITERATION).toHex();
        //更新密码
        user.setPwd(newPassword );
    }
}
