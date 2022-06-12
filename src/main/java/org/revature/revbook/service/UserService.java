package org.revature.revbook.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserService {
    @Id
    @GeneratedValue
    private Long user_id;
    private String user_name;
    private String user_email;





}
