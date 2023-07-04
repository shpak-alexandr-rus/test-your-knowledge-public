/**
 * ToDo: Добавить коментарий
 */
package com.shpakalexandr.tykapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "account_description")
    private String accountDescription;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "organization_id")
    private UUID organizationId;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "account_enabled")
    private boolean accountEnabled;

    @Column(name = "account_activated")
    private boolean accountActivated;

    @Column(name = "account_logo")
    private String accountLogo;

    @Column(name = "account_expiration_date")
    private Date accountExpirationDate;

    @Column(name = "account_credentials_expiration_date")
    private Date accountCredentialsExpirationDate;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
