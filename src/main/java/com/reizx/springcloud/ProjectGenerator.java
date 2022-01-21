package com.reizx.springcloud;

import com.reizx.springcloud.step.*;

import java.io.IOException;

/**
 * @author junke
 */
public class ProjectGenerator {

    public static void main(String[] args) throws IOException {
        ProjectInfo info = new ProjectInfo();
        info.setProjectName("abc-xyz");
        info.setProjectPkg("abc.xyz");
        info.setGroupId("com.reizx");
        info.setDestDirectory("/Users/luyi/IdeaProjects/temp");
//        info.setProjectVersion("1.0.0-SNAPSHOT");

        _1_MainStruct.create(info);
        _2_PomXml.create(info);
        _3_Package.create(info);
        _4_Classes.create(info);
        _5_ConfigFile.create(info);
        _6_ReadMe_md.create(info);
        _7_MybatisPlusGenerator.create(info);
    }
}
