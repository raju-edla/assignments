package info.assignments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import info.assignments.entity.AppUser;

@Service
public interface UserService {
	
	public List<AppUser> getAllUserDetails();
	
	public AppUser saveUser(AppUser user);
	
	public AppUser updateUser(AppUser user);

	public Optional<AppUser> getUserById(Long userId);
	
	public Optional<AppUser> getUserByUserName(String userName);

	public void inactiveUser(Long userId);

}
