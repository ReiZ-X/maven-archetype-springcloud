package ${{groupId}}.${{projectPkg}};

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */

@MapperScan("${{groupId}}.${{projectPkg}}.mapper")
@EnableTransactionManagement
@SpringBootApplication
//依赖别的服务时打开这个，并添加包名
// @EnableFeignClients(basePackages = {""})
@EnableDiscoveryClient
public class ${{upperProjectName}}Application {

    public static void main(String[] args) {
        SpringApplication.run(${{upperProjectName}}Application.class, args);
    }

}
