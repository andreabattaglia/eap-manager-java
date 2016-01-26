package com.redhat.utils.eapmanager.configuration.impl;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.redhat.utils.eapmanager.constants.ApplicationConstants;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public class ConfigurationFileFilter implements Filter<Path> {

    /**
     * @see java.nio.file.DirectoryStream.Filter#accept(java.lang.Object)
     */
    @Override
    public boolean accept(Path entry) throws IOException {
        return (!Files.isDirectory(entry)) && (entry.toString().toLowerCase()
                .endsWith(ApplicationConstants.CONFIGURATION_FILE_EXTENSION
                        .getValue()));
    }

}
