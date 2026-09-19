package com.phantomanswers;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class PhantomTypedHandler implements TypedActionHandler {

    private final TypedActionHandler originalHandler;

    public PhantomTypedHandler(TypedActionHandler originalHandler) {
        this.originalHandler = originalHandler;
    }

    @Override
    public void execute(
            @NotNull Editor editor,
            char typedCharacter,
            @NotNull DataContext dataContext
    ) {

        // NORMAL — IntelliJ работает совершенно обычно
        if (!PhantomState.isSimulationMode()) {
            originalHandler.execute(
                    editor,
                    typedCharacter,
                    dataContext
            );
            return;
        }

        // Simulation включён, но лаборатория ещё не выбрана
        if (!PhantomState.hasNextCharacter()) {
            return;
        }

        Project project = editor.getProject();

        if (project == null) {
            return;
        }

        char phantomCharacter =
                PhantomState.getNextCharacter();

        Document document =
                editor.getDocument();

        CaretModel caretModel =
                editor.getCaretModel();

        int offset =
                caretModel.getOffset();

        WriteCommandAction.runWriteCommandAction(
                project,
                () -> {

                    document.insertString(
                            offset,
                            String.valueOf(phantomCharacter)
                    );

                    caretModel.moveToOffset(
                            offset + 1
                    );
                }
        );
    }
}