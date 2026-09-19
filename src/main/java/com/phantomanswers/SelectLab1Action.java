package com.phantomanswers;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SelectLab1Action extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        System.out.println("HOTKEY LAB 1 PRESSED");

        if (!PhantomState.isSimulationMode()) {
            System.out.println("Simulation mode is OFF");
            return;
        }

        System.out.println("Simulation mode is ON");

        PhantomState.selectLab(1);

        System.out.println("Lab 1 selection finished");
    }
}