package com.xdl.maven.imperial.service.api;

import com.xdl.maven.imperial.entity.Memorials;

import java.util.List;

public interface MemorialsService {

    List<Memorials> getAllMemorialsDigest();

    Memorials getMemorialsDetailById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);
}
