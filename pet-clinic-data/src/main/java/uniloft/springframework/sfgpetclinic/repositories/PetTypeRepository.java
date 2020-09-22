package uniloft.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
