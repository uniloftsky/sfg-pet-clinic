package uniloft.springframework.sfgpetclinic.services;

import uniloft.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameIsLike(String lastName);

}
