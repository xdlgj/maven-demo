package com.xdl.maven.imperial.service.api;

import com.xdl.maven.imperial.entity.Emp;

public interface EmpService {
    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
