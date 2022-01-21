package com.reizx.springcloud;

import lombok.Data;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author junke
 */
@Data
public class ProjectInfo {
    private String destDirectory;
    private String projectName;
    /**
     * when project name with '-', but java pkg path '-' is not allowed.
     * e.g: if project name is abc-xyz, then project pkg can ben abc.xyz
     */
    private String projectPkg;
    /**
     * this is base group, base project pkg.
     * e.g: project name is abc, then whole base package will be 'com.reizx.abc'(if group id com.reizx).
     */
    private String groupId;

    public Path projectBasePath() {
        return Paths.get(destDirectory, projectName);
    }

    public Path apiBasePath() {
        return Paths.get(destDirectory, projectName, projectName + "-api");
    }

    public Path svcBasePath() {
        return Paths.get(destDirectory, projectName, projectName + "-svc");
    }

    public Path apiMainJavaPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-api", "src", "main", "java");
    }

    public Path apiBaseJavaPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-api", "src", "main", "java",
                groupId.replace(".", File.separator), projectPkg.replace(".", File.separator));
    }

    public Path svcMainJavaPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-svc", "src", "main", "java");
    }

    public Path svcMainResPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-svc", "src", "main", "resources");
    }

    public Path svcTestJavaPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-svc", "src", "test", "java");
    }

    public Path svcTestResPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-svc", "src", "test", "resources");
    }

    public Path svcBaseJavaPkg() {
        return Paths.get(destDirectory, projectName, projectName + "-svc", "src", "main", "java",
                groupId.replace(".", File.separator), projectPkg.replace(".", File.separator));
    }


}
