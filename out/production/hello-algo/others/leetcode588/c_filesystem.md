# LeetCode 588

题目：LeetCode 588. Design In-Memory File System
题目描述： 设计一个内存文件系统，支持以下操作：
- mkdir(path, value)：如果路径不存在，则创建目录。注意这里的value在原题中并没有明确用途，我们可以忽略它。
- ls(path)：如果路径是目录，返回该目录下的所有子目录和文件的名称列表（相对路径）。
- addContentToFile(file_path, content)：向指定路径的文件追加内容。如果路径不存在，会在路径上创建一个新文件。
- readContentFromFile(file_path)：读取并返回文件的内容。

以下是Java实现的部分设计步骤及代码：

```java


import java.util.*;

class FileSystem {
    // 使用HashMap模拟文件系统结构，键为路径，值为Node对象表示目录或文件
    private Map<String, Node> fileSystem = new HashMap<>();

    class Node {
        String type; // "dir" 或 "file"
        StringBuilder content; // 文件内容，仅当type为"file"时有效
        Map<String, Node> children; // 子节点，仅当type为"dir"时有效

        Node(String type) {
            this.type = type;
            if (type.equals("file")) {
                this.content = new StringBuilder();
            } else {
                this.children = new HashMap<>();
            }
        }
    }

    public FileSystem() {}

    // 创建目录
    public void mkdir(String path) {
        if (!path.startsWith("/") || path.contains("//") || path.endsWith("/")) {
            throw new IllegalArgumentException("Invalid path");
        }
        String[] dirs = path.substring(1).split("/");
        Node current = fileSystem.get("/");
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if (i == dirs.length - 1) { // 最后一个元素是目录名
                if (!current.children.containsKey(dir)) {
                    current.children.put(dir, new Node("dir"));
                }
            } else {
                if (!current.children.containsKey(dir)) {
                    current.children.put(dir, new Node("dir"));
                    current = current.children.get(dir);
                } else {
                    current = current.children.get(dir);
                }
            }
        }
    }

    // 列出目录下的所有文件和子目录
    public List<String> ls(String path) {
        if (!path.startsWith("/") || !fileSystem.containsKey("/") || !isDirectory(path)) {
            return Collections.emptyList();
        }
        Node node = fileSystem.get(path);
        return new ArrayList<>(node.children.keySet());
    }

    // 向文件添加内容
    public void addContentToFile(String filePath, String content) {
        if (!filePath.startsWith("/") || !isValidPath(filePath) || isDirectory(filePath)) {
            throw new IllegalArgumentException("Invalid file path or it's a directory.");
        }
        Node fileNode = getOrCreateFileNode(filePath);
        fileNode.content.append(content);
    }

    // 读取文件内容
    public String readContentFromFile(String filePath) {
        if (!filePath.startsWith("/") || !isValidPath(filePath) || !isFile(filePath)) {
            throw new NoSuchElementException("File does not exist.");
        }
        Node fileNode = fileSystem.get(filePath);
        return fileNode.content.toString();
    }

    // 检查路径是否为有效的非空目录路径
    private boolean isDirectory(String path) {
        return isValidPath(path) && fileSystem.get(path).type.equals("dir");
    }

    // 检查路径是否为有效的文件路径
    private boolean isFile(String path) {
        return isValidPath(path) && fileSystem.get(path).type.equals("file");
    }

    // 检查路径是否有效且存在
    private boolean isValidPath(String path) {
        return fileSystem.containsKey(path) && !path.endsWith("/");
    }

    // 获取或创建目标文件的Node对象
    private Node getOrCreateFileNode(String filePath) {
        String[] dirs = filePath.substring(1).split("/");
        Node current = fileSystem.get("/");
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if (i == dirs.length - 1) {
                if (!current.children.containsKey(dir)) {
                    current.children.put(dir, new Node("file"));
                }
                return current.children.get(dir);
            } else {
                if (!current.children.containsKey(dir)) {
                    current.children.put(dir, new Node("dir"));
                }
                current = current.children.get(dir);
            }
        }
        return null; // 这里不会执行到，仅为了编译通过
    }
}

```

这段代码实现了一个基于内存的文件系统，其中每个节点（Node）代表一个目录或文件，并通过HashMap存储它们之间的关系。根据题目要求，我们实现了四个方法分别对应题目中的四种操作

