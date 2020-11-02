package cn.com.tyyxtech.frame.admin.modules.sys.controller;

import cn.com.tyyxtech.frame.admin.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangLong
 * @Date 2020/11/2020/11/2 15:08
 * @Description
 */
public class AbstractController {
    protected  Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser(){
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();

        return (SysUserEntity) principal;
    }

    protected Long getUserId(){
        return getUser().getUserId();
    }

}
