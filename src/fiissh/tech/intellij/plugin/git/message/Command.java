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

/**
 * @author fiissh.zhao
 */
final class Command {
    static final String DEFAULT_JSON = "{\n" +
            "  \"plugin_name\": \"git commit message creator\",\n" +
            "  \"commit_type\": [\n" +
            "    {\n" +
            "      \"type\": \"FEATURE\",\n" +
            "      \"title\": \"Features\",\n" +
            "      \"description\": \"A new feature\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"FIX\",\n" +
            "      \"title\": \"Bug Fixes\",\n" +
            "      \"description\": \"A bug fix\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"IMPROVEMENT\",\n" +
            "      \"title\": \"Improvements\",\n" +
            "      \"description\": \"An improvement to a current feature\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"DOCS\",\n" +
            "      \"title\": \"Documentation\",\n" +
            "      \"description\": \"Documentation only changes\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"STYLE\",\n" +
            "      \"title\": \"Styles\",\n" +
            "      \"description\": \"Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"REFACTOR\",\n" +
            "      \"title\": \"Code Refactoring\",\n" +
            "      \"description\": \"A code change that neither fixes a bug nor adds a feature\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"PERFORMANCE\",\n" +
            "      \"title\": \"Performance Improvements\",\n" +
            "      \"description\": \"A code change that improves performance\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"TEST\",\n" +
            "      \"title\": \"Tests\",\n" +
            "      \"description\": \"Adding missing tests or correcting existing tests\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"BUILD\",\n" +
            "      \"title\": \"Builds\",\n" +
            "      \"description\": \"Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"CI\",\n" +
            "      \"title\": \"Continuous Integrations\",\n" +
            "      \"description\": \"Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"CHORE\",\n" +
            "      \"title\": \"Chores\",\n" +
            "      \"description\": \"Other changes that don't modify src or test files\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"REVERT\",\n" +
            "      \"title\": \"Reverts\",\n" +
            "      \"description\": \"Reverts a previous commit\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    static final String DEFAULT_JSON_FILE_NAME = "git_commit_message_creator.json";
    static final String ERROR_MESSAGE = "can't find git_commit_message_creator.json in project root directory,using default";
    static final String DEFAULT_PLUGIN_NAME = "git commit message creator";

    static final String DEFAULT_MAIN_PANEL_OK_BUTTON = "OK";
    static final String DEFAULT_MAIN_PANEL_CANCEL_BUTTON = "CANCEL";

    /**
     * default commit type
     */
    enum DefaultCommitType {
        /**
         * Features
         */
        FEATURE("Features", "A new feature"),
        /**
         * Bug Fixes
         */
        FIX("Bug Fixes", "A bug fix"),
        /**
         * Improvements
         */
        IMPROVEMENT("Improvements", "An improvement to a current feature"),
        /**
         * Documentation
         */
        DOCS("Documentation", "Documentation only changes"),
        /**
         * Styles
         */
        STYLE("Styles", "Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"),
        /**
         * Code Refactoring
         */
        REFACTOR("Code Refactoring", "A code change that neither fixes a bug nor adds a feature"),
        /**
         * Performance Improvements
         */
        PERFORMANCE("Performance Improvements", "A code change that improves performance"),
        /**
         * Tests
         */
        TEST("Tests", "Adding missing tests or correcting existing tests"),
        /**
         * Builds
         */
        BUILD("Builds", "Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)"),
        /**
         * Continuous Integrations
         */
        CI("Continuous Integrations", "Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)"),
        /**
         * Chores
         */
        CHORE("Chores", "Other changes that don't modify src or test files"),
        /**
         * Reverts
         */
        REVERT("Reverts", "Reverts a previous commit");

        public final String title;
        public final String description;

        DefaultCommitType(String title, String description) {
            this.title = title;
            this.description = description;
        }
    }
}
