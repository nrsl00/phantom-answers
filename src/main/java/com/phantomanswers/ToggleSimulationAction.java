package com.phantomanswers;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import org.jetbrains.annotations.NotNull;

public class ToggleSimulationAction extends AnAction {

    static {

        EditorActionManager actionManager =
                EditorActionManager.getInstance();

        TypedAction typedAction =
                actionManager.getTypedAction();

        TypedActionHandler originalHandler =
                typedAction.getHandler();

        typedAction.setupHandler(
                new PhantomTypedHandler(originalHandler)
        );
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        PhantomState.toggleMode();

        String mode;

        if (PhantomState.isSimulationMode()) {
            mode = "SIMULATION";
        } else {
            mode = "NORMAL";
        }

        new Notification(
                "Phantom Answers",
                "Phantom mode: " + mode,
                NotificationType.INFORMATION
        ).notify(e.getProject());
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}