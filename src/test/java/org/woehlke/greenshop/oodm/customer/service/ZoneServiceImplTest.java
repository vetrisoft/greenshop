package org.woehlke.greenshop.oodm.customer.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.customer.entities.Zone;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ZoneServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ZoneServiceImplTest.class);

    @Inject
    private ZoneService zoneService;

    @Test
    public void getZoneMapTest() throws Exception {
        logger.info("------------------------------------------------------");
        Map<Long, List<Zone>> zoneMap = zoneService.getZoneMap();
        logger.info("------------------------------------------------------");
        for(Long countryId:zoneMap.keySet()){
            logger.info("## CountryId: "+countryId+" ##");
            for(Zone zone: zoneMap.get(countryId)){
                logger.info("#### Zone: "+zone.toString());
                Assert.assertEquals(countryId, zone.getCountry().getId());
            }
        }
        logger.info("------------------------------------------------------");
    }
}
