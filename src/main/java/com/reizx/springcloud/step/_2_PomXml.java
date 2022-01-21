package com.reizx.springcloud.step;

import cn.hutool.core.io.IoUtil;
import com.reizx.springcloud.ProjectInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author junke
 */
public class _2_PomXml {

    public static void create(ProjectInfo info) throws IOException {
        createPom(info);
        createApiPom(info);
        createSvcPom(info);
    }

    private static void createSvcPom(ProjectInfo info) throws IOException {
        InputStream is = _2_PomXml.class.getResourceAsStream("/pom/svc-pom.xml");
        String yaml = IoUtil.readUtf8(is).replace("${{projectName}}", info.getProjectName());
        //write to dest file
        Path basePath = info.svcBasePath();
        Path path = Paths.get(basePath.toString(), "pom.xml");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        //
        FileOutputStream fos = new FileOutputStream(path.toFile());
        IoUtil.writeUtf8(fos, true, yaml);
    }

    private static void createApiPom(ProjectInfo info) throws IOException {
        InputStream is = _2_PomXml.class.getResourceAsStream("/pom/api-pom.xml");
        String yaml = IoUtil.readUtf8(is).replace("${{projectName}}", info.getProjectName());
        //write to dest file
        Path basePath = info.apiBasePath();
        Path path = Paths.get(basePath.toString(), "pom.xml");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        //
        FileOutputStream fos = new FileOutputStream(path.toFile());
        IoUtil.writeUtf8(fos, true, yaml);
    }


    private static void createPom(ProjectInfo info) throws IOException {
        InputStream is = _2_PomXml.class.getResourceAsStream("/pom/pom.xml");
        String yaml = IoUtil.readUtf8(is).replace("${{projectName}}", info.getProjectName());
        //write to dest file
        Path basePath = info.projectBasePath();
        Path path = Paths.get(basePath.toString(), "pom.xml");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        //
        FileOutputStream fos = new FileOutputStream(path.toFile());
        IoUtil.writeUtf8(fos, true, yaml);
    }
}
