package com.i2soft.i2up.v20240819.backupSet;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.backupSet.v20240819.BackupSetImport;
import com.i2soft.util.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BackupSetImportTest {

    private static Auth auth;
    private static BackupSetImport backupSetImport;

    @BeforeClass
    public static void setUp() {
        if (backupSetImport != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backupSetImport = new BackupSetImport(auth);
    }
}