//package com.agile;
//
//@Value("classpath:schema.sql")
//private Resource schemaScript;
// 
//@Bean
//public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//    DataSourceInitializer initializer = new DataSourceInitializer();
//    initializer.setDataSource(dataSource);
//    initializer.setDatabasePopulator(databasePopulator());
//    return initializer;
//}
// 
//private DatabasePopulator databasePopulator() {
//    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//    populator.addScript(schemaScript);
//    return populator;
//}
// 
//@Bean
//public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//    dataSource.setUrl(env.getProperty("jdbc.url"));
//    dataSource.setUsername(env.getProperty("jdbc.user"));
//    dataSource.setPassword(env.getProperty("jdbc.pass"));
//    return dataSource;
//}
