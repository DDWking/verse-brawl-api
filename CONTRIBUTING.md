# 团队协作指南

## 提交代码流程

我们使用 **Pull Request (PR)** 的方式提交代码，不能直接推送到 `master` 分支。

### 1. 克隆仓库

```bash
git clone git@github.com:DDWking/verse-brawl-api.git
cd verse-brawl-api
```

### 2. 创建新分支

每次开发新功能或修复 bug，都要创建新分支：

```bash
# 切换到 master 分支并拉取最新代码
git checkout master
git pull origin master

# 创建新分支（分支名要有意义）
git checkout -b feature/功能名称
# 或
git checkout -b fix/bug描述
# 或
git checkout -b refactor/重构描述
```

**分支命名规范：**
- `feature/xxx` - 新功能
- `fix/xxx` - 修复 bug
- `refactor/xxx` - 重构代码
- `docs/xxx` - 文档更新

### 3. 编写代码并提交

```bash
# 查看修改了哪些文件
git status

# 添加所有修改
git add .

# 或者添加指定文件
git add src/main/java/com/example/xxx.java

# 提交（写清楚做了什么）
git commit -m "feat: 添加用户登录接口"
# 或
git commit -m "fix: 修复登录验证的bug"
```

**提交信息规范：**
- `feat: xxx` - 新功能
- `fix: xxx` - 修复 bug
- `refactor: xxx` - 重构
- `docs: xxx` - 文档
- `style: xxx` - 代码格式（不影响功能）
- `test: xxx` - 测试相关

### 4. 推送到远程

```bash
git push origin feature/功能名称
```

### 5. 创建 Pull Request

1. 打开 GitHub 仓库页面
2. 会看到提示 "Create a pull request"，点击它
3. 填写 PR 标题和描述：
   - 标题：简述做了什么
   - 描述：详细说明改动内容
4. 点击 **Create pull request**

### 6. 等待审批

- PR 创建后，CI 检查会自动运行
- 需要至少 1 人审批通过
- 审批通过后，点击 **Merge** 合并代码

### 7. 合并后清理

```bash
# 切回 master 并拉取最新代码
git checkout master
git pull origin master

# 删除本地已合并的分支
git branch -d feature/功能名称

# 删除远程分支（如果还存在）
git push origin --delete feature/功能名称
```

---

## 常用 Git 命令

```bash
# 查看当前状态
git status

# 查看提交历史
git log --oneline

# 查看文件修改内容
git diff

# 撤销未暂存的修改
git checkout -- 文件名

# 撤销已暂存但未提交的修改
git reset HEAD 文件名

# 拉取远程最新代码
git pull origin master

# 暂存当前修改（切换分支前）
git stash

# 恢复暂存的修改
git stash pop
```

---

## 注意事项

1. **禁止直接推送到 master**，必须通过 PR 合并
2. **每次 PR 只做一件事**，不要混合多个功能
3. **提交前先拉取最新代码**，避免冲突
4. **写清楚提交信息**，让其他人知道你做了什么
5. **代码要能编译通过**，不要提交有错误的代码

---

## 遇到冲突怎么办

当你的分支和 master 有冲突时：

```bash
# 先拉取最新 master
git checkout master
git pull origin master

# 切回你的分支
git checkout feature/功能名称

# 合并 master 到你的分支
git merge master

# 手动解决冲突（IDE 会标记冲突文件）
# 解决后提交
git add .
git commit -m "merge: 解决冲突"
git push origin feature/功能名称
```

---

## 项目结构

```
verse-brawl-api/
├── src/main/java/com/ddw/verse_brawl_web/
│   ├── controller/    # 接口控制器
│   ├── service/       # 业务逻辑
│   ├── mapper/        # 数据库操作
│   ├── entity/        # 实体类
│   ├── config/        # 配置类
│   └── utils/         # 工具类
├── src/main/resources/
│   ├── application.yml      # 开发环境配置
│   └── application-prod.yml # 生产环境配置
└── pom.xml           # Maven 依赖
```

---

## 联系方式

有问题联系：@DDWking