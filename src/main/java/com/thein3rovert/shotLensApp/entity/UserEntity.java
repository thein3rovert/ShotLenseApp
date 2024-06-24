package com.thein3rovert.shotLensApp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(NON_DEFAULT)
public class UserEntity extends Auditable {
    @Column(updatable = false, unique = true, nullable = false)
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String lastLogin;
    private String loginAttempts;
    private String phone;

    //Photographer related fields
    private String bio;
    private String profileImageUrl;
    private String photographyTypes;

    // Athletes related fields
    private String sportTypes;

    //Not planning to implement but lets add these.
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id")
    )
    private UserRoleEntity roles;
}

