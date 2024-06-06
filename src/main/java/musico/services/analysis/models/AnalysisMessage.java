package musico.services.analysis.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AnalysisMessage {
    private Integer beats;
    private Float danceability;
}
