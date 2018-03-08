package cn.shan.saw.auth.config;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.parser.ISqlParser;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantHandler;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantSqlParser;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by shanlehong on 2018/2/7.
 */
@Configuration
public class MybatisPlusConfig {
    private static final Log log = LogFactory.getLog(MybatisPlusConfig.class);
    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId() {
                return new LongValue(1L);
            }

            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                // 这里可以判断是否过滤表
                /*
                if ("user".equals(tableName)) {
                    return true;
                }*/
                return false;
            }
        });


        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        // 以下过滤方式与 @SqlParser(filter = true) 注解等效
//        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
//            @Override
//            public boolean doFilter(MetaObject metaObject) {
//                MappedStatement ms = PluginUtils.getMappedStatement(metaObject);
//                // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
//                if ("com.baomidou.springboot.mapper.UserMapper.selectListBySQL".equals(ms.getId())) {
//                    return true;
//                }
//                return false;
//            }
//        });
        return paginationInterceptor;
    }

    @Bean(name = "globalConfig")
    public GlobalConfiguration globalConfig(
            @Value("${mybatisPlus.globalConfig.idType}") Integer idType, //主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
            @Value("${mybatisPlus.globalConfig.fieldStrategy}") Integer fieldStrategy, //字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
            @Value("${mybatisPlus.globalConfig.dbColumnUnderline}") Boolean dbColumnUnderline, //驼峰下划线转换
            @Value("${mybatisPlus.globalConfig.isRefresh}") Boolean isRefresh, //刷新mapper 调试神器
            @Value("${mybatisPlus.globalConfig.isCapitalMode}") Boolean isCapitalMode, //数据库大写下划线转换
            @Value("${mybatisPlus.globalConfig.logicDeleteValue}") String logicDeleteValue, //逻辑删除配置
            @Value("${mybatisPlus.globalConfig.logicNotDeleteValue}") String logicNotDeleteValue //逻辑删除配置
    ) {
        log.info("初始化GlobalConfiguration");
        GlobalConfiguration globalConfig = new GlobalConfiguration();
        if ( idType!=null) {
            globalConfig.setIdType(idType);  //主键类型
        }

        if ( dbColumnUnderline!=null) {
            globalConfig.setDbColumnUnderline(dbColumnUnderline);  //驼峰下划线转换
        }
        if ( isRefresh!=null) {
            //        globalConfig.setRefresh(isRefresh); //刷新mapper 调试神器
        }
        if ( isCapitalMode!=null) {
            globalConfig.setCapitalMode(isCapitalMode); //数据库大写下划线转换
        }
        if ( logicDeleteValue!=null) {
            //        globalConfig.setLogicDeleteValue(logicDeleteValue);  //逻辑删除配置
        }
        if ( logicNotDeleteValue!=null) {
            //        globalConfig.setLogicNotDeleteValue(logicNotDeleteValue);  //逻辑删除配置
        }
        return globalConfig;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "globalConfig")GlobalConfiguration globalConfig,
                                               @Qualifier(value = "basisDataSource")DruidDataSource  dataSource) throws Exception {
        log.info("初始化SqlSessionFactory");
        String mapperLocations = "classpath:/sqlmap/*.xml";
        String typeAliasesPackage = "cn.shan.saw.model.entity";
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource); //数据源
        sqlSessionFactory.setGlobalConfig(globalConfig); //全局配置
        Interceptor[] interceptor = {new PaginationInterceptor()};
        sqlSessionFactory.setPlugins(interceptor); //分页插件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //自动扫描Mapping.xml文件
            sqlSessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
            sqlSessionFactory.setTypeAliasesPackage(typeAliasesPackage);
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //    MyBatis 动态扫描
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        log.info("初始化MapperScannerConfigurer");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        String basePackage = "cn.shan.saw.auth.mapper";
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }

    //    配置事务管理
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier(value = "basisDataSource")DruidDataSource dataSource) {
        log.info("初始化DataSourceTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

}
