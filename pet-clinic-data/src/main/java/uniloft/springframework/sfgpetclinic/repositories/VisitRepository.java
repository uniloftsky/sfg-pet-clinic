package uniloft.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
