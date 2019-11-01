package fiissh.tech.intellij.plugin.git.message;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

/**
 * @author fiissh.zhao
 */
final class CommitMessage {

    /**
     * why max line length is 72 , see <a>https://stackoverflow.com/a/2120040/5138796</a>
     */
    private static final int MAX_LINE_LENGTH = 72;
    private final String commitContent;

    /**
     * @param type    type
     * @param scope   scope
     * @param subject
     * @param body
     */
    CommitMessage(CommitType type, String scope, String subject, String body) {
        this.commitContent = buildCommitContent(type, scope, subject, body);
    }

    /**
     * build commit message content. normative git commit message content for example:
     *
     * <p>
     * # head: <type>(<scope>): <subject>
     * # - type: feat, fix, docs, style, refactor, test, chore
     * # - scope: can be empty (eg. if the change is a global or difficult to assign to a single component)
     * # - subject: start with verb (such as 'change'), 50-character line
     * #
     * # body: 72-character wrapped. This should answer:
     * # * Why was this change necessary?
     * # * How does it address the problem?
     * # * Are there any side effects?
     * #
     * # footer:
     * # - Include a link to the ticket, if any.
     * # - BREAKING CHANGE
     * #
     *
     * @param type
     * @param scope
     * @param subject
     * @param body
     * @return
     */
    private String buildCommitContent(CommitType type, String scope, String subject, String body) {

        StringBuilder builder = new StringBuilder();
        builder.append('[').append(type.type).append(']');
        if (StringUtils.isNotBlank(scope)) {
            builder.append('(').append(scope).append(')');
        }

        if (StringUtils.isNotBlank(subject)) {
            builder.append(": ").append(subject);
        }

        if (StringUtils.isNotBlank(body)) {
            builder.append(System.lineSeparator()).append(WordUtils.wrap(body, MAX_LINE_LENGTH));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return commitContent;
    }
}