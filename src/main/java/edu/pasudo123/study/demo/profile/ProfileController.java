package edu.pasudo123.study.demo.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("{profileId}")
    public ResponseEntity<ProfileDto.Response> findById(@PathVariable("profileId") final Long profileId) {
        return ResponseEntity.ok().body(profileService.findById(profileId));
    }
}
