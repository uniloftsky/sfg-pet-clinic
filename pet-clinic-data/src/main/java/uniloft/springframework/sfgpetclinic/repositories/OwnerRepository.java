package uniloft.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
