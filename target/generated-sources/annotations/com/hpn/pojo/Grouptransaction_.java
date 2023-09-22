package com.hpn.pojo;

import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.Transaction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(Grouptransaction.class)
public class Grouptransaction_ { 

    public static volatile SingularAttribute<Grouptransaction, Integer> id;
    public static volatile SingularAttribute<Grouptransaction, Teamgroup> teamgroupId;
    public static volatile SingularAttribute<Grouptransaction, Transaction> transactionId;

}