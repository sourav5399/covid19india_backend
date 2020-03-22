package info.corona.india.coronaindia.dataobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoronaWorldDataDO {
    @JsonProperty("cases")
    Long cases;
    @JsonProperty("deaths")
    Long deaths;
    @JsonProperty("recovered")
    Long recovered;
    @JsonProperty("updated")
    Long updated;
}