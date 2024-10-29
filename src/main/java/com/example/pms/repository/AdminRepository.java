package com.example.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pms.entity.Admin;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, String>{



}
