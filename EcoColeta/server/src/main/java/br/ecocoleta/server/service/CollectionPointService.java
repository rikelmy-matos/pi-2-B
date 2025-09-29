package br.ecocoleta.server.service;

import br.ecocoleta.server.model.CollectionPoint;
import br.ecocoleta.server.model.WasteType;
import br.ecocoleta.server.repository.CollectionPointRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionPointService {

    private final CollectionPointRepository repo;

    public CollectionPointService(CollectionPointRepository repo) {
        this.repo = repo;
    }

    public List<CollectionPoint> list(WasteType type, Double lat, Double lng, Double radiusKm) {
        List<CollectionPoint> base = (type == null) ? repo.findAll() : repo.findByType(type);
        if (lat == null || lng == null || radiusKm == null) return base;

        List<CollectionPoint> filtered = new ArrayList<>();
        for (CollectionPoint cp : base) {
            double d = haversine(lat, lng, cp.getLatitude(), cp.getLongitude());
            if (d <= radiusKm) filtered.add(cp);
        }
        return filtered;
    }

    public CollectionPoint create(CollectionPoint cp) { return repo.save(cp); }
    public CollectionPoint get(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }

    public CollectionPoint update(Long id, CollectionPoint updated) {
        return repo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setAddress(updated.getAddress());
            existing.setLatitude(updated.getLatitude());
            existing.setLongitude(updated.getLongitude());
            existing.setAcceptedTypes(updated.getAcceptedTypes());
            existing.setHours(updated.getHours());
            existing.setPhone(updated.getPhone());
            return repo.save(existing);
        }).orElse(null);
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2)*Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
