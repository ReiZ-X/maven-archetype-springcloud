package com.reizx.springcloud.step;

import com.reizx.springcloud.ProjectInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author junke
 */
public class _3_Package {

    public static void create(ProjectInfo info) throws IOException {
        createApIPkgs(info);
        createSvcPkgs(info);
    }

    private static void createApIPkgs(ProjectInfo info) throws IOException {
        Files.createDirectories(Paths.get(info.apiBaseJavaPkg().toString(), "api"));
        Files.createDirectories(Paths.get(info.apiBaseJavaPkg().toString(), "dto"));
    }

    private static void createSvcPkgs(ProjectInfo info) throws IOException {
        Files.createDirectories(Paths.get(info.svcBaseJavaPkg().toString(), "controller"));
        Files.createDirectories(Paths.get(info.svcBaseJavaPkg().toString(), "service"));
        Files.createDirectories(Paths.get(info.svcBaseJavaPkg().toString(), "mapper", "model"));
        Files.createDirectories(Paths.get(info.svcBaseJavaPkg().toString(), "config"));
        Files.createDirectories(Paths.get(info.svcBaseJavaPkg().toString(), "enums"));
        Files.createDirectories(Paths.get(info.svcTestJavaPkg().toString(), info.getGroupId().replace(".", File.separator), "generated"));


    }
}
