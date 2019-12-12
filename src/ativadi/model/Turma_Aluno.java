/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.model;

import Banco.BancoSingleton;

/**
 *
 * @author Caio
 */
public class Turma_Aluno {
    private int id;
    private int turmaID;
    private int alunoID;
    private BancoSingleton banco = BancoSingleton.getInstance();

    public Turma_Aluno() {
    }

    public Turma_Aluno(int id, int turmaID, int alunoID) {
        this.id = id;
        this.turmaID = turmaID;
        this.alunoID = alunoID;
    }

    public Turma_Aluno(int turmaID, int alunoID) {
        this.turmaID = turmaID;
        this.alunoID = alunoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurmaID() {
        return turmaID;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
    }

    public int getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(int alunoID) {
        this.alunoID = alunoID;
    }
    
}
