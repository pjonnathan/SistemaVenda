package com.example.sistem.repositorys;

import com.example.sistem.models.entity.Movel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovelRespository extends JpaRepository<Movel, Long> {
}
