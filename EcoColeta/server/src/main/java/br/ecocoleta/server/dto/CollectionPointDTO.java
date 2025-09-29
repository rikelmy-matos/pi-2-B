package br.ecocoleta.server.dto;

import br.ecocoleta.server.model.WasteType;
import jakarta.validation.constraints.*;
import java.util.Set;

public class CollectionPointDTO {
    @NotBlank
    public String name;

    @NotBlank
    public String address;

    @NotNull
    public Double latitude;

    @NotNull
    public Double longitude;

    @NotEmpty
    public Set<WasteType> acceptedTypes;

    public String hours;
    public String phone;
}
