/**
 *
 */
package com.redhat.utils.eapmanager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.redhat.utils.eapmanager.constants.FolderConstants;
import com.redhat.utils.eapmanager.testutils.DirectoryDeleter;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public abstract class AbstractTest {
    protected Path configFolder;
    protected Path envFolder;
    protected Path logFolder;

    protected final DirectoryDeleter directoryDeleter = new DirectoryDeleter();

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Path target = Paths.get("target/test-classes");
        configFolder = target
                .resolve(FolderConstants.CONFIG_FOLDER_NAME.getValue());
        envFolder = target
                .resolve(FolderConstants.ENVIRONMENT_FOLDER_NAME.getValue());
        logFolder = target.resolve(FolderConstants.LOG_FOLDER_NAME.getValue());
        createFolders();
    }

    private void createFolders() throws IOException {
        Files.createDirectories(configFolder);
        Files.createDirectories(envFolder);
        Files.createDirectories(logFolder);

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        deleteFolders();
    }

    private void deleteFolders() {
        directoryDeleter.deleteDirectoryRecursively(configFolder);
        directoryDeleter.deleteDirectoryRecursively(envFolder);
        directoryDeleter.deleteDirectoryRecursively(logFolder);

    }
}
