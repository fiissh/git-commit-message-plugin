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

import javax.swing.*;

/**
 * @author fiissh.zhao
 */
public class CommitMainPanel {


    /**
     * 提交类型，参考模板文件 或者 https://github.com/commitizen/conventional-commit-types/blob/master/index.json
     */
    private JComboBox commitTypeComboBox;
    /**
     * 影响范围，
     */
    private JTextField commitScopeTextField;
    /**
     * 简要描述，参考 https://stackoverflow.com/questions/2290016/git-commit-messages-50-72-formatting
     */
    private JTextField commitSubjectTextFiled;
    private JTextArea commitBodyTextArea;
    /**
     * 弹框主面板
     */
    private JPanel mainPanel;
    private JLabel errorMessageLabel;

    public void setErrorMessage(String errorMessage) {
        errorMessageLabel.setText(errorMessage);
    }

    public CommitMainPanel(PluginMessage pluginMessage) {
        for (CommitType commitType : pluginMessage.commit_type) {
            commitTypeComboBox.addItem(commitType);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public CommitMessage getCommitMessage() {
        return new CommitMessage((CommitType) commitTypeComboBox.getSelectedItem(), commitScopeTextField.getText().trim(), commitSubjectTextFiled.getText().trim(), commitBodyTextArea.getText().trim());
    }
}
