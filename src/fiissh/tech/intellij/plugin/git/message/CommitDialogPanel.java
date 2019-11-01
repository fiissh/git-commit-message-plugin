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
