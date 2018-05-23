package com.isa.ticket.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.DeleteDTO;
import com.isa.ticket.controller.dto.GetSingleUserDTO;
import com.isa.ticket.controller.dto.GetUsersDTO;
import com.isa.ticket.controller.dto.LogInDTO;
import com.isa.ticket.controller.dto.RegistrationDTO;
import com.isa.ticket.controller.dto.ResponseDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.controller.dto.UserDTO;
import com.isa.ticket.domain.User;
import com.isa.ticket.security.TokenProvider;
import com.isa.ticket.security.UserDetailsServiceImpl;
import com.isa.ticket.service.MailService;
import com.isa.ticket.service.UserService;

@RestController
@RequestMapping("/user")
public class AccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	TokenProvider tokenProvider;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private MailService mailService;

	// @RequestMapping(value="signUp", method=RequestMethod.POST) isto kao ovo
	// ispod
	@PostMapping("/signUp")
	public ResponseMessageDTO signUp(@RequestBody RegistrationDTO registerDTO) throws MessagingException {
		User user = new User();
		user.setUsername(registerDTO.getUsername());
		user.setEmail(registerDTO.getEmail());
		user.setPassword(registerDTO.getPassword());
		
		user = userService.registration(user);
	//	mailService.sendActivationLinkMail(user);
		

		return new ResponseMessageDTO("localhost:8090/accountActivation?key="+user.getActivationLink());
	}

	@PostMapping("/logIn")
	public ResponseDTO logIn(@RequestBody LogInDTO logInDTO){
		UserDetails details = userDetailsServiceImpl.loadUserByUsername(logInDTO.getUsername());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				logInDTO.getUsername(), logInDTO.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(details);
		
		return new ResponseDTO(jwt, null);
	}
	
	@PostMapping("/deleteAccount")
	public ResponseMessageDTO deleteAccount(@RequestBody DeleteDTO deleteDTO){
		User user = userService.deleteAccount(deleteDTO.getEmail(), deleteDTO.getPassword());
		if(user == null){
			return new ResponseMessageDTO("Neuspesno brisanje");
		}
		return new ResponseMessageDTO("Uspesno ste obrisali nalog");
	}
	
	@PutMapping("/editUser")
	public ResponseMessageDTO editUser(@RequestBody RegistrationDTO registrationDTO){
		User user = userService.editUser(registrationDTO.getEmail(), registrationDTO.getPassword(), 
										registrationDTO.getUsername());
		if(user == null){
			return new ResponseMessageDTO("Neuspesna izmena podataka korisnika");
		}
		return new ResponseMessageDTO("Uspesno ste izmenili podatke korisnika");
	}
	
	
	@GetMapping("/userActivation")
	public ResponseDTO userActivation(@RequestParam("key") String key){
		User user = userService.userActivation(key);
		if( user == null){
			return new ResponseDTO ("Korisnik sa ovim linkom ne postoji");
		}
		return new ResponseDTO ("Uspesno");
	}
	
	@GetMapping("/getUsers")
	public GetUsersDTO getUsers(){
		List<User> tempList = userService.getAll();
		return new GetUsersDTO("Uspesno", tempList);
	}
	
	@GetMapping("/profile/{email}")
	public UserDTO getSelectedUser(@PathVariable("email") String email){
		User user = userService.getSelectedUser(email);
		return new UserDTO(user.getEmail(), user.getUsername());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accountActivation")
	public void activateAccount(@RequestParam(value = "key") String key){
		userService.activateAccount(key);
	}
	
	@GetMapping("/getSingleUser/{email}")
	public GetSingleUserDTO getSingleUser(@PathVariable("email") String email){
		User user = userService.getSelectedUser(email);
		System.out.println(user);
		return new GetSingleUserDTO(user);
	}
	
	
	
	
	
	
}
