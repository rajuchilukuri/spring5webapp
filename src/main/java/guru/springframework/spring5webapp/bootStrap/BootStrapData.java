package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Name;
import guru.springframework.spring5webapp.repositiries.AddressRepository;
import guru.springframework.spring5webapp.repositiries.NameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AddressRepository authorRepository;
    private final NameRepository nameRepository;

    public BootStrapData(AddressRepository authorRepository, NameRepository nameRepository) {
        this.authorRepository = authorRepository;
        this.nameRepository = nameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Name name= new Name("eric","nan");
        Address address=new Address("add","cit","st","fdfgd");
        name.getAddresses().add(address);
        address.getName().add(name);
        authorRepository.save(address);
        nameRepository.save(name);
        System.out.println(authorRepository.count());

    }
}
