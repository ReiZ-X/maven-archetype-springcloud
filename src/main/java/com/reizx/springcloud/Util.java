package com.reizx.springcloud;

import cn.hutool.core.io.IoUtil;
import com.reizx.springcloud.step._2_PomXml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author junke
 */
public class Util {

    public static void copyFile(String srcFile, Path destFilePath, Map<String, String> replaces) throws IOException {
        InputStream is = _2_PomXml.class.getResourceAsStream(srcFile);
        String code = IoUtil.readUtf8(is);
        for (Map.Entry<String, String> entry : replaces.entrySet()) {
            code = code.replace(entry.getKey(), entry.getValue());
        }
        if (!Files.exists(destFilePath)) {
            Files.createFile(destFilePath);
        }
        FileOutputStream fos = new FileOutputStream(destFilePath.toFile());
        IoUtil.writeUtf8(fos, true, code);
    }
}
