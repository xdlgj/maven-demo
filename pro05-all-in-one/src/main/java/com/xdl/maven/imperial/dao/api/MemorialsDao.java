package com.xdl.maven.imperial.dao.api;

import com.xdl.maven.imperial.entity.Memorials;

import java.util.List;

public interface MemorialsDao {
    List<Memorials> selectAllMemorialsDigest();
}
