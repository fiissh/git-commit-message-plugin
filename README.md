插件名称：`git commit message creator`

安装方式： `IDEA` 和 `Android Studio` 插件管理页搜索 `git commit message creator` 安装。

插件地址：

使用 `IDEA` 和 `Android Studio` 图形化 `GIT` 工具提交代码时，可以使用该插件生成标准的规范化提交信息。

插件根据 [commitizen/conventional-commit-types](https://github.com/commitizen/conventional-commit-types) 提供了默认的 `commit type` 的实现。如果您认为默认的 `commit type` 不能满足您的需求，你可以通过在项目根目录创建 `git_commit_message_creator.json` 文件，并修改其中的内容即可：

```json
{
  "plugin_name": "git commit message creator", //the display name of the plugin window
  "commit_type": [
    {
      "type": "FEATURE",
      "title": "Features",
      "description": "A new feature"
    },
    {
      "type": "FIX",
      "title": "Bug Fixes",
      "description": "A bug fix"
    },
    {
      "type": "IMPROVEMENT",
      "title": "Improvements",
      "description": "An improvement to a current feature"
    },
    {
      "type": "DOCS",
      "title": "Documentation",
      "description": "Documentation only changes"
    },
    {
      "type": "STYLE",
      "title": "Styles",
      "description": "Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"
    },
    {
      "type": "REFACTOR",
      "title": "Code Refactoring",
      "description": "A code change that neither fixes a bug nor adds a feature"
    },
    {
      "type": "PERFORMANCE",
      "title": "Performance Improvements",
      "description": "A code change that improves performance"
    },
    {
      "type": "TEST",
      "title": "Tests",
      "description": "Adding missing tests or correcting existing tests"
    },
    {
      "type": "BUILD",
      "title": "Builds",
      "description": "Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)"
    },
    {
      "type": "CI",
      "title": "Continuous Integrations",
      "description": "Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)"
    },
    {
      "type": "CHORE",
      "title": "Chores",
      "description": "Other changes that don't modify src or test files"
    },
    {
      "type": "REVERT",
      "title": "Reverts",
      "description": "Reverts a previous commit"
    }
  ]
}
```

![](https://s2.ax1x.com/2019/11/01/K7NM34.png)
![](https://s2.ax1x.com/2019/11/01/K7NQgJ.png)

## 特别感谢

* [RmondJone/Commit-Message-Plugin](https://github.com/RmondJone/Commit-Message-Plugin)：借鉴了该项目的布局文件
* [commitizen/conventional-commit-types](https://github.com/commitizen/conventional-commit-types)：借鉴了该项目给出的 `Commit Type` 并作为项目中的默认数据

## 关于作者

肥肥鱼（`fiissh.tech`），`Android SDK` 开发者，个人博客 [肥言肥语](https://fiissh.tech)。如果您有关于项目的任何问题，请发邮件给我：`zhaoyongchun2010@gmail.com`。