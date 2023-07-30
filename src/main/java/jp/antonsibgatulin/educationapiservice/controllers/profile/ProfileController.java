package jp.antonsibgatulin.educationapiservice.controllers.profile;

import jp.antonsibgatulin.educationapiservice.controllers.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/getById/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        return profileService.get(id);
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity getMyProfile(Authentication authentication){
        return profileService.getMyProfile(authentication);
    }


}
