package com.reizx.springcloud.step;

import com.reizx.springcloud.ProjectInfo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.reizx.springcloud.Util.copyFile;

/**
 * @author junke
 */
public class _5_ConfigFile {

    public static void create(ProjectInfo info) throws IOException {
        Map<String, String> replaces = new HashMap<>(1);
        replaces.put("${{projectName}}", info.getProjectName());
        //
        copyFile("/yaml/bootstrap.yaml",
                Paths.get(info.svcMainResPkg().toString(), "bootstrap.yaml"), replaces);
        copyFile("/logback/logback-spring.xml",
                Paths.get(info.svcMainResPkg().toString(), "logback-spring.xml"), new HashMap<>());
    }
}
