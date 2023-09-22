package com.hpn.pojo;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Grouptransaction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(Teamgroup.class)
public class Teamgroup_ { 

    public static volatile SetAttribute<Teamgroup, Grouptransaction> grouptransactionSet;
    public static volatile SingularAttribute<Teamgroup, String> name;
    public static volatile SetAttribute<Teamgroup, Groupmember> groupmemberSet;
    public static volatile SingularAttribute<Teamgroup, Integer> id;

}