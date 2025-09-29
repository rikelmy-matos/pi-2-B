package br.ecocoleta.server.controller;

import br.ecocoleta.server.dto.CollectionPointDTO;
import br.ecocoleta.server.model.CollectionPoint;
import br.ecocoleta.server.model.WasteType;
import br.ecocoleta.server.service.CollectionPointService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CollectionPointService service;

    public ApiController(CollectionPointService service) {
        this.service = service;
    }

    @GetMapping("/types")
    public List<WasteType> types() {
        return Arrays.asList(WasteType.values());
    }

    @GetMapping("/points")
    public List<CollectionPoint> list(
            @RequestParam(required = false) WasteType type,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lng,
            @RequestParam(required = false) Double radiusKm
    ) {
        return service.list(type, lat, lng, radiusKm);
    }

    @GetMapping("/points/{id}")
    public ResponseEntity<CollectionPoint> get(@PathVariable Long id) {
        CollectionPoint cp = service.get(id);
        return (cp == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(cp);
    }

    @PostMapping("/points")
    public ResponseEntity<CollectionPoint> create(@Valid @RequestBody CollectionPointDTO dto) {
        CollectionPoint created = service.create(
                new CollectionPoint(dto.name, dto.address, dto.latitude, dto.longitude,
                        dto.acceptedTypes, dto.hours, dto.phone)
        );
        return ResponseEntity.created(URI.create("/api/points/" + created.getId())).body(created);
    }

    @PutMapping("/points/{id}")
    public ResponseEntity<CollectionPoint> update(@PathVariable Long id, @Valid @RequestBody CollectionPointDTO dto) {
        CollectionPoint updated = service.update(id,
                new CollectionPoint(dto.name, dto.address, dto.latitude, dto.longitude,
                        dto.acceptedTypes, dto.hours, dto.phone));
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/points/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
