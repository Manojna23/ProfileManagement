package org.profile.service;

import org.profile.model.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileManagementService {

    List<Profile> allProfiles = new ArrayList<>();

    public List<Profile> getAllProfiles() {
        return this.allProfiles;
        // Arrays.asList(new Profile("manojna", "vijay",new BigDecimal(100), 27, "Manager"),new Profile("rasika", "vijayk",new BigDecimal(200), 32, "Senior Manager"));
    }

    public String addProfile(Profile p1) {
        allProfiles.add(p1);
        return "Profile added!";
    }

    public String updateProfile(int profileId, String designation) {
        Profile p = allProfiles.stream().filter((profile -> profileId == profile.getProfileId())).findAny().get();
        p.setDesignation(designation);
        return "Profile with the id: updated!"+profileId;
    }

    public void deleteProfile(int profileId) {
        allProfiles.remove(allProfiles.get(profileId));
    }
}
