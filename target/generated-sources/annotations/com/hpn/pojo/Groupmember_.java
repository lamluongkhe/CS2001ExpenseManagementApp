package com.hpn.pojo;

import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(Groupmember.class)
public class Groupmember_ { 

    public static volatile SingularAttribute<Groupmember, Integer> id;
    public static volatile SingularAttribute<Groupmember, Teamgroup> teamgroupId;
    public static volatile SingularAttribute<Groupmember, String> roleingroup;
    public static volatile SingularAttribute<Groupmember, User> userId;

}