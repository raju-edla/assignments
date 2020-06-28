package info.assignments.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import info.assignments.entity.AppUser;
import info.assignments.logger.AppLogger;
import info.assignments.logger.AppLoggerFactory;
import info.assignments.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userService;

	private AppLogger logger = AppLoggerFactory.getLogger(UserResource.class);

	@GetMapping
	public ResponseEntity<List<AppUser>> getAllUsers() {
		logger.debug("REST request to get all Users");
		return ResponseEntity.ok().body(userService.getAllUserDetails());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AppUser> getUserDetailsById(@PathVariable Long id) {
		logger.debug("REST request to get User by Id : " + id);
		return userService.getUserById(id).map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/byUserName/{userName}")
	public ResponseEntity<AppUser> getUserDetailsByUserName(@PathVariable String userName) {
		logger.debug("REST request to get User by User Name : " + userName);
		return userService.getUserByUserName(userName).map(response -> ResponseEntity.ok().body(response))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<AppUser> saveUserDetails(@RequestBody AppUser user) throws Exception {
		logger.debug("REST request to save User : ", user);
		if (user.getUserId() != null) {
			throw new Exception("A new user cannot already have an ID");
		}
		AppUser result = userService.saveUser(user);
		return ResponseEntity.created(new URI("/api/registration/" + result.getUserId())).body(result);

	}

	@PutMapping
	public ResponseEntity<AppUser> updateBookDetails(@RequestBody AppUser user) throws Exception {
		logger.debug("REST request to update User :", user);
		if (user.getUserId() == null) {
			throw new Exception("Invlaid user id ");
		}
		AppUser result = userService.updateUser(user);
		return ResponseEntity.ok().body(result);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> inActiveUSer(@PathVariable Long id) {
		logger.debug("REST request to inActive User :", id);
		userService.inactiveUser(id);
		return ResponseEntity.noContent().build();
	}

	

}
