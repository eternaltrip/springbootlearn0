package cn.yj.ip_spring_boot_starter.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 统计属性设置
 */
@Component("ipProperties")
@ConfigurationProperties("tools.ip")
public class IpProperties {

    /**
     * 循环时间
     */
    private Long circle = 5l;


    /**
     * 显示方式 ， SIMPLE:简单 ； DETAIL:详情。
     */
    private String model = LogModel.DETAIL.name();

    public enum LogModel{
        SIMPLE("simple"),
        DETAIL("detail");
        private String name;

        LogModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Long getCircle() {
        return circle;
    }

    public void setCircle(Long circle) {
        this.circle = circle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
