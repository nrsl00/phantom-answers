package com.phantomanswers;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SelectLab3Action extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        if (!PhantomState.isSimulationMode()) {
            return;
        }

        PhantomState.selectLab(3);

        System.out.println("Phantom Answers: Lab 3 selected");
    }
}