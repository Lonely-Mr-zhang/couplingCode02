package io.github.lonelyMrZhang.service.impl;

import io.github.lonelyMrZhang.dao.IAccountDao;
import io.github.lonelyMrZhang.dao.impl.AccountDaoImpl;
import io.github.lonelyMrZhang.factory.BeanFactory;
import io.github.lonelyMrZhang.service.IAccountService;

/**
 * @description:
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:44 上午
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
