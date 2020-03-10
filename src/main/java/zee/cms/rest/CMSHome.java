package zee.cms.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CMSHome {

	@GetMapping("/")
	public String homePage() { return "Welcome to College Management System...!"; }

}
