package info.corona.india.coronaindia.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoronaIndiaDataDO {
    @JsonIgnore
    String country;
    @JsonProperty("cases")
    Long cases;
    @JsonProperty("todayCases")
    Long todayCases;
    @JsonProperty("deaths")
    Long deaths;
    @JsonProperty("todayDeaths")
    Long todayDeaths;
    @JsonProperty("recovered")
    Long recovered;
    @JsonProperty("active")
    Long active;
    @JsonProperty("critical")
    Long critical;
    @JsonProperty("casesPerOneMillion")
    Long casesPerOneMillion;
}