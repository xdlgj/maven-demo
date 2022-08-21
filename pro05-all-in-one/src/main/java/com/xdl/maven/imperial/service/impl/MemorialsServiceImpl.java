package com.xdl.maven.imperial.service.impl;

import com.xdl.maven.imperial.dao.api.MemorialsDao;
import com.xdl.maven.imperial.dao.impl.MemorialsDaoImpl;
import com.xdl.maven.imperial.entity.Memorials;
import com.xdl.maven.imperial.service.api.MemorialsService;

import java.util.List;

public class MemorialsServiceImpl implements MemorialsService {
    private MemorialsDao memorialsDao = new MemorialsDaoImpl();

    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsDao.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialsDetailById(String memorialsId) {
        return memorialsDao.selectMemorialsById(memorialsId);
    }

    @Override
    public void updateMemorialsStatusToRead(String memorialsId) {
        memorialsDao.updateMemorialsStatusToRead(memorialsId);
    }
}
