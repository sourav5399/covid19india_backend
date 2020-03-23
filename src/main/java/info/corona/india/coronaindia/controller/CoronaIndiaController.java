package info.corona.india.coronaindia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.corona.india.coronaindia.config.CachingConfiguration;
import info.corona.india.coronaindia.dataobject.CoronaHistoricalDataDO;
import info.corona.india.coronaindia.dataobject.CoronaIndiaDataDO;
import info.corona.india.coronaindia.dataobject.CoronaWorldDataDO;
import info.corona.india.coronaindia.service.CoronaIndiaService;

@RestController
public class CoronaIndiaController {

    @Autowired
    private CoronaIndiaService service;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/getIndiaHistoricData")
    public @ResponseBody CoronaHistoricalDataDO getIndiaHistoricData(){
        return service.getAllHistoricalDataforIndia().orElse(new CoronaHistoricalDataDO());
    }

    @GetMapping("/refreshIndiaHistoricData")
    public @ResponseBody CoronaHistoricalDataDO refreshIndiaHistoricData(){
        cacheManager.getCache(CachingConfiguration.CORONADATAHISTORYINDIA).clear();
        return getIndiaHistoricData();
    }

    @GetMapping("/getIndiaTotalData")
    public @ResponseBody CoronaIndiaDataDO getIndiaTotalData() {
        return service.getIndiaTotalData();
    }

    @GetMapping("/refreshIndiaTotalData")
    public @ResponseBody CoronaIndiaDataDO refreshIndiaTotalData(){
        cacheManager.getCache(CachingConfiguration.CORONADATATOTALINDIA).clear();
        return getIndiaTotalData();
    }

    @GetMapping("/getWorldTotalData")
    public @ResponseBody CoronaWorldDataDO getWorldTotalData(){
        return service.getWorldTotalData();
    }

    @GetMapping("/refreshWorldTotalData")
    public @ResponseBody CoronaWorldDataDO refreshWorldTotalData(){
        cacheManager.getCache(CachingConfiguration.CORONADATATOTALWORLD).clear();
        return getWorldTotalData();
    }
}