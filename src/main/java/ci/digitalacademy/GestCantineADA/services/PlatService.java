package ci.digitalacademy.GestCantineADA.services;

import ci.digitalacademy.GestCantineADA.services.dto.PlatDTO;

import java.util.List;
import java.util.Optional;

public interface PlatService {

    PlatDTO save(PlatDTO platDTO);

    PlatDTO update(PlatDTO platDTO);

    Optional<PlatDTO> findOne(Long id);

    List<PlatDTO> findAll();

    void delete(Long id);

    List<PlatDTO> findByName(String name);
}
