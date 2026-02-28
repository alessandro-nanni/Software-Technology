package nl.utwente.soa.sampleWebapplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResult {
    private List<WeatherResult> list;

}