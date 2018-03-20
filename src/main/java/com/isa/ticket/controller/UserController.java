package com.isa.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.DeleteDTO;
import com.isa.ticket.controller.dto.LogInDTO;
import com.isa.ticket.controller.dto.RegistrationDTO;
import com.isa.ticket.controller.dto.ResponseDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.domain.User;
import com.isa.ticket.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// @RequestMapping(value="signUp", method=RequestMethod.POST) isto kao ovo
	// ispod
	@PostMapping("/signUp")
	public ResponseMessageDTO signUp(@RequestBody RegistrationDTO registerDTO) {
		User user = new User();
		user.setUsername(registerDTO.getUsername());
		user.setEmail(registerDTO.getEmail());
		user.setPassword(registerDTO.getPassword());

		user = userService.registration(user);

		return new ResponseMessageDTO("localhost:8090/userActivation?key="+user.getActivationLink());
	}

	@PostMapping("/logIn")
	public ResponseDTO logIn(@RequestBody LogInDTO logInDTO){
		User user = userService.checkIfExists(logInDTO.getUsername());
		if(user == null){
			return new ResponseDTO("Korisnik ne postoji");
		}
		
		if(!user.getPassword().equals(logInDTO.getPassword())){
			return new ResponseDTO("Neispravna lozinka");
		}
		
		if(!user.isActive()){
			return new ResponseDTO ("Niste aktivirali nalog");
		}
		
		return new ResponseDTO("Uspesno",user);
	}
	
	@PostMapping("/deleteAccount")
	public ResponseMessageDTO deleteAccount(@RequestBody DeleteDTO deleteDTO){
		User user = userService.deleteAccount(deleteDTO.getEmail(), deleteDTO.getPassword());
		if(user == null){
			return new ResponseMessageDTO("Neuspesno brisanje");
		}
		return new ResponseMessageDTO("Uspesno ste obrisali nalog");
	}
	
	
	@GetMapping("/userActivation")
	public ResponseDTO userActivation(@RequestParam("key") String key){
		User user = userService.userActivation(key);
		if( user == null){
			return new ResponseDTO ("Korisnik sa ovim linkom ne postoji");
		}
		return new ResponseDTO ("Uspesno");
	}
	
	
}
