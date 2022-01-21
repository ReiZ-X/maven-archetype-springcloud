package com.reizx.springcloud.step;

import com.reizx.springcloud.ProjectInfo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import static com.reizx.springcloud.Util.copyFile;

/**
 * @author junke
 */
public class _6_ReadMe_md {

    public static void create(ProjectInfo info) throws IOException {
        //
        copyFile("/others/README.md",
                Paths.get(info.getDestDirectory(), info.getProjectName(), "README.md"), new HashMap<>());

    }
}
