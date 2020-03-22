package info.corona.india.coronaindia.dataobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoronaHistoricalDataDO {

    @JsonProperty("country")
    String country;
    @JsonProperty("province")
    String province;
    @JsonProperty("timeline")
    TimeLineDO timeline;
  

}