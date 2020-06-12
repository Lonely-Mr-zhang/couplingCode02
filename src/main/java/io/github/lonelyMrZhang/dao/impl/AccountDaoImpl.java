package io.github.lonelyMrZhang.dao.impl;

import io.github.lonelyMrZhang.dao.IAccountDao;

/**
 * @description: 账户的持久层实现类
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:49 上午
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
