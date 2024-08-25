package com.example.ProjectSpring1234.Service;
import java.util.List;
import com.example.ProjectSpring1234.Entity.Estado;
import com.example.ProjectSpring1234.Repository.EstadoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Data
@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findTodos(){
        return estadoRepository.findAll() ;
    }

    public Optional<Estado> findById (Long id){
        return estadoRepository.findById(id);
    }

    public Estado creatEstado(Estado estado){
        estado.setAtivo(true);
        return estadoRepository.save(estado);
    }

    public Estado updateEstado (Estado estado){
        return estadoRepository.save(estado);
    }
    public ResponseEntity<?> deleteById(Long id){
        Optional<Estado> response = findById(id);
        if (!response.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        response.get().setAtivo(false);
        return ResponseEntity.ok(estadoRepository.save(response.get()));

    }



}
