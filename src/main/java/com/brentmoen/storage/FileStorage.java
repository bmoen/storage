package com.brentmoen.storage;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class FileStorage implements Storage {
    private final File storageFolder;

    FileStorage(File storageFolder) {
        this.storageFolder = Objects.requireNonNull(storageFolder);
    }

    @Override
    public String get(String key) {
        try {
            return FileUtils.readFileToString(new File(storageFolder, key), Charset.defaultCharset());
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void put(String key, String value) {
        try {
            FileUtils.writeStringToFile(new File(storageFolder, key), value, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
