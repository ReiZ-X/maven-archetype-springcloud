package com.reizx.springcloud.step;

import com.reizx.springcloud.ProjectInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.reizx.springcloud.Util.copyFile;

/**
 * @author junke
 */
public class _7_MybatisPlusGenerator {
    public static void create(ProjectInfo info) throws IOException {
        Map<String, String> replaces = new HashMap<>(2);
        replaces.put("${{projectPkg}}", info.getProjectPkg());
        replaces.put("${{groupId}}", info.getGroupId());
        copyFile("/classes/MybatisPlusGenerator.java",
                Paths.get(info.svcTestJavaPkg().toString(), info.getGroupId().replace(".", File.separator), "MybatisPlusGenerator.java"),
                replaces);

    }
}
