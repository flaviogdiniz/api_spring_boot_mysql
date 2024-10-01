package br.com.projeto.api.controle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Aluno;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;


@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;
    
    

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Aluno obj){
        
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }


    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    @GetMapping("/api/contador")
    public ResponseEntity<?> contador(){
        return servico.contador();
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Aluno obj){
        
        return servico.editar(obj);
    }

    @DeleteMapping("api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
    }

    

    @GetMapping("api/ordenarNomes")
    public ResponseEntity<?> ordenarNomes(){
        return servico.ordenarNomes();
    }

    @GetMapping("/api/nomeContem/{termo}")
    public ResponseEntity<?>nomeContem(@PathVariable String termo){
        return servico.nomeContem(termo);
    }
    
    @GetMapping("/api/iniciaCom/{termo}")
    public ResponseEntity<?> iniciaCom(@PathVariable String termo){
        return servico.iniciaCom(termo);
    }

    @GetMapping("/api/terminaCom/{termo}")
    public ResponseEntity<?> terminaCom(@PathVariable String termo){
        return servico.terminaCom(termo);
    }

    @GetMapping("api/somaMedias")
    public ResponseEntity<?> somaMedias(){
        return servico.somaMedias();
    }

    @GetMapping("api/mediaMaiorIgual/{nota}")
    public ResponseEntity<?> mediaMaiorIgual(@PathVariable double nota){
        return servico.mediaMaiorIgual(nota);
    }

    
}
