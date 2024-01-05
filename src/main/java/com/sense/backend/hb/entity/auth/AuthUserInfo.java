package com.sense.backend.hb.entity.auth;

import com.sense.backend.hb.entity.common.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "AUTH_USER_INFO")
public class AuthUserInfo implements Serializable {

    private static final long serialVersionUID = 4082030846151949291L;

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_SURNAME")
    private String userSurname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;

    @Column(name = "UPDATE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDt;

}
