package com.scent.core.util;

import java.io.File;
import java.io.FilenameFilter;

import static com.scent.core.util.Constants.SHARED_LOCATION;
import static com.scent.core.util.Constants.YAML_KEYS_FILE;
import static com.scent.core.util.Constants.YML_EXTENSION;


public class FileUtil {


    public static File[] getPropertyFileList() {
        final File dir = new File(System.getProperty(SHARED_LOCATION));
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(YML_EXTENSION)
                        && !name.toLowerCase().endsWith(YAML_KEYS_FILE);
            }
        });
    }
}
