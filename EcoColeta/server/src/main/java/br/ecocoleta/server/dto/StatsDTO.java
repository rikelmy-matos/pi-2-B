package br.ecocoleta.server.dto;

import br.ecocoleta.server.model.WasteType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

@Schema(description = "Estatísticas do sistema")
public class StatsDTO {
    @Schema(description = "Total de pontos cadastrados")
    public long totalPoints;
    
    @Schema(description = "Quantidade de pontos por tipo de resíduo")
    public Map<WasteType, Long> pointsByType;
    
    public StatsDTO(long totalPoints, Map<WasteType, Long> pointsByType) {
        this.totalPoints = totalPoints;
        this.pointsByType = pointsByType;
    }
}