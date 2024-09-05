package ci.digitalacademy.GestCantineADA.services.impl;

import ci.digitalacademy.GestCantineADA.models.Menu;
import ci.digitalacademy.GestCantineADA.repositories.MenuRepository;
import ci.digitalacademy.GestCantineADA.services.MenuService;
import ci.digitalacademy.GestCantineADA.services.dto.MenuDTO;
import ci.digitalacademy.GestCantineADA.services.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public MenuDTO save(MenuDTO menuDTO) {
        log.debug("Request to save Menu : {}", menuDTO);
        Menu menu = menuMapper.toEntity(menuDTO);
        menu = menuRepository.save(menu);
        return menuMapper.toDto(menu);
    }

    @Override
    public MenuDTO update(MenuDTO menuDTO) {
        log.debug("Request to update Menu : {}", menuDTO);
        return findOne(menuDTO.getId()).map(menu -> {
            menu.setCreationDate(menuDTO.getCreationDate());
            menu.setPlatDTO(menuDTO.getPlatDTO());
            return save(menu);
        }).orElseThrow(() -> new IllegalArgumentException("Menu not found"));
    }

    @Override
    public Optional<MenuDTO> findOne(Long id) {
        log.debug("Request to get Menu : {}", id);
        return menuRepository.findById(id).map(plat -> {
            return menuMapper.toDto(plat);
        });
    }

    @Override
    public List<MenuDTO> findAll() {
        log.debug("Request to get all Menu");
        return menuRepository.findAll().stream().map(plat -> {
            return menuMapper.toDto(plat);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Menu : {}", id);
        menuRepository.deleteById(id);
    }
}
