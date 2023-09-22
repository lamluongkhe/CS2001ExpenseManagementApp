package com.hpn.pojo;

import com.hpn.pojo.Category;
import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-12T00:16:43")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Date> date;
    public static volatile SingularAttribute<Transaction, Integer> amount;
    public static volatile SetAttribute<Transaction, Grouptransaction> grouptransactionSet;
    public static volatile SingularAttribute<Transaction, String> description;
    public static volatile SingularAttribute<Transaction, Integer> id;
    public static volatile SingularAttribute<Transaction, String> type;
    public static volatile SingularAttribute<Transaction, String> title;
    public static volatile SingularAttribute<Transaction, User> userId;
    public static volatile SingularAttribute<Transaction, Category> categoryId;

}