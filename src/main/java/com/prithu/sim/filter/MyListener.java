/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.filter;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author lion
 */
public class MyListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        System.out.println("AFTER PHASE ID:- " + phaseEvent.getPhaseId().toString());
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("BEFORE PHASE ID:- " + phaseEvent.getPhaseId().toString());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
