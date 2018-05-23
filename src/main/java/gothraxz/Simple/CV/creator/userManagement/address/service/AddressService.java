package gothraxz.Simple.CV.creator.userManagement.address.service;

import java.util.Collection;
import java.util.Optional;

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;

public interface AddressService {

	void save(Address address);

	Optional<Address> findById(long id);
	
	void deleteById(long id);

	Collection<Address> findAll();

}
