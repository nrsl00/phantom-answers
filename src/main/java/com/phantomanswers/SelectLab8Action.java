package com.phantomanswers;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SelectLab8Action extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (!PhantomState.isSimulationMode()) {
            return;
        }

        PhantomState.selectLab(8);
    }
}
