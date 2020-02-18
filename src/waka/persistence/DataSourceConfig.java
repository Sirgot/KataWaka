package waka.persistence;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//https://springframework.guru/configuring-spring-boot-for-microsoft-sql-server/

@Configuration
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    /**
     * Special for Ms sqlserver
     * @return
     */
    @Profile("dev")
    @Bean
    public SQLServerDataSource getDataSourceMs () {
        SQLServerDataSource  dataSourceBuilder= new SQLServerDataSource();
//        BasicDataSource  dataSourceBuilder= BasicDataSource .create();
        try {
            dataSourceBuilder.setDescription("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSourceBuilder.setURL("jdbc:sqlserver://localhost:1433/databaseName=KataBase");
            dataSourceBuilder.setUser("KataUser");
            dataSourceBuilder.setPassword("K4T4Us3r");
            dataSourceBuilder.setPortNumber(1433);
        } catch (Exception e) {
            logger.error("Spring waka Exception ms : "+ String.valueOf(e.getStackTrace()));
        } finally {
            return dataSourceBuilder;
        }
    }

//    @Bean
//    public DataSource getDataSource () {
//        DataSourceBuilder dataSourceBuilder= DataSourceBuilder.create();
////        BasicDataSource  dataSourceBuilder= BasicDataSource .create();
//        try {
//            dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            dataSourceBuilder.url("jdbc:sqlserver://localhost:1433/databaseName=KataBase");
//            dataSourceBuilder.username("KataUser");
//            dataSourceBuilder.password("K4T4Us3r");
//            dataSourceBuilder.build();
//        } catch (Exception e) {
//            logger.error("Spring waka Exception : "+ String.valueOf(e.getStackTrace()));
//        } finally {
//            return dataSourceBuilder.build();
//        }
//    }
}