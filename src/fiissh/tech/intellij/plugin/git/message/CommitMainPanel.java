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
