package uniloft.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
