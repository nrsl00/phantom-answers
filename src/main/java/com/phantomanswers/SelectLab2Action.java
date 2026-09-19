package com.phantomanswers;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SelectLab2Action extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        if (!PhantomState.isSimulationMode()) {
            return;
        }

        PhantomState.selectLab(2);

        System.out.println("Phantom Answers: Lab 2 selected");
    }
}
