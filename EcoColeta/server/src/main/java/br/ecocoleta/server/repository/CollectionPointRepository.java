package br.ecocoleta.server.repository;

import br.ecocoleta.server.model.CollectionPoint;
import br.ecocoleta.server.model.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {

    @Query("select cp from CollectionPoint cp join cp.acceptedTypes t where (:type is null or t = :type)")
    List<CollectionPoint> findByType(@Param("type") WasteType type);
}
