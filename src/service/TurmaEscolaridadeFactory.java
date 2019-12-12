/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ativadi.model.TurmaPrototype;
import ativadi.model.TurmaEscolaridade;

/**
 *
 * @author Caio
 */
public class TurmaEscolaridadeFactory implements TurmaFactory {

    @Override
    public TurmaPrototype criarTurma() {
        TurmaEscolaridade turma = new TurmaEscolaridade();
        return turma.clone();
    }
    
}
