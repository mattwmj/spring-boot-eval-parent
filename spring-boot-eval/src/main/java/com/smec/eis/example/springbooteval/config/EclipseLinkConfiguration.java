package com.smec.eis.example.springbooteval.config;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableTransactionManagement
@EnableLoadTimeWeaving
@Configuration
public class EclipseLinkConfiguration extends JpaBaseConfiguration implements LoadTimeWeavingConfigurer {

    protected EclipseLinkConfiguration(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManager, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        return adapter;
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        final Map<String, Object> vendorProperties = new HashMap<>();
        vendorProperties.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
        vendorProperties.put(PersistenceUnitProperties.LOGGING_LOGGER, "DefaultLogger");
        vendorProperties.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");
        vendorProperties.put(PersistenceUnitProperties.LOGGING_PARAMETERS, "true");
        vendorProperties.put("eclipselink.logging.level.sql", "FINEST");
        vendorProperties.put("eclipselink.logging.exceptions", "true");
        return vendorProperties;
    }

    @Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        return new ReflectiveLoadTimeWeaver();
    }

    @Bean
    public InstrumentationLoadTimeWeaver loadTimeWeaver() throws Throwable {
        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        return loadTimeWeaver;
    }

}
