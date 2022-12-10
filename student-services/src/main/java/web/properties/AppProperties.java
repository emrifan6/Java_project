package web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String error_invalid_user;
    private String error_user_locked;
    private String succes_registration;
    private String error_already_registered;

}
