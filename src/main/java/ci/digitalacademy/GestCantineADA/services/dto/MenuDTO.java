package ci.digitalacademy.GestCantineADA.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MenuDTO {

    private Long id;

    private Instant creationDate;

    private PlatDTO platDTO;
}
