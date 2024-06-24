package com.thein3rovert.shotLensApp.enumeration;

import static com.thein3rovert.shotLensApp.constant.Constants.*;

public enum UserAuthority {
    PHOTOGRAPHER(PHOTOGRAPHER_AUTHORITY),
    ATHLETE(ATHLETE_AUTHORITY),
    ADMIN(ADMIN_AUTHORITY);

    private final String authorityValue;

    UserAuthority(String authorityValue) {
        this.authorityValue = authorityValue;
    }


    public String getAuthorityValue() {
        return this.authorityValue;
    }

}
