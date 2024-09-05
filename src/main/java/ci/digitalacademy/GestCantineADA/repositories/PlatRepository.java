package ci.digitalacademy.GestCantineADA.repositories;

import ci.digitalacademy.GestCantineADA.models.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Long> {
    List<Plat> findByName(String plat);
}
