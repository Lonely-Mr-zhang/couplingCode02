package io.github.lonelyMrZhang.ui;

import io.github.lonelyMrZhang.factory.BeanFactory;
import io.github.lonelyMrZhang.service.IAccountService;
import io.github.lonelyMrZhang.service.impl.AccountServiceImpl;

/**
 * @description: 模拟表现层，调用业务层
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:53 上午
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            accountService.saveAccount();
        }
    }
}
