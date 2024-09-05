package ci.digitalacademy.GestCantineADA.services.mapper;

import ci.digitalacademy.GestCantineADA.models.Plat;
import ci.digitalacademy.GestCantineADA.services.dto.PlatDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlatMapper extends EntityMapper<PlatDTO, Plat>{
}
