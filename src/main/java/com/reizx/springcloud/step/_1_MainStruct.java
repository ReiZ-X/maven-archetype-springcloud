package com.reizx.springcloud.step;

import com.reizx.springcloud.ProjectInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author junke
 */
public class _1_MainStruct {

    public static void create(ProjectInfo info) throws IOException {
        String destDirectory = info.getDestDirectory();
        String projectName = info.getProjectName();
        Path projectPath = Paths.get(destDirectory, projectName);
        if (!Files.exists(projectPath)) {
            Files.createDirectories(projectPath);
        }
        //
        if (Files.list(projectPath).findAny().isPresent()) {
//            throw new RuntimeException("is not blank directory。" + projectPath);
        }
        //create directories
        createApiModule(info);
        createSvcModule(info);
    }

    private static void createApiModule(ProjectInfo info) throws IOException {
        Files.createDirectories(info.apiMainJavaPkg());
    }

    private static void createSvcModule(ProjectInfo info) throws IOException {
        Files.createDirectories(info.svcMainJavaPkg());
        Files.createDirectories(info.svcMainResPkg());
        Files.createDirectories(info.svcTestJavaPkg());
        Files.createDirectories(info.svcTestResPkg());
    }
}
