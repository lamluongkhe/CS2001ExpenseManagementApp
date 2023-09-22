package com.hpn.pojo;

import com.hpn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(Chat.class)
public class Chat_ { 

    public static volatile SingularAttribute<Chat, Date> timeStamp;
    public static volatile SingularAttribute<Chat, Integer> id;
    public static volatile SingularAttribute<Chat, User> userId;
    public static volatile SingularAttribute<Chat, String> messageContent;

}