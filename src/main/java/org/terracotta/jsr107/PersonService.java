package org.terracotta.jsr107;

import static java.util.concurrent.TimeUnit.SECONDS;
import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author GGIB
 */

@Component
//JSR-107
//Class level annotation which allows you to share common settings on caching operations.
//In this case I am sharing the cache name
@CacheDefaults(cacheName = "people")
public class PersonService
{
    //create cache
    @Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
      @Override
      public void customize(CacheManager cacheManager)
      {
        cacheManager.createCache("people", new MutableConfiguration<>()
          .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 5)))
          .setStoreByValue(false)
          .setStatisticsEnabled(true));
      }
    }

    @CacheResult
    Person getPerson(int ssn)
    {
        switch (ssn)
        {
            case 123456789:
                return new Person(ssn, "Geoff", "Gibson");
            case 987654321:
                return new Person(ssn, "Cory", "Beck");
            default:
                return new Person(ssn,"John","Doe");
        }
    }


}
