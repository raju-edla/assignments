package info.assignments.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.assignments.entity.AppUser;
import info.assignments.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<AppUser> getAllUserDetails() {
		return userRepository.findAll();
	}

	@Override
	public AppUser saveUser(AppUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setStatus("active");
		return userRepository.save(user);
	}

	@Override
	public AppUser updateUser(AppUser user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<AppUser> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public Optional<AppUser> getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public void inactiveUser(Long userId) {
		AppUser user = getUserById(userId).orElse(null);
		if (null != user) {
			user.setStatus("in_active");
			updateUser(user);
		}

	}

}
