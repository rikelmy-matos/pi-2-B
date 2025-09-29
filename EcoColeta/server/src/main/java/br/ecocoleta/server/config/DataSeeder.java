package br.ecocoleta.server.config;

import br.ecocoleta.server.model.CollectionPoint;
import br.ecocoleta.server.model.WasteType;
import br.ecocoleta.server.repository.CollectionPointRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Set;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seed(CollectionPointRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new CollectionPoint(
                        "Eco Ponto Centro",
                        "Av. Principal, 123 - Centro",
                        -23.5505, -46.6333,
                        Set.of(WasteType.PAPER, WasteType.PLASTIC, WasteType.METAL, WasteType.GLASS),
                        "Seg-Sex 08:00-18:00",
                        "(11) 1111-1111"
                ));
                repo.save(new CollectionPoint(
                        "Coleta Verde Norte",
                        "Rua das Flores, 45 - Norte",
                        -23.5200, -46.6200,
                        Set.of(WasteType.ELECTRONIC, WasteType.BATTERY),
                        "Sáb 09:00-16:00",
                        "(11) 2222-2222"
                ));
                repo.save(new CollectionPoint(
                        "Ponto Óleo Amigo",
                        "Rua do Lago, 789 - Sul",
                        -23.6000, -46.6500,
                        Set.of(WasteType.OIL),
                        "Seg-Sex 09:00-17:00",
                        "(11) 3333-3333"
                ));
                repo.save(new CollectionPoint(
                        "Recicla Tudo Vila Madalena",
                        "Rua Harmonia, 456 - Vila Madalena",
                        -23.5440, -46.6920,
                        Set.of(WasteType.PAPER, WasteType.PLASTIC, WasteType.GLASS, WasteType.METAL, WasteType.ORGANIC),
                        "Seg-Dom 06:00-22:00",
                        "(11) 4444-4444"
                ));
                repo.save(new CollectionPoint(
                        "Ponto Eletrônicos Itaim",
                        "Av. Faria Lima, 2000 - Itaim Bibi",
                        -23.5730, -46.6890,
                        Set.of(WasteType.ELECTRONIC, WasteType.BATTERY),
                        "Seg-Sex 10:00-19:00",
                        "(11) 5555-5555"
                ));
            }
        };
    }
}
