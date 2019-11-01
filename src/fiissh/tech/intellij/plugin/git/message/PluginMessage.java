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
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import okio.BufferedSource;
import okio.Okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fiissh.zhao
 */
final class PluginMessage {
    String plugin_name;
    List<CommitType> commit_type;
    String error;

    public PluginMessage() {
        this.plugin_name = Command.DEFAULT_PLUGIN_NAME;
        this.commit_type = getDefaultCommitTypes();
        error = Command.ERROR_MESSAGE;
    }


    private static List<CommitType> getDefaultCommitTypes() {
        List<CommitType> commitTypes = new ArrayList<>();

        for (Command.DefaultCommitType commitType : Command.DefaultCommitType.values()) {
            commitTypes.add(new CommitType(commitType.name(), commitType.title, commitType.description));
        }
        return commitTypes;
    }

    static PluginMessage getPluginMessage(Project project) {
        // 读项目中的配置
        BufferedSource bufferedSource = null;
        File file = new File(project.getBasePath() + File.separator + Command.DEFAULT_JSON_FILE_NAME);
        if (file.exists()) {
            try {
                try {
                    VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(file);
                    virtualFile.refresh(false, true);
                    bufferedSource = Okio.buffer(Okio.source(file));
                } catch (FileNotFoundException e) {
                    bufferedSource = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                bufferedSource = null;
            }
        }

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<PluginMessage> messageAdapter = moshi.adapter(PluginMessage.class);
        PluginMessage pluginMessage;

        try {
            // 兜底策略
            if (bufferedSource == null) {
                pluginMessage = messageAdapter.fromJson(Command.DEFAULT_JSON);
            } else {
                pluginMessage = messageAdapter.fromJson(bufferedSource);
            }
        } catch (Exception e) {
            // 最后的兜底策略
            pluginMessage = new PluginMessage();
        }

        return pluginMessage;
    }
}
