package br.com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.modelo.Aluno;
import br.com.projeto.api.modelo.Mensagem;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> cadastrar(Aluno obj) {
        if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getNota1() < 0) {
            mensagem.setMensagem("Informe uma nota válida para a primeira nota");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getNota2() < 0) {
            mensagem.setMensagem("Informe uma nota válida para a segunda nota");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            obj.calcularMedia(); 
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }



    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selecionarPeloCodigo(int codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum aluno");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }

    }

    public ResponseEntity<?> contador(){
        return new ResponseEntity<>(acao.count(), HttpStatus.OK);
    }





    public ResponseEntity<?> editar(Aluno obj){
        if(acao.countByCodigo(obj.getCodigo()) == 0 ){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (obj.getNota1() < 0) {
            mensagem.setMensagem("Informe uma nota válida para a primeira nota");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getNota2() < 0) {
            mensagem.setMensagem("Informe uma nota válida para a segunda nota");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            obj.calcularMedia(); 
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> remover(int codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            Aluno obj = acao.findByCodigo(codigo);
            acao.delete(obj);

            mensagem.setMensagem("Pessoa removida com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<?>ordenarNomes(){
        return new ResponseEntity<>(acao.findByOrderByNome(), HttpStatus.OK);
    }

    public ResponseEntity<?>nomeContem(String termo){
        return new ResponseEntity<>(acao.findByNomeContaining(termo), HttpStatus.OK);
    }

    public ResponseEntity<?>iniciaCom(String termo){
        return new ResponseEntity<>(acao.findByNomeStartsWith(termo),HttpStatus.OK);
    }

    public ResponseEntity<?>terminaCom(String termo){
        return new ResponseEntity<>(acao.findByNomeEndsWith(termo),HttpStatus.OK);
    }

    public ResponseEntity<?>somaMedias(){
        return new ResponseEntity<>(acao.somaMedias(),HttpStatus.OK);
    }

    public ResponseEntity<?>mediaMaiorIgual(double nota){
        return new ResponseEntity<>(acao.mediaMaiorIgual(nota),HttpStatus.OK);
    }
}
