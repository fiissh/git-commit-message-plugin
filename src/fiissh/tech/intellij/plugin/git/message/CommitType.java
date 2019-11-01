package fiissh.tech.intellij.plugin.git.message;

/**
 * @author fiissh.zhao
 */
final class CommitType {
    public CommitType(String type, String title, String description) {
        this.type = type;
        this.title = title;
        this.description = description;
    }

    String type;
    String title;
    String description;

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.type, this.title, this.description);
    }
}
