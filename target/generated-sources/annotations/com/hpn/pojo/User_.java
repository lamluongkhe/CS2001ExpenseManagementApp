package com.hpn.pojo;

import com.hpn.pojo.Chat;
import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Notifications;
import com.hpn.pojo.Transaction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SetAttribute<User, Notifications> notificationsSet;
    public static volatile SetAttribute<User, Chat> chatSet;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SetAttribute<User, Groupmember> groupmemberSet;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SetAttribute<User, Transaction> transactionSet;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}