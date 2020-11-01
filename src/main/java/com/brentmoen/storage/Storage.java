package com.brentmoen.storage;

import java.io.File;

public interface Storage {
    static Storage getInstance(File localStorageFolder) {
        return new FileStorage(localStorageFolder);
    }

    String get(String key);

    void put(String key, String value);
}
