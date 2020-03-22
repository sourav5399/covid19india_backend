package info.corona.india.coronaindia.dataobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeLineDO {

    @JsonProperty("cases")
    Object cases;
    @JsonProperty("deaths")
    Object deaths;
    @JsonProperty("recovered")
    Object recovered;

}