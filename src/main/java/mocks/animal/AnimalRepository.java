package mocks.animal;

import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findById(long id);

    Optional<Animal> findByType(String type);

    Animal add(AnimalDto animal);
}
