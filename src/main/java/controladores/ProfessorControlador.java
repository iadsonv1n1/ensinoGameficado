package controladores;

import dominio.Professor;
import repositorio.ProfessorRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class ProfessorControlador implements Controlador<Professor> {

    @Override
    public void cadastrar(List<String> dados) {
        ProfessorRepo professorRepo = ProfessorRepo.getInstance();
        professorRepo.salvar(new Professor(dados.get(0), dados.get(1)));
        System.out.println("Professor salvo!");
    }

    @Override
    public void listar() {
        ProfessorRepo professorRepo = ProfessorRepo.getInstance();
        System.out.println(professorRepo.buscarTodos());
    }

    @Override
    public Professor buscar(String nome) {
        try {
            ProfessorRepo professorRepo = ProfessorRepo.getInstance();
            return professorRepo.buscarProfessorPorNome(nome);
        } catch (NoSuchElementException e) {
            System.out.print("Professor não encontrado");
            return null;
        }
    }

}
