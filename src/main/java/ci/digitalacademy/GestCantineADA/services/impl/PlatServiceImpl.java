package ci.digitalacademy.GestCantineADA.services.impl;

import ci.digitalacademy.GestCantineADA.models.Plat;
import ci.digitalacademy.GestCantineADA.repositories.PlatRepository;
import ci.digitalacademy.GestCantineADA.services.PlatService;
import ci.digitalacademy.GestCantineADA.services.dto.PlatDTO;
import ci.digitalacademy.GestCantineADA.services.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;
    private final PlatMapper platMapper;

    @Override
    public PlatDTO save(PlatDTO platDTO) {
        log.debug("Request to save Plat : {}", platDTO);
        Plat plat = platMapper.toEntity(platDTO);
        plat = platRepository.save(plat);
        return platMapper.toDto(plat);
    }

    @Override
    public PlatDTO update(PlatDTO platDTO) {
        log.debug("Request to update Plat : {}", platDTO);
        return findOne(platDTO.getId()).map(plat -> {
            plat.setName(platDTO.getName());
            plat.setSummary(platDTO.getSummary());
            return save(plat);
        }).orElseThrow(() -> new IllegalArgumentException("Plat not found!"));
    }

    @Override
    public Optional<PlatDTO> findOne(Long id) {
        log.debug("Request to get Plat : {}", id);
        return platRepository.findById(id).map(plat -> {
            return platMapper.toDto(plat);
        });
    }

    @Override
    public List<PlatDTO> findAll() {
        log.debug("Request to get all Plats");
        return platRepository.findAll().stream().map(plat -> {
            return platMapper.toDto(plat);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Plat : {}", id);
        platRepository.deleteById(id);
    }

    @Override
    public List<PlatDTO> findByName(String name) {
        log.debug("Request to get Plats by name : {}", name);
        return platRepository.findByName(name).stream().map(plat -> {
            return platMapper.toDto(plat);
        }).toList();
    }
}
