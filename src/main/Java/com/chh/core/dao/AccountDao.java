package com.chh.core.dao;

import java.util.List;
import java.util.Map;

import com.chh.core.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {

    /**
     * 登录
     *
     * @param account
     * @return
     */
    public Account login(Account account);

    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<Account> findAccounts(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalAccount(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param account
     * @return
     */
    public int updateAccount(Account account);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addAccount(Account account);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteAccount(Integer id);
}
