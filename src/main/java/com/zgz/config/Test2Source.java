//package com.zgz.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.zgz.mapper.test2",sqlSessionTemplateRef = "test2sqlSessionTemplate")
//public class Test2Source {
//    @Bean(name = "test2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test2")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }
//
//    @Bean(name = "test2sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean(name = "test2dataSourceTransactionManager")
//    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test2sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = "test2sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
