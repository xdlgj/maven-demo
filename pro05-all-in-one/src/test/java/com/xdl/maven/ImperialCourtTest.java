package com.xdl.maven;

import com.xdl.maven.imperial.dao.BaseDao;
import com.xdl.maven.imperial.entity.Emp;
import com.xdl.maven.imperial.util.JDBCUtils;
import com.xdl.maven.imperial.util.MD5Util;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<Emp>();

    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);
        JDBCUtils.releaseConnection(connection);
    }

    @Test
    public void testGetBean() {
        String sql = "select emp_id empId,emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword from t_emp where emp_id=1";
        Emp emp = baseDao.getSingleBean(sql, Emp.class);
        System.out.println("emp = " + emp);
    }

    @Test
    public void testGetBeanList() {
        String sql = "select emp_id empId,emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword from t_emp";
        List<Emp> empList = baseDao.getBeanList(sql, Emp.class);
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testA() {
        String sql = "update t_emp set emp_name=? where emp_id=?";
        int affectedRows = baseDao.update(sql, "爱新觉罗·玄烨", 1);
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void testSubstring() {
        // 最后一个点的坐标位置
        String str = "a.aa.png";
        int i = str.lastIndexOf(".");
        System.out.println(i);
        // .png
        String substring = str.substring(i);
        System.out.println(substring);
    }
    @Test
    public void testMd5 () {
        String encode = MD5Util.encode("123");
        System.out.println(encode);
    }
}
