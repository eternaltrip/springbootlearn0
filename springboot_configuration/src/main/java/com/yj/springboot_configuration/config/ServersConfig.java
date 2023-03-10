package com.yj.springboot_configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ValidateOnExecution;

//@Component

@Data
@ConfigurationProperties(prefix = "servers")
@Validated
public class ServersConfig {
    @Pattern(regexp = "")
    private String name;
    @Max(value = 999 ,message = "最大999")
    private Integer port;
    private String timeout;
}
