package com.fnb.exchangerates;

import com.fnb.exchangerates.domain.CurrencyRate;
import com.fnb.exchangerates.repository.CurrencyRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitH2Database {

    private static final Logger log  = LoggerFactory.getLogger(InitH2Database.class);

    @Bean
    CommandLineRunner initDatabase(CurrencyRateRepository repository){
        return args -> {
            log.info("Preloading " + repository.save( new CurrencyRate("GBP", new Double("84.850"), new Double("86.540"))));
            log.info("Preloading " + repository.save( new CurrencyRate("EUR", new Double("72.570"), new Double("74.010"))));
            log.info("Preloading " + repository.save( new CurrencyRate("USD", new Double("63.200"), new Double("64.460"))));
            log.info("Preloading " + repository.save( new CurrencyRate("ZAR", new Double("4.100"), new Double("4.180"))));
        };
    }

}
