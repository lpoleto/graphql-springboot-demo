package com.graphqldemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Customer> findAll();
}
