package com.chh.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chh.core.entity.Account;
import com.chh.core.utils.code.MD5;
import com.chh.core.utils.DateUtil;
import com.chh.core.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;
    private static final Logger log = Logger.getLogger(AccountController.class);// 日志文件

    /**
     * 注册
     *
     * @param account
     * @param request
     * @return
     */
    @RequestMapping("/regist")
    public String regist(Account account, HttpServletRequest request) {
        String accountName = account.getName();
        String accountLoginPwd = account.getLoginPwd();
        String accountPhone = account.getPhone();

        //try {
        String MD5pwd = MD5.getMD5ofStr(accountLoginPwd);
        account.setLoginPwd(MD5pwd);
        //} catch (Exception e) {
          //  account.setLoginPwd("");
        //}

        Date nowDate = new Date();
        account.setLoginPwdModifyTime(DateUtil.dateStr(nowDate, DateUtil.DATETIME_PATTERN));
        account.setRegistTime(DateUtil.dateStr(nowDate, DateUtil.DATETIME_PATTERN));
        account.setLoginTime(DateUtil.dateStr(nowDate, DateUtil.DATETIME_PATTERN));
        account.setPrivilege(0);
        int resultAccount = accountService.regist(account);

        return "redirect:/login.jsp";
    }
}
