/*
 * 
 */
package com.redhat.utils.eapmanager.events;

public class EnvironmentSelectedEvent {
    private String environmentName;

    /**
     * @return the environmentName
     */
    public String getEnvironmentName() {
        return environmentName;
    }

    /**
     * @param environmentName
     *            the environmentName to set
     */
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result)
                + ((environmentName == null) ? 0 : environmentName.hashCode());
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
        EnvironmentSelectedEvent other = (EnvironmentSelectedEvent) obj;
        if (environmentName == null) {
            if (other.environmentName != null) {
                return false;
            }
        } else if (!environmentName.equals(other.environmentName)) {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EnvironmentSelectedEvent [\n    environmentName=");
        builder.append(environmentName);
        builder.append("\n]");
        return builder.toString();
    }

}
