/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ativadi.model.Turma;
import ativadi.model.TurmaEscolaridade;

/**
 *
 * @author Caio
 */
public class TurmaEscolaridadeFactory implements TurmaFactory {

    @Override
    public Turma criarTurma() {
       return new TurmaEscolaridade();
    }
    
}
