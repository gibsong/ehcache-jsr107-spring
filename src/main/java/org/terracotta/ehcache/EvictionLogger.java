package org.terracotta.ehcache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvictionLogger implements CacheEventListener<Object, Object> {

  private static final Logger LOGGER = LoggerFactory.getLogger(EvictionLogger.class);

  @Override
  public void onEvent(CacheEvent<Object, Object> event) {
    LOGGER.info(event.getType() + " " + event.getKey());
  }

}
