package uniloft.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import uniloft.springframework.sfgpetclinic.model.Specialty;
import uniloft.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import uniloft.springframework.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtiesSDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtiesSDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specs = new HashSet<>();
        specialtyRepository.findAll().forEach(specs::add);
        return specs;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
