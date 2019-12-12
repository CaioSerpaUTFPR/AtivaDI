/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.model;

import Banco.BancoSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public abstract class TurmaPrototype {
    private int id;
    private String escolaridade;
    private String observacao;
    private String semestre;
    private int ano;
    private int professorID;
    private String codTurma;
    private String nomeProfessor;
    private BancoSingleton banco = BancoSingleton.getInstance();

    public TurmaPrototype(){
        
    }
    public TurmaPrototype(int id, String escolaridade, String observacao, String semestre, int ano, int professorID, String codTurma) {
        this.id = id;
        this.escolaridade = escolaridade;
        this.observacao = observacao;
        this.semestre = semestre;
        this.ano = ano;
        this.professorID = professorID;
        this.codTurma = codTurma;
    }

    public TurmaPrototype(String escolaridade, String observacao, String semestre, int ano, int professorID, String codTurma) {
        this.escolaridade = escolaridade;
        this.observacao = observacao;
        this.semestre = semestre;
        this.ano = ano;
        this.professorID = professorID;
        this.codTurma = codTurma;
    }

    public TurmaPrototype(String escolaridade, String observacao, String semestre, int ano, int professorID) {
        this.escolaridade = escolaridade;
        this.observacao = observacao;
        this.semestre = semestre;
        this.ano = ano;
        this.professorID = professorID;
    }
    
    public abstract TurmaPrototype clone();
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    public void criarTurma(TurmaPrototype turma){
     
    }
    public List<TurmaPrototype> getAllClientes(){
        List<TurmaPrototype> turmas = new ArrayList<>();
        ResultSet response = null;
        String sql = "SELECT t.id, t.codigo_turma, t.escolaridade, t.semestre, t.ano, t.observacao, t.professorID, p.nome\n" +
"FROM turma t, professor p\n" +
"WHERE t.professorID = p.id;";
        try {
            response = banco.executarSQLRetorno(sql);
            while(response.next()){
                TurmaPre turma = new TurmaPre(response.getInt("id"), response.getString("escolaridade"), 
                        response.getString("observacao"), response.getString("semestre"), 
                        response.getInt("ano"), response.getInt("professorID"), response.getString("codigo_turma"));
                turma.setNomeProfessor(response.getString("nome"));
                turmas.add(turma);
        }
            return turmas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Bd!");
            Logger.getLogger(TurmaPrototype.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
            Logger.getLogger(TurmaPrototype.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmas;  
    }
    
}
