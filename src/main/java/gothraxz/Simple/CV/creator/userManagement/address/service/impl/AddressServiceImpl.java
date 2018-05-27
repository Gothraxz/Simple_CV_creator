package gothraxz.Simple.CV.creator.userManagement.address.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;
import gothraxz.Simple.CV.creator.userManagement.address.repository.AddressRepository;
import gothraxz.Simple.CV.creator.userManagement.address.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void save(Address address) {
		addressRepository.save(address);
	}

	@Override
	public Optional<Address> findById(long id) {
		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent()) {
			return address;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Collection<Address> findAll() {
		return addressRepository.findAll();
	}

}
