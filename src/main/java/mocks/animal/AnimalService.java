package mocks.animal;

public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getById(long id) {
        return animalRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal does not exist"));
    }

    public Animal getByType(String type) {
        return animalRepository
                .findByType(type)
                .orElseThrow(() -> new IllegalArgumentException("Animal does not exist"));
    }

    public Animal create(String name, String type) {
        AnimalDto animalDto = new AnimalDto(name, type);
        return animalRepository.add(animalDto);
    }
}
