package web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String error_invalid_user;
    private String error_user_locked;

    public String getError_invalid_user() {
        return error_invalid_user;
    }

    public void setError_invalid_user(String error_invalid_user) {
        this.error_invalid_user = error_invalid_user;
    }

    public String getError_user_locked() {
        return error_user_locked;
    }

    public void setError_user_locked(String error_user_locked) {
        this.error_user_locked = error_user_locked;
    }

}
