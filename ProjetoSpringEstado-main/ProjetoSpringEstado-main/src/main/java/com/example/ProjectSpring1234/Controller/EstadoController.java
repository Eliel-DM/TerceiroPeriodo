package com.example.ProjectSpring1234.Controller;

import com.example.ProjectSpring1234.Entity.Estado;
import com.example.ProjectSpring1234.Service.EstadoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping (path = "/all", produces = "application/json")
    public ResponseEntity<List<Estado>> buscarTodos(){
        List<Estado> listEstado = estadoService.findTodos();
        return ResponseEntity.ok(listEstado);
    }
    @GetMapping (path="/{id}")
    public ResponseEntity<Estado> buscarPorID (@PathVariable Long id){
        Optional<Estado> response = estadoService.findById(id);
        if (response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping (path = "/all")
    public ResponseEntity<Estado> saveEstado(@RequestBody  Estado estado){
        Estado response = estadoService.creatEstado(estado);
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<Estado> updateEstado (@RequestBody Estado estado) {
        if (!estadoService.findById(estado.getId()).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoService.updateEstado(estado));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return estadoService.deleteById(id);
    }



}
