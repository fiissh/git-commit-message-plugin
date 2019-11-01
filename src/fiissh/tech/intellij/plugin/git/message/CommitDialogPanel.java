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

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;

import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;

/**
 * CommitDialogPanel
 *
 * @author fiissh.zhao
 */
public class CommitDialogPanel extends DialogWrapper {

    private final CommitMainPanel commitMainPanel;

    CommitDialogPanel(@Nullable Project project) {
        super(project);

        PluginMessage pluginMessage = PluginMessage.getPluginMessage(project);

        commitMainPanel = new CommitMainPanel(pluginMessage);
        if (!StringUtils.isEmpty(pluginMessage.error)) {
            commitMainPanel.setErrorMessage(pluginMessage.error);
        }

        setTitle(StringUtils.isEmpty(pluginMessage.plugin_name) ? Command.DEFAULT_PLUGIN_NAME : pluginMessage.plugin_name);
        setOKButtonText(Command.DEFAULT_MAIN_PANEL_OK_BUTTON);
        setCancelButtonText(Command.DEFAULT_MAIN_PANEL_CANCEL_BUTTON);

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return commitMainPanel.getMainPanel();
    }

    CommitMessage getCommitMessage() {
        return commitMainPanel.getCommitMessage();
    }

}
