/*
 * Copyright (C) 2019 https://fiissh.tech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fiissh.tech.intellij.plugin.git.message;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vcs.CommitMessageI;
import com.intellij.openapi.vcs.VcsDataKeys;
import com.intellij.openapi.vcs.ui.Refreshable;

import org.jetbrains.annotations.Nullable;

/**
 * @author fiissh.zhao
 */
public class PluginAction extends AnAction implements DumbAware {

    @Override
    public void actionPerformed(AnActionEvent actionEvent) {
        final CommitMessageI commitPanel = getCommitPanel(actionEvent);
        if (commitPanel == null) {
            return;
        }

        CommitDialogPanel commitDialogPanel = new CommitDialogPanel(actionEvent.getProject());
        commitDialogPanel.show();
        if (commitDialogPanel.getExitCode() == DialogWrapper.OK_EXIT_CODE) {
            commitPanel.setCommitMessage(commitDialogPanel.getCommitMessage().toString());
        }
    }

    @Nullable
    private static CommitMessageI getCommitPanel(@Nullable AnActionEvent actionEvent) {
        if (actionEvent == null) {
            return null;
        }

        Refreshable panelKey = Refreshable.PANEL_KEY.getData(actionEvent.getDataContext());

        if (panelKey instanceof CommitMessageI) {
            return (CommitMessageI) panelKey;
        }
        return VcsDataKeys.COMMIT_MESSAGE_CONTROL.getData(actionEvent.getDataContext());
    }
}
