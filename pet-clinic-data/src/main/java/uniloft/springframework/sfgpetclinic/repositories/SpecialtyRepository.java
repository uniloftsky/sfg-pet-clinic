package uniloft.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
