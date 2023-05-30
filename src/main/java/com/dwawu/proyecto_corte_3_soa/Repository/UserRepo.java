package com.dwawu.proyecto_corte_3_soa.Repository;

import com.dwawu.proyecto_corte_3_soa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
