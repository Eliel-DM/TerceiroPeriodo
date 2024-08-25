package com.example.ProjectSpring1234.Repository;
import com.example.ProjectSpring1234.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {


}
