package com.xdl.maven.imperial.dao.api;

import com.xdl.maven.imperial.entity.Emp;

public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword);
}
