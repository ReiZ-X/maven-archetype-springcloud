package com.reizx.springcloud.step;

import cn.hutool.core.util.StrUtil;
import com.reizx.springcloud.ProjectInfo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.reizx.springcloud.Util.copyFile;

/**
 * @author junke
 */
public class _4_Classes {

    public static void create(ProjectInfo info) throws IOException {
        createApiClasses(info);
        createSvcClasses(info);
    }

    private static void createApiClasses(ProjectInfo info) throws IOException {
        Map<String, String> replaces = new HashMap<>(1);
        replaces.put("${{projectPkg}}", info.getProjectPkg());
        replaces.put("${{projectName}}", info.getProjectName());
        replaces.put("${{groupId}}", info.getGroupId());
        //
        copyFile("/classes/ExampleApi.java",
                Paths.get(info.apiBaseJavaPkg().toString(), "api", "ExampleApi.java"),
                replaces);
        copyFile("/classes/ExampleReq.java",
                Paths.get(info.apiBaseJavaPkg().toString(), "dto", "ExampleReq.java"),
                replaces);
        copyFile("/classes/ExampleRsp.java",
                Paths.get(info.apiBaseJavaPkg().toString(), "dto", "ExampleRsp.java"),
                replaces);
    }

    private static void createSvcClasses(ProjectInfo info) throws IOException {
        //
        String upperProjectName = info.getProjectName().substring(0, 1).toUpperCase() + info.getProjectName().substring(1);
        String[] segments = upperProjectName.split("-");
        StringBuilder sb = new StringBuilder();
        for (String segment : segments) {
            if (StrUtil.isNotBlank(segment)) {
                sb.append(segment.substring(0, 1).toUpperCase());
                if (segment.length() > 1) {
                    sb.append(segment.substring(1));
                }
            }
        }
        upperProjectName = sb.toString();
        Map<String, String> replaces = new HashMap<>(2);
        replaces.put("${{projectPkg}}", info.getProjectPkg());
        replaces.put("${{groupId}}", info.getGroupId());
        replaces.put("${{projectName}}", info.getProjectName());
        replaces.put("${{upperProjectName}}", upperProjectName);
        //
        copyFile("/classes/R.java",
                Paths.get(info.svcBaseJavaPkg().toString(),  "R.java"),
                replaces);
        copyFile("/classes/ResultCode.java",
                Paths.get(info.svcBaseJavaPkg().toString(),  "ResultCode.java"),
                replaces);
        copyFile("/classes/ExampleApplication.java",
                Paths.get(info.svcBaseJavaPkg().toString(), upperProjectName + "Application.java"),
                replaces);
        copyFile("/classes/ExampleController.java",
                Paths.get(info.svcBaseJavaPkg().toString(), "controller", "ExampleController.java"),
                replaces);
        copyFile("/classes/ExampleService.java",
                Paths.get(info.svcBaseJavaPkg().toString(), "service", "ExampleService.java"),
                replaces);
        copyFile("/classes/ExampleMapper.java",
                Paths.get(info.svcBaseJavaPkg().toString(), "mapper", "ExampleMapper.java"),
                replaces);
        copyFile("/classes/ExampleDO.java",
                Paths.get(info.svcBaseJavaPkg().toString(), "mapper", "model", "ExampleDO.java"),
                replaces);
        copyFile("/classes/GlobalExceptionHandler.java",
                Paths.get(info.svcBaseJavaPkg().toString(), "GlobalExceptionHandler.java"),
                replaces);
    }
}
