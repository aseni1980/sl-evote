package com.aseni.slevote.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractModel<Long extends Serializable> implements Serializable {

    private static final long serialVersionUID = -6323358535657100144L;

}
