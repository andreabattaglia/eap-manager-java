/*
 *
 */
package com.redhat.utils.eapmanager.testutils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryDeleter {
    /**
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(DirectoryDeleter.class);

    public void deleteDirectoryRecursively(Path directory) {
        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir,
                        IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            LOG.warn("deleteDirectoryRecursively(Path dir=" + directory
                    + ") - exception ignored", e);
        }
    }

}
