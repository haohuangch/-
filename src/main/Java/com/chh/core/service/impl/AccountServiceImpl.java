package com.chh.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chh.core.dao.AccountDao;
import com.chh.core.entity.Account;
import com.chh.core.service.AccountService;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public int regist(Account account) {
        return accountDao.addAccount(account);
    }
}