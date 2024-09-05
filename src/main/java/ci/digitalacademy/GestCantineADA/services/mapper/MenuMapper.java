package ci.digitalacademy.GestCantineADA.services.mapper;

import ci.digitalacademy.GestCantineADA.models.Menu;
import ci.digitalacademy.GestCantineADA.services.dto.MenuDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDTO, Menu>{
}
