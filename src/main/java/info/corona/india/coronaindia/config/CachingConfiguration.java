package info.corona.india.coronaindia.config;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfiguration {
    public static final String CORONADATAHISTORYINDIA = "corona_data_history_india";
    public static final String CORONADATATOTALINDIA = "corona_data_total_india";
    public static final String CORONADATATOTALWORLD = "corona_data_total_world";

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(CORONADATAHISTORYINDIA, CORONADATATOTALINDIA, CORONADATATOTALWORLD);
        return cacheManager;
    }

    @Scheduled(fixedDelay = 20 * 60 * 1000 ,  initialDelay = 500)
    public void reportCacheEvict() {
        System.out.println("Flush Cache " + new Date());
    }
}