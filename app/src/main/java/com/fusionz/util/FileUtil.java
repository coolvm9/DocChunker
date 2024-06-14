package com.fusionz.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
    public static List<File> getFilesFromDirectory(String directoryPath, List<String> mimeTypes) throws IOException {
        List<File> files = new ArrayList<>();
        File directory = new File(directoryPath);
        addFilesFromDirectory(directory, mimeTypes, files);
        return files;
    }

    private static void addFilesFromDirectory(File directory, List<String> mimeTypes, List<File> files) throws IOException {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                addFilesFromDirectory(file, mimeTypes, files);
            } else {
                String mimeType = Files.probeContentType(file.toPath());
                if (mimeTypes.contains(mimeType)) {
                    files.add(file);
                }
            }
        }
    }

}
