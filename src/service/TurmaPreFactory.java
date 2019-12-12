/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ativadi.model.TurmaPrototype;
import ativadi.model.TurmaPre;

/**
 *
 * @author Caio
 */
public class TurmaPreFactory implements TurmaFactory {

    @Override
    public TurmaPrototype criarTurma() {
        TurmaPre turma = new TurmaPre();
        return turma.clone();
    }
    
}
