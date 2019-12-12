/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.model;

import Banco.BancoSingleton;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public class TurmaEscolaridade extends TurmaPrototype {
    private BancoSingleton banco = BancoSingleton.getInstance();

    public TurmaEscolaridade(String escolaridade, String observacao, String semestre, int ano, int professorID) {
        super(escolaridade, observacao, semestre, ano, professorID);
    }

    public TurmaEscolaridade() {
    }

    protected TurmaEscolaridade(TurmaEscolaridade aThis) {
       
    }

    
    @Override
    public void criarTurma(TurmaPrototype turma) {
        String sql = "INSERT INTO turma (codigo_turma, escolaridade, semestre, ano, observacao, professorID)"
                + " VALUES ('"+turma.getCodTurma()+"','ESCOLARIDADE','"+turma.getSemestre()+"','"
                +turma.getAno()+"','"+turma.getObservacao()+"','"+turma.getProfessorID()+"');";
        try {
            banco.executarSQL(sql);
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Bd!");
            Logger.getLogger(TurmaPrototype.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
            Logger.getLogger(TurmaPrototype.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TurmaPrototype clone() {
        return new TurmaEscolaridade(this);
    }
    
}
