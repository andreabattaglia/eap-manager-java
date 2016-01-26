/**
 *
 */
package com.redhat.utils.eapmanager.configuration.impl;

import static com.redhat.utils.eapmanager.constants.ObjectMapperType.DEFAULT_MAPPER;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.redhat.utils.eapmanager.AbstractTest;
import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentDTO;
import com.redhat.utils.eapmanager.constants.ApplicationConstants;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public class EnvironmentDTOConversionTest extends AbstractTest {
    private static EnvironmentDTO localhostEnvironment;

    static {
        localhostEnvironment = populateEnvironmentObject("localhost",
                "localhost", "9999", "ManagementRealm", "admin", "password");
    }

    public static void setUpBeforeClass() throws Exception {
        Path target = Paths.get(".");
        System.out.println(target.toString());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    private static EnvironmentDTO populateEnvironmentObject(String id,
            String hostname, String port, String realm, String username,
            String password) {
        EnvironmentDTO environment = new EnvironmentDTO();
        environment.setId(id);
        environment.setHostname(hostname);
        environment.setPort(port);
        environment.setRealm(realm);
        environment.setUsername(username);
        environment.setPassword(password);
        return environment;
    }

    /**
     * @throws java.lang.Exception
     */
    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    // @Test
    public void objectToJSon() {
        try {
            System.out.println(DEFAULT_MAPPER.getObjectMapper()
                    .writeValueAsString(localhostEnvironment));
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void objectToFile() {
        try {
            String envConfig = DEFAULT_MAPPER.getObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(localhostEnvironment);
            System.out.println("env object to json:\n" + envConfig);
            Path envFile = envFolder.resolve(localhostEnvironment.getId()
                    + ApplicationConstants.CONFIGURATION_FILE_EXTENSION
                            .getValue());
            // Not necessary
            // Files.createFile(envFile);
            try (BufferedWriter bw = Files.newBufferedWriter(envFile)) {
                bw.write(envConfig);
            }
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
