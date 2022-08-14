package com.xdl.maven.imperial.service.impl;

import com.xdl.maven.imperial.dao.api.EmpDao;
import com.xdl.maven.imperial.dao.impl.EmpDaoImpl;
import com.xdl.maven.imperial.entity.Emp;
import com.xdl.maven.imperial.exception.LoginFailedException;
import com.xdl.maven.imperial.service.api.EmpService;
import com.xdl.maven.imperial.util.ImperialCourtConst;
import com.xdl.maven.imperial.util.MD5Util;

public class EmpServiceImpl implements EmpService {

    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {
        //1、对密码执行加密
        String encodedLoginPassword = MD5Util.encode(loginPassword);
        //2、根据账号和密码查询数据库
        Emp emp = empDao.selectEmpByLoginAccount(loginAccount, encodedLoginPassword);
        //3、检查Emp对象是否为null
        if (emp != null) {
            return emp;
        } else {
           throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
