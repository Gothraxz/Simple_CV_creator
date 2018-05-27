package gothraxz.Simple.CV.creator.userManagement.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gothraxz.Simple.CV.creator.userManagement.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
