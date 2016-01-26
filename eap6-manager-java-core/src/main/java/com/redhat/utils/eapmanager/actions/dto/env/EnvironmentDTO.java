/*
 *
 */
package com.redhat.utils.eapmanager.actions.dto.env;

import org.codehaus.jackson.annotate.JsonIgnore;

public class EnvironmentDTO implements Comparable<EnvironmentDTO> {
    @JsonIgnore
    private String id;

    /** The hostname. */
    private String hostname;

    /** The port. */
    private String port;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The realm. */
    private String realm;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname
     *            the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port
     *            the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the realm
     */
    public String getRealm() {
        return realm;
    }

    /**
     * @param realm
     *            the realm to set
     */
    public void setRealm(String realm) {
        this.realm = realm;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EnvironmentDTO other = (EnvironmentDTO) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(EnvironmentDTO o) {
        return id.compareTo(o.id);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EnvironmentDTO [\n    id=");
        builder.append(id);
        builder.append(", \n    hostname=");
        builder.append(hostname);
        builder.append(", \n    port=");
        builder.append(port);
        builder.append(", \n    username=");
        builder.append(username);
        builder.append(", \n    password=");
        builder.append(password);
        builder.append(", \n    realm=");
        builder.append(realm);
        builder.append("\n]");
        return builder.toString();
    }

}
