package ${{groupId}};

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

/**
 * @author junke
 */
public class MybatisPlusGenerator {

    @Test
    public void generateDO() {
        String dbname = "xxxx";
        //
        String path = this.getClass().getResource(".").getFile();
        path = path.substring(0, path.indexOf("/target")) + "/src/test/java";
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor(System.getProperty("user.name"))
                .setOutputDir(path)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setEntityName("%sDO");

        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL).setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://{yourdb}:3306/"+dbname+"?serverTimezone=UTC&useSSL=false")
                .setUsername("username")
                .setPassword("password");

        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true);

        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.rezix.generated").setEntity("entity");
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());
        ag.execute();
    }
}
