package com.xdl.maven.imperial.dao.impl;

import com.xdl.maven.imperial.dao.BaseDao;
import com.xdl.maven.imperial.dao.api.MemorialsDao;
import com.xdl.maven.imperial.entity.Memorials;

import java.util.List;

public class MemorialsDaoImpl extends BaseDao<Memorials> implements MemorialsDao {
    @Override
    public List<Memorials> selectAllMemorialsDigest() {
        String sql = "select memorials_id memorialsId,\n" +
                "       memorials_title memorialsTitle,\n" +
                "       concat(left(memorials_content, 10), \"...\") memorialsContentDigest,\n" +
                "       emp_name memorialsEmpName,\n" +
                "       memorials_create_time memorialsCreateTime,\n" +
                "       memorials_status memorialsStatus\n" +
                "from t_memorials m left join  t_emp e on m.memorials_emp=e.emp_id;";
        return getBeanList(sql, Memorials.class);
    }

    @Override
    public Memorials selectMemorialsById(String memorialsId) {
        String sql = "select memorials_id memorialsId,\n" +
                "       memorials_title memorialsTitle,\n" +
                "       memorials_content memorialsContent,\n" +
                "       emp_name memorialsEmpName,\n" +
                "       memorials_create_time memorialsCreateTime,\n" +
                "       memorials_status memorialsStatus,\n" +
                "       feedback_time feedbackTime,\n" +
                "       feedback_content feedbackContent\n" +
                "from t_memorials m left join  t_emp e on m.memorials_emp=e.emp_id " +
                "where memorials_id=?;";

        return getSingleBean(sql, Memorials.class, memorialsId);
    }

    @Override
    public void updateMemorialsStatusToRead(String memorialsId) {
        String sql = "update t_memorials set memorials_status=1 where memorials_id=?";
        update(sql, memorialsId);
    }
}