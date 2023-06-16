package dev.dhb.clownfiesta.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.List;
@Configuration
@ConfigurationProperties(prefix = "rbac")
public class RBACConfig {
    private Map<String, List<String>> permissions;

    public Map<String, List<String>> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, List<String>> permissions) {
        this.permissions = permissions;
    }

}
