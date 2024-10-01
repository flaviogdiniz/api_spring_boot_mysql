package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Aluno;

@Repository
public interface Repositorio extends CrudRepository<Aluno, Integer >{

    List<Aluno> findAll();

    Aluno findByCodigo(int codigo);

    List<Aluno> findByOrderByNome();

    List<Aluno> findByNomeContaining(String termo);

    List<Aluno> findByNomeStartsWith(String termo);

    List<Aluno> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(media) FROM alunos", nativeQuery = true)
    double somaMedias();

    @Query(value = "SELECT * FROM alunos WHERE media >= :nota", nativeQuery = true)
    List<Aluno> mediaMaiorIgual(double nota);

    int countByCodigo(int codigo);
} 
