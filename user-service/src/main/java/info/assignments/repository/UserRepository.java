package info.assignments.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import info.assignments.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	public Optional<AppUser> findByUserName(String userName);

}
