package com.medicalvault.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_users")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseDao {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_name")
  private String username;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "password")
  private String password;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "email_id")
  private String emailId;

  @Column(name = "authorities")
  private String authorities;

  @Column(name = "created_at")
  private Date createdDate;
}
