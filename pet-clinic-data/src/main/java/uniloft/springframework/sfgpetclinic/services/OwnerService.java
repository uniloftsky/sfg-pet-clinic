package uniloft.springframework.sfgpetclinic.services;

import uniloft.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
