package info.corona.india.coronaindia.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import info.corona.india.coronaindia.config.CachingConfiguration;
import info.corona.india.coronaindia.dataobject.CoronaHistoricalDataDO;
import info.corona.india.coronaindia.dataobject.CoronaIndiaDataDO;
import info.corona.india.coronaindia.dataobject.CoronaWorldDataDO;

@Service
@CacheConfig(cacheManager = "cacheManager")
public class CoronaIndiaService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${coronaapi-path}")
    private String coronaApiEndpoint;

    @Cacheable(cacheManager = "cacheManager", cacheNames = CachingConfiguration.CORONADATAHISTORYINDIA)
    public Optional<CoronaHistoricalDataDO> getAllHistoricalDataforIndia(){
        String endPointUrl = coronaApiEndpoint + "historical";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        List<CoronaHistoricalDataDO> dataList =Arrays.asList(restTemplate.exchange(endPointUrl, HttpMethod.GET, entity, CoronaHistoricalDataDO[].class).getBody());
        Stream<CoronaHistoricalDataDO> indiaData = dataList.stream().filter(data->data != null && data.getCountry().equals("India"));
        return indiaData.findFirst();
    }

    @Cacheable(cacheManager = "cacheManager", cacheNames = CachingConfiguration.CORONADATATOTALINDIA)
    public CoronaIndiaDataDO getIndiaTotalData() {
        String endPointUrl = coronaApiEndpoint + "countries/india";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.exchange(endPointUrl, HttpMethod.GET, entity, CoronaIndiaDataDO.class).getBody();
    }

    @Cacheable(cacheManager = "cacheManager", cacheNames = CachingConfiguration.CORONADATATOTALWORLD)
    public CoronaWorldDataDO getWorldTotalData() {
        String endPointUrl = coronaApiEndpoint + "all";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.exchange(endPointUrl, HttpMethod.GET, entity, CoronaWorldDataDO.class).getBody();
    }
}