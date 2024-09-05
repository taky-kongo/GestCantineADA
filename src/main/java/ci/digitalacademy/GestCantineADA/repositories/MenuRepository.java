package ci.digitalacademy.GestCantineADA.repositories;

import ci.digitalacademy.GestCantineADA.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
