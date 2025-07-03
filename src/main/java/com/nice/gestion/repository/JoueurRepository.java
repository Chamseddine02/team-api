package com.nice.gestion.repository;
import com.nice.gestion.entity.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JoueurRepository extends JpaRepository<JoueurEntity, Integer> {

}

