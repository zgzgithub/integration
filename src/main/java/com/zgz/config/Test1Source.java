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
//@MapperScan(basePackages = "com.zgz.mapper.test1",sqlSessionTemplateRef = "test1sqlSessionTemplate")
//public class Test1Source {
//    @Bean(name = "test1DataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.test1")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }
//    @Bean(name = "test1sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//    @Bean(name = "test1dataSourceTransactionManager")
//    @Primary
//    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("test1DataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "test1sqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = "test1sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
