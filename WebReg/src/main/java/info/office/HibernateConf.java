package info.office;




public class HibernateConf {

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan("info.office.entity");
//		sessionFactory.setHibernateProperties(hibernateProperties());
//
//		return sessionFactory;
//	}
//
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/web_registration?useSSL=false");
//		dataSource.setUsername("register");
//		dataSource.setPassword("register");
//
//		return dataSource;
//	}
//
//	private final Properties hibernateProperties() {
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		hibernateProperties.setProperty("hibernate.show_sql", "true");
//
//		return hibernateProperties;
//	}
//	
//	@Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//          = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }

}
